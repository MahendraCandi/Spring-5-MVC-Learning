package com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.model.Pizza;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfView extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pizza pizza = (Pizza) map.get("pizza");

        PdfPTable table = new PdfPTable(3);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(BaseColor.GRAY);

        table.addCell("Name");
        table.addCell("Flavour");
        table.addCell("Toppings");

        table.addCell(pizza.getName());
        table.addCell(pizza.getFlavour());

        StringBuilder builder = new StringBuilder();
        for (String s : pizza.getToppings()) {
            builder.append(s);
            builder.append(" ");
        }
        table.addCell(builder.toString());

        document.add(table);
    }
}
