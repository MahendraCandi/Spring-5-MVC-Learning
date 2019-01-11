package com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver;

import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.model.Pizza;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelView extends AbstractXlsView {
    //private final static Logger log = Logger.getLogger(ExcelView.class);

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //log.info("MODEL IS EMPTY ? " + tor.isEmpty());

        Pizza pizza = (Pizza) model.get("pizza");

        Sheet sheet = workbook.createSheet("sheet 1");
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        Row row = null;
        Cell cell = null;
        int rowCount = 0;
        int colCount = 0;

        // create header cell
        row = sheet.createRow(rowCount++);

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Name");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Flavour");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("Toppings");

        // create data cells
        row = sheet.createRow(rowCount++);
        colCount = 0;
        row.createCell(colCount++).setCellValue(pizza.getName());
        row.createCell(colCount++).setCellValue(pizza.getFlavour());

        StringBuilder builder = new StringBuilder();
        for (String s : pizza.getToppings()) {
            builder.append(s);
            builder.append(" ");
        }
        row.createCell(colCount++).setCellValue(builder.toString());

        // auto size column
        for (int i = 0; i < 3; i++) sheet.autoSizeColumn(i, true);

    }
}
