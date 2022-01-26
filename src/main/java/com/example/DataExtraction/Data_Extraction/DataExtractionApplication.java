package com.example.DataExtraction.Data_Extraction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class DataExtractionApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(DataExtractionApplication.class, args);
//	}

	public static void main(String[] args) {
		SpringApplication.run(DataExtractionApplication.class, args);
	}

}
