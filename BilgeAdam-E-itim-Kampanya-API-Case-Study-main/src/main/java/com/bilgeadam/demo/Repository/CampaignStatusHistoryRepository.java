package com.bilgeadam.demo.Repository;

import com.bilgeadam.demo.Entities.CampaignStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignStatusHistoryRepository extends JpaRepository<CampaignStatusHistory, Long> {

    // Belirli bir kampanyanın durum geçmişini listelemek için özel sorgu
    List<CampaignStatusHistory> findByCampaignId(Long campaignId);
}
