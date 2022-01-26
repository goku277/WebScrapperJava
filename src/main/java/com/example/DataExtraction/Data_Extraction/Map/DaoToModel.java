package com.example.DataExtraction.Data_Extraction.Map;

import com.example.DataExtraction.Data_Extraction.DAO.Sample;
import com.example.DataExtraction.Data_Extraction.Model.Samples_Model;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DaoToModel {
    public List<Samples_Model> convert(List<Sample> sample) {
        List<Samples_Model> samplesModelList= new ArrayList<>();
        for (Sample sample1 : sample) {
            Samples_Model samples_model= new Samples_Model();
            samples_model.setFirstname(sample1.getFirstname());
            samples_model.setLastname(sample1.getLastname());
            samples_model.setDistrict(sample1.getDistrict());
            samples_model.setParty(sample1.getParty());
            samples_model.setRoom(sample1.getRoom());
            samples_model.setPhone(sample1.getPhone());
            samples_model.setCommitteeAssignment(sample1.getCommitteeAssignment());
            samples_model.setType(sample1.getType());
            samples_model.setCountry(sample1.getCountry());
            samples_model.setUrl(sample1.getUrl());
            samplesModelList.add(samples_model);
        }
        return samplesModelList;
    }
}
