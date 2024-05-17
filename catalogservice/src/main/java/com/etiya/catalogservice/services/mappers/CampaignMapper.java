package com.etiya.catalogservice.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class CampaignMapper {

    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);
}
