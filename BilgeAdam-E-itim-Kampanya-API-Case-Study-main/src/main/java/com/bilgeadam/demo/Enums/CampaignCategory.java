package com.bilgeadam.demo.Enums;


public enum CampaignCategory {
    BE("Bireysel Eğitim"),
    GE("Grup Eğitimleri"),
    KE("Kurumsal Eğitimler"),
    OE("Online Eğitimler"),
    DIGER("Diğer");

    private final String displayName;


    CampaignCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


