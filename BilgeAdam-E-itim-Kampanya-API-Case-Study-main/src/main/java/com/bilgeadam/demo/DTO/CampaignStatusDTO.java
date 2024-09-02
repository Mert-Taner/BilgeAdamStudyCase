package com.bilgeadam.demo.DTO;

import com.bilgeadam.demo.Enums.CampaignStatus;
import jakarta.validation.constraints.NotNull;

public class CampaignStatusDTO {
private long Id;

    @NotNull
    private CampaignStatus status;


    public CampaignStatusDTO() {}

    public CampaignStatusDTO(CampaignStatus status) {
        this.status = status;
    }

    // Getter ve Setter

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }



    private Long Id() {
   return Id;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long Id){
        this.Id = Id;
    }
}
