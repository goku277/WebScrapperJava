package com.example.DataExtraction.Data_Extraction.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sample")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "district")
    private String district;
    @Column(name = "party")
    private String party;
    @Column(name = "room")
    private String room;
    @Column(name = "phone")
    private String phone;
    @Column(name = "committee_assignment")
    private String committeeAssignment;
    @Column(name = "type")
    private String type;
    @Column(name = "country")
    private String country;
    @Column(name = "url")
    private String url;
}
