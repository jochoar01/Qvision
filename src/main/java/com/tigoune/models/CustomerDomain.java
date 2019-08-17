package com.tigoune.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Modelo creación cliente */

public class CustomerDomain {
    private String firstname;
    private String lastname;
    private String documentType;
    private String document;
    private String expeditionDate;
    private String phone;
    private String cellphone;
    private String email;
    private String dpto;
    private String city;
    private String neighborhood;
    private String address;
    private String sector;

    private List<CustomerDomain> lstCustomers = new ArrayList<>();

    private CustomerDomain(Map<String, String> customerData){
        this.firstname = customerData.get("firstname");
        this.lastname = customerData.get("lastname");
        this.documentType = customerData.get("documentType");
        this.document = customerData.get("document");
        this.expeditionDate = customerData.get("expeditionDate");
        this.phone =customerData.get("phone");
        this.cellphone = customerData.get("cellphone");
        this.email = customerData.get("email");
        this.dpto = customerData.get("dpto");
        this.city = customerData.get("city");
        this.neighborhood  = customerData.get("neighborhood");
        this.address = customerData.get("address");
        this.sector = customerData.get("sector");
    }
    public CustomerDomain(List<Map<String, String>> userData){
        createConstructor(userData);
    }

    public List<CustomerDomain> getLstUsers() {
        return lstCustomers;
    }

    private void createConstructor(List<Map<String, String>> customerData) {
        for (Map<String, String> data: customerData){
            lstCustomers.add(new CustomerDomain(data));
        }
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getDocumentType() {
        return documentType;
    }
    public String getDocument() {
        return document;
    }
    public String getExpeditionDate() {
        return expeditionDate;
    }
    public String getPhone() {
        return phone;
    }
    public String getCellphone() {
        return cellphone;
    }
    public String getEmail() {
        return email;
    }
    public String getDpto() {
        return dpto;
    }
    public String getCity() {
        return city;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public String getAddress() {
        return address;
    }
    public String getSector() {
        return sector;
    }
}

