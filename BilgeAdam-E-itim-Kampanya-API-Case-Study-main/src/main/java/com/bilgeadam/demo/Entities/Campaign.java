package com.bilgeadam.demo.Entities;

import com.bilgeadam.demo.Enums.CampaignCategory;
import com.bilgeadam.demo.Enums.CampaignStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Kampanya")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampaignCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampaignStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Campaign() {
    }

    public Campaign(String title, String description, CampaignCategory category, CampaignStatus status) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters ve Setters
    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void updateCampaignDetails(String newTitle, String newDescription, CampaignCategory newCategory) {
        this.title = newTitle;
        this.description = newDescription;
        this.category = newCategory;
        updateCampaignStatus();
        this.updatedAt = LocalDateTime.now();
    }

    // Statü kontrolü yapan metot
    private void updateCampaignStatus() {
        if (this.category == CampaignCategory.BE || this.category == CampaignCategory.OE
                || this.category == CampaignCategory.DIGER) {
            if (this.status == CampaignStatus.AKTIF || this.status == CampaignStatus.ONAY_BEKLIYOR) {
                this.status = CampaignStatus.ONAY_BEKLIYOR;
            }
        } else {
            if (this.status == CampaignStatus.ONAY_BEKLIYOR) {
                this.status = CampaignStatus.AKTIF;
            }
        }
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
