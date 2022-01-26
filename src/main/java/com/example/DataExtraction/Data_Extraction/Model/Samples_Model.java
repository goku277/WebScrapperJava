package com.example.DataExtraction.Data_Extraction.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Samples_Model {
    private String firstname;
    private String lastname;
    private String district;
    private String party;
    private String room;
    private String phone;
    private String committeeAssignment;
    private String type;
    private String country;
    private String url;
}
