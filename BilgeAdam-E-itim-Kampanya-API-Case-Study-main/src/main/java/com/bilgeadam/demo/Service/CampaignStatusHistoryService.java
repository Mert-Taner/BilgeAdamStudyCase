package com.bilgeadam.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilgeadam.demo.DTO.CampaignStatusHistoryDTO;
import com.bilgeadam.demo.Entities.CampaignStatusHistory;
import com.bilgeadam.demo.Repository.CampaignStatusHistoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampaignStatusHistoryService {

    private final CampaignStatusHistoryRepository campaignStatusHistoryRepository;

    @Autowired
    public CampaignStatusHistoryService(CampaignStatusHistoryRepository campaignStatusHistoryRepository) {
        this.campaignStatusHistoryRepository = campaignStatusHistoryRepository;
    }

    public List<CampaignStatusHistoryDTO> getCampaignStatusHistory(Long campaignId) {
        List<CampaignStatusHistory> historyList = campaignStatusHistoryRepository.findByCampaignId(campaignId);
        return historyList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CampaignStatusHistoryDTO convertToDTO(CampaignStatusHistory campaignStatusHistoryDTO) {
        return new CampaignStatusHistoryDTO(
                campaignStatusHistoryDTO.getId(),
                campaignStatusHistoryDTO.getCampaign().getId(),
                campaignStatusHistoryDTO.getStatus(),
                campaignStatusHistoryDTO.getTimestamp()
        );
    }
}
