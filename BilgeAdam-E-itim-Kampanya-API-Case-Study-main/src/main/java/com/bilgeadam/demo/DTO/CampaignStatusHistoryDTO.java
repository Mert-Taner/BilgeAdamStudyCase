package com.bilgeadam.demo.DTO;

import java.time.LocalDateTime;

import com.bilgeadam.demo.Enums.CampaignStatus;

public class CampaignStatusHistoryDTO {

    private Long campaignId;
    private CampaignStatus oldStatus;
    private CampaignStatus newStatus;
    private LocalDateTime updatedAt;

    public CampaignStatusHistoryDTO(Long campaignId, CampaignStatus oldStatus, CampaignStatus newStatus, LocalDateTime updatedAt) {
        this.campaignId = campaignId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.updatedAt = updatedAt;
    }

    public CampaignStatusHistoryDTO(Long id, Long id1, Object status, Object timestamp) {
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public CampaignStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(CampaignStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public CampaignStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(CampaignStatus newStatus) {
        this.newStatus = newStatus;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
