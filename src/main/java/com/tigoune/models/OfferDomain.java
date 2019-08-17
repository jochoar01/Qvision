package com.tigoune.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Modelo oferta económica */
public class OfferDomain {
    private String offerId;
    private String productName;
    private String techType;
    private String productUse;

    private List<OfferDomain> lstOffers = new ArrayList<>();

    private OfferDomain(Map<String, String> offerData) {
        this.offerId = offerData.get("oferta");
    }

    public OfferDomain(List<Map<String, String>> offerData){
        createConstructor(offerData);
    }

    public List<OfferDomain> getLstOffers() {
        return lstOffers;
    }

    private void createConstructor(List<Map<String, String>> offerData) {
        for (Map<String, String> data: offerData){
            lstOffers.add(new OfferDomain(data));
        }
    }
    public String getOfferId() {
        return offerId;
    }
    public String getProductName() {
        return productName;
    }
    public String getTechType() {
        return techType;
    }
    public String getproductUse() {
        return productUse;
    }

}

