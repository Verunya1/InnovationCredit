package com.example.innovationcredit.model.mapper;

import com.example.innovationcredit.dto.TariffDto;
import com.example.innovationcredit.model.entity.TariffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TariffMapperInterface {
   // @Mapping(source = "")
    TariffDto entityToDto(TariffEntity entity);
}
