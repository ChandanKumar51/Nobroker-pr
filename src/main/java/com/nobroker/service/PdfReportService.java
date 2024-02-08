package com.nobroker.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.nobroker.entity.User;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfReportService {

    public byte[] generatePdfReport(List<User> users) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDocument = new PdfDocument(writer);
             Document document = new Document(pdfDocument)) {

            document.add(new Paragraph("User Report").setTextAlignment(TextAlignment.CENTER));

            // Create table
            Table table = new Table(4); // Adjust the number of columns as per your requirement

            // Add table headers
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Email");
            table.addCell("Mobile");

            // Add user data to the table
            for (User user : users) {
                table.addCell(user.getId().toString());
                table.addCell(user.getName());
                table.addCell(user.getEmail());
                table.addCell(user.getMobile());
            }

            // Add the table to the document
            document.add(table);

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return outputStream.toByteArray();
    }
}
