package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.CampaignProductOffer;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.CreatedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.DeletedCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetAllCampaignProductOfferResponse;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.GetCampaignProductOfferResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CampaignProductOfferMapper {

    CampaignProductOfferMapper INSTANCE = Mappers.getMapper(CampaignProductOfferMapper.class);

    @Mapping(source = "campaignProductOffer.campaign.id", target = "campaignId")
    @Mapping(source = "campaignProductOffer.productOffer.id", target = "productOfferId")
    GetAllCampaignProductOfferResponse getAllCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaignProductOffer.campaign.id", target = "campaignId")
    @Mapping(source = "campaignProductOffer.productOffer.id", target = "productOfferId")
    GetCampaignProductOfferResponse getCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "createCampaignProductOfferRequest.campaignId", target = "campaign.id")
    @Mapping(source = "createCampaignProductOfferRequest.productOfferId", target = "productOffer.id")
    CampaignProductOffer campaignProductOfferFromCreateCampaignProductOfferRequest(CreateCampaignProductOfferRequest createCampaignProductOfferRequest);
    @Mapping(source = "campaignProductOffer.campaign.id", target = "campaignId")
    @Mapping(source = "campaignProductOffer.productOffer.id", target = "productOfferId")
    CreatedCampaignProductOfferResponse createdCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaignProductOffer.campaign.id", target = "campaignId")
    @Mapping(source = "campaignProductOffer.productOffer.id", target = "productOfferId")
    DeletedCampaignProductOfferResponse deletedCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
}
