package com.nobroker.controller;

import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;
import com.nobroker.service.PdfReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pdf")
public class PdfReportController {

    @Autowired
    private PdfReportService pdfReportService;

    @Autowired
    private UserRepository userRepository; // Assuming UserRepository is your JPA repository for User entity

    //http://localhost:8080/api/pdf/generate
    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdfReport() {
        List<User> users = userRepository.findAll();
        byte[] pdfBytes = pdfReportService.generatePdfReport(users);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "user_report.pdf");
        headers.setContentLength(pdfBytes.length);

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
