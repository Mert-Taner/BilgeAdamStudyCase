package com.bilgeadam.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bilgeadam.demo.DTO.CampaignDTO;
import com.bilgeadam.demo.DTO.CampaignStatusDTO;
import com.bilgeadam.demo.DTO.CampaignStatusHistoryDTO;
import com.bilgeadam.demo.Service.CampaignService;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/campaign")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;

    }

    @PostMapping("/create")
    public ResponseEntity<CampaignDTO> createCampaign(@RequestBody CampaignDTO campaignDTO) {
        CampaignDTO createdCampaign = campaignService.createCampaign(campaignDTO);
        return ResponseEntity.ok(createdCampaign);
    }

    @PostMapping("/updateState")
    public ResponseEntity<CampaignDTO> updateCampaignState(@RequestBody CampaignStatusDTO campaignStatusDTO) {
        CampaignDTO updatedCampaign = campaignService.updateCampaignStatus(campaignStatusDTO);
        return ResponseEntity.ok(updatedCampaign);
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<CampaignStatusDTO>> getCampaignStatistics() {
        List<CampaignStatusDTO> statistics = campaignService.getCampaignStatistics();
        return ResponseEntity.ok(statistics);
    }

    @GetMapping("/{campaignId}/statusHistory")
    public ResponseEntity<List<CampaignStatusHistoryDTO>> getCampaignStatusHistory(@PathVariable Long campaignId) {
        List<CampaignStatusHistoryDTO> statusHistory = campaignService.getCampaignStatusHistory(campaignId);
        return ResponseEntity.ok(statusHistory);
    }
}