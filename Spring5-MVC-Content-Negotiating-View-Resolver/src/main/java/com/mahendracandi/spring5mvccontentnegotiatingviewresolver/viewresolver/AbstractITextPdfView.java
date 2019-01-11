package com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

public abstract class AbstractITextPdfView extends AbstractView {

    public AbstractITextPdfView() {
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // IE workaround: write into byte array first.
        ByteArrayOutputStream baos = createTemporaryOutputStream();

        // apply any preferences and build metadata
        Document document = newDocument();
        PdfWriter writer = newPdfWriter(document, baos);
        prepareWriter(model, writer, httpServletRequest);
        buildPdfMetadata(model, document, httpServletRequest);

        // Build PDF document
        document.open();
        buildPdfDocument(model, document, writer, httpServletRequest, httpServletResponse);
        document.close();

        // Flush to HTTP Response
        writeToResponse(httpServletResponse, baos);


    }

    protected Document newDocument(){
        return new Document(PageSize.A4);
    }

    protected  PdfWriter newPdfWriter(Document document, OutputStream outputStream) throws DocumentException {
        return PdfWriter.getInstance(document, outputStream);
    }

    protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request)
            throws DocumentException {

        writer.setViewerPreferences(getViewerPreferences());
    }

    protected int getViewerPreferences(){
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request){

    }

    protected  abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                              HttpServletRequest request, HttpServletResponse response) throws Exception;

}
