package com.example.DataExtraction.Data_Extraction.Service;

import com.example.DataExtraction.Data_Extraction.DAO.Sample;
//import com.example.DataExtraction.Data_Extraction.Model.Sample_Model;
import com.example.DataExtraction.Data_Extraction.Map.DaoToModel;
import com.example.DataExtraction.Data_Extraction.Model.Samples_Model;
import com.example.DataExtraction.Data_Extraction.Repository.SampleRepo;
import com.example.DataExtraction.Data_Extraction.Utils.SaveData;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Service
public class WebScrapperService {
    @Autowired
    SampleRepo sampleRepo;
    @Autowired
    DaoToModel daoToModel;
    @Autowired
    SaveData saveData;

//    @Autowired
//    Sample sample;

//    private  Sample sample= new Sample();

//    private List<Sample_Model> sampleList;

    public ResponseEntity<?> fetchData() throws IOException {
        String url= "https://www.house.gov/representatives";
        try {
            Document doc = Jsoup.connect(url).get();
            System.out.printf("Title: %s\n", doc.title());

            /**
             *  Using Elements class's getElementsByClass(), we are fetching the table, where the <table class="table",
             *  provided in the page source.
             *  This, in this way we fetch the fields such as District, Party, Name, etc.
             *
             *  In the Element level, getElementsByClass() fetched the field's content's by using the class's values,
             *  as taken from the page source
             */

            Elements repositories = doc.getElementsByClass("table");

            for (Element repository : repositories) {
                String District = repository.getElementsByClass("views-field views-field-value-2").eachText() + "\t\t";
                District = District.replace("District,","").trim();
                String FName = repository.getElementsByClass("views-field views-field-value-4 views-field-value-5").eachText() + "\t\t";

                FName= FName.replace("Name,","").trim();
                String Party= repository.getElementsByClass("views-field views-field-value-7").eachText() + "\t\t";
                Party= Party.replace("Party,","").trim();
                String Office= repository.getElementsByClass("views-field views-field-value-8 views-field-value-9").eachText() + "\t\t";
                Office= Office.replace("Office,","").trim();

                String Phone= repository.getElementsByClass("views-field views-field-value-10").eachText() + "\t\t";
                Phone= Phone.replace("Phone,","").trim();
                String CommitteeAssignment= repository.getElementsByClass("views-field views-field-markup").html().strip();

                CommitteeAssignment= CommitteeAssignment.replace("Committee Assignment","").replace(",","").replace("<ul>","").replace("<li>","")
                .replace("</ul>","").replace("</li>","").replace("\n"," , ").trim();
                CommitteeAssignment= CommitteeAssignment + " , ";

                saveData.storeData(District,FName,Party,Office,Phone,CommitteeAssignment);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Sample> samples= sampleRepo.findAll();

        List<Samples_Model> samplesModelList= daoToModel.convert(samples);

        /**
         *  Using Gson a json file is created at the end of this fetchData(), and this json file whatever
         *  created, has replicated the sample "sample.json" file as given along with the task, for reference.
         */

        Gson gson= new Gson();
        gson.toJson(samplesModelList,
                new FileWriter("D:\\MyFolder__All Files\\Internshala\\Data_Extraction\\Data_Extraction\\src\\main\\java\\com\\example\\DataExtraction\\Data_Extraction\\Service\\sample.json"));
        return ResponseEntity.status(HttpStatus.OK).body(samplesModelList);
    }
}