package com.example.DataExtraction.Data_Extraction.Controller;

import com.example.DataExtraction.Data_Extraction.Service.WebScrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("webscrapping/v1/")
public class WebScrapper {
    @Autowired
    WebScrapperService webScrapperService;
    @GetMapping("receive/data/")
    public ResponseEntity<?> receiveDataFromInternet() throws IOException {
        return webScrapperService.fetchData();
    }
}
