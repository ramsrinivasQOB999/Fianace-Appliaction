package com.glow.business.service.mapper;

import com.glow.business.domain.Business;
import com.glow.business.service.dto.BusinessDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    BusinessDTO toDto(Business entity);

    Business toEntity(BusinessDTO dto);
}
