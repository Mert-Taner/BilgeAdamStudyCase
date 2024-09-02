package com.bilgeadam.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bilgeadam.demo.DTO.CampaignDTO;
import com.bilgeadam.demo.DTO.CampaignStatusDTO;
import com.bilgeadam.demo.DTO.CampaignStatusHistoryDTO;
import com.bilgeadam.demo.Entities.Campaign;
import com.bilgeadam.demo.Entities.CampaignStatusHistory;
import com.bilgeadam.demo.Enums.CampaignStatus;
import com.bilgeadam.demo.Repository.CampaignRepository;
import com.bilgeadam.demo.Repository.CampaignStatusHistoryRepository;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository, CampaignStatusHistoryRepository campaignStatusHistoryRepository) {
        this.campaignRepository = campaignRepository;
    }

    public CampaignDTO createCampaign(CampaignDTO campaignDTO) {
        Campaign campaign = new Campaign(
                campaignDTO.getTitle(),
                campaignDTO.getDescription(),
                campaignDTO.getCategory(),
                CampaignStatus.ONAY_BEKLIYOR);

        Campaign savedCampaign = campaignRepository.save(campaign);
        return convertToDTO(savedCampaign);
    }

    public CampaignDTO updateCampaignStatus(CampaignStatusDTO campaignStatusDTO) {
        Optional<Campaign> campaignOpt = campaignRepository.findById(campaignStatusDTO.getId()); // CampaignStatusDTO id
                                                                                                 // eklenmeli

        if (campaignOpt.isPresent()) {
            Campaign campaign = campaignOpt.get();
            campaign.setStatus(campaignStatusDTO.getStatus());
            campaign.setUpdatedAt(java.time.LocalDateTime.now());
            campaignRepository.save(campaign);
            return convertToDTO(campaign);
        } else {
            throw new RuntimeException("Campaign not found");
        }
    }

    private CampaignDTO convertToDTO(Campaign campaign) {
        return new CampaignDTO(
                campaign.getTitle(),
                campaign.getDescription(),
                campaign.getCategory());
    }

    public List<CampaignStatusDTO> getCampaignStatistics() {

        return List.of();
    }

    public List<CampaignStatusHistoryDTO> getCampaignStatusHistory(Long campaignId) {

        return List.of();
    }

}