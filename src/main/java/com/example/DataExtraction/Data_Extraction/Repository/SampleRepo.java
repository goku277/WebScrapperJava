package com.example.DataExtraction.Data_Extraction.Repository;

import com.example.DataExtraction.Data_Extraction.DAO.Sample;
//import com.example.DataExtraction.Data_Extraction.Model.Sample_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepo extends JpaRepository<Sample, Long> {
//    public Sample Save(Sample sample);
}