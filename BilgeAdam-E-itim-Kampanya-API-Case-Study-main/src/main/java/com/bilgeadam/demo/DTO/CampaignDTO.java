package com.bilgeadam.demo.DTO;

import com.bilgeadam.demo.Enums.CampaignCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CampaignDTO {

    @NotBlank
    @Size(min = 10, max = 50, message = "Başlık 10 ile 50 karakter arasında olmalıdır.")
    private String title;

    @NotBlank
    @Size(min = 20, max = 200, message = "Açıklama 20 ile 200 karakter arasında olmalıdır.")
    private String description;

    @NotNull
    private CampaignCategory category;


    public CampaignDTO() {}

    public CampaignDTO(String title, String description, CampaignCategory category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    // Getter ve Setter

    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getDescription() {
        return description;

    }

    public void setDescription(String description) {
        this.description = description;

    }

    public CampaignCategory getCategory() {
        return category;

    }

    public void setCategory(CampaignCategory category) {
        this.category = category;

    }
}
