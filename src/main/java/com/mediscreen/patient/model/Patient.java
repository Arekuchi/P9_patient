package com.mediscreen.patient.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="given_name")
    private String givenName;
    @Column(name="family_name")
    private String familyName;
    @Column(name="birthdate")
    private String birthdate;
    @Column(name="sex")
    private String sex;
    @Column(name="home_address")
    private String homeAddress;
    @Column(name="phone_number")
    private String phoneNumber;


    public Patient() {
    }

    public Patient(Long id, String givenName, String familyName, String birthdate, String sex, String homeAddress, String phoneNumber) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.birthdate = birthdate;
        this.sex = sex;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
