package com.bilgeadam.demo.Repository;

import com.bilgeadam.demo.Entities.Campaign;
import com.bilgeadam.demo.Enums.CampaignStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    // Kampanya başlığına göre kampanya arama
    List<Campaign> findByTitle(String title);

    // Kampanya durumuna göre kampanya arama
    List<Campaign> findByStatus(CampaignStatus status);

    // Kampanya başlığı ve açıklamasına göre kampanya arama (mükerrer kontrolü için kullanılabilir)
    List<Campaign> findByTitleAndDescription(String title, String description);

    // Kampanya ID'sine göre kampanya arama
    // JpaRepository zaten findById metodunu sağlar, bu yüzden bu metoda gerek yok.
}
