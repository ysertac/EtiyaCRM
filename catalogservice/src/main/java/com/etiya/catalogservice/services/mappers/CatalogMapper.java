package com.etiya.catalogservice.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class CatalogMapper {

    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);
}
