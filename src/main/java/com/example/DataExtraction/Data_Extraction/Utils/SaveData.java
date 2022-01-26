package com.example.DataExtraction.Data_Extraction.Utils;

import com.example.DataExtraction.Data_Extraction.DAO.Sample;
import com.example.DataExtraction.Data_Extraction.Repository.SampleRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class SaveData {
    @Autowired
    SampleRepo sampleRepo;

    /**
     * The service class will invoke this storeData() method, further this method will call
     * saveData(), singleInput(), multipleInput() as per its convenience.
     * Database write and read is also done here in this program, to store the fetched data through the web scrapping.
     *
     * @param District
     * @param FName
     * @param Party
     * @param Office
     * @param Phone
     * @param CommitteeAssignment
     * @throws IOException
     */


    public void storeData(String District, String FName, String Party, String Office, String Phone, String CommitteeAssignment) throws IOException {
        List<String> CommitteeAssignmentList= new ArrayList<>();
        String committee[]= CommitteeAssignment.split(",  ,  ,");
        for (String s : committee) {
            CommitteeAssignmentList.add(s);
        }
        SaveData(District, FName, Party, Office, Phone, committee);
    }

    public void SaveData(String District, String FName, String Party, String Office, String Phone, String committee[]) throws IOException {

        District = District.replace("[","").replace("]","").trim();
        String d[]= District.split(",");

        FName= FName.replace("[","").replace("]","").trim();
        String n[]= FName.split(",");

        Party= Party.replace("[","").replace("]","").trim();
        String p[]= Party.split(",");

        Office= Office.replace("[","").replace("]","").trim();
        String o[]= Office.split(",");

        Phone= Phone.replace("[","").replace("]","").trim();
        String ph[]= Phone.split(",");
        long sizeD= d.length;

        if (sizeD > 1) {
            multipleInput(d,d.length,n,p,o,ph,committee);
        }
        else {
            singleInput(d,n,p,o,ph,committee);
        }
    }

    public void singleInput(String[] d, String[] n, String[] p, String[] o, String[] ph, String[] committee) throws IOException {
        Sample sample= new Sample();
        for (int i=0; i< n.length; i++) {
            if (!n[0].trim().equals("") && !n[1].trim().equals("")) {
                sample.setFirstname(n[0].trim());
                sample.setLastname(n[1].trim());
            }
        }
        sample.setDistrict(d[0]);
        sample.setParty(p[0]);
        sample.setRoom(o[0]);
        sample.setPhone(ph[0]);
        sample.setCommitteeAssignment(committee[0].replace(" ","").replace(", ,","").trim());
        sample.setCountry("United State Of America");
        sample.setType("Federal");
        sample.setUrl("https://www.house.gov/representatives");
        sampleRepo.save(sample);
    }

    public void multipleInput(String[] d, int length, String[] n, String[] p, String[] o, String[] ph, String[] committee) throws IOException {
        Sample sample = new Sample();
        for (int district=0, party=0, room=0, phone=0, comitee=0, index=0; (district < d.length && party < p.length &&
                room < o.length && phone < ph.length && comitee < committee.length); district++, party++,
                     room++, phone++, comitee++, index=index+2) {
            sample.setDistrict(d[district]);
            sample.setParty(p[party]);
            sample.setRoom(o[room]);
            sample.setPhone(ph[phone]);
            sample.setCommitteeAssignment(committee[comitee].replace(" ","").replace(", ,","").trim());
            sample.setCountry("United State Of America");
            sample.setType("Federal");
            sample.setUrl("https://www.house.gov/representatives");
            sample.setFirstname(n[index]);
            sample.setLastname(n[index+1]);
            sampleRepo.save(sample);
        }
    }
}
