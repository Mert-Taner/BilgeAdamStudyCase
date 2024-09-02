package com.bilgeadam.demo.Entities;

import com.bilgeadam.demo.Enums.CampaignStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign_status_history")
public class CampaignStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false) // Use this annotation to map the relationship
    private Campaign campaign;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampaignStatus oldStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampaignStatus newStatus;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private CampaignStatus status;

    public CampaignStatusHistory(LocalDateTime timestamp, CampaignStatus status, Campaign campaign,
                                 CampaignStatus oldStatus, CampaignStatus newStatus) {
        this.timestamp = timestamp;
        this.status = status;
        this.campaign = campaign;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    // Getter methods, if needed, should be added here
}