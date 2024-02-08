package com.nobroker.controller;

import com.nobroker.service.ExcelExporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/excel")
public class ExcelExportController {

    @Autowired
    private ExcelExporterService excelExporterService;

    //http://localhost:8080/api/excel/download
    @GetMapping("/download")
    public ResponseEntity<byte[]> exportToExcel() throws IOException {
       byte[]  excelBytes = excelExporterService.exportUsersToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment","user.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(excelBytes);
    }
}
