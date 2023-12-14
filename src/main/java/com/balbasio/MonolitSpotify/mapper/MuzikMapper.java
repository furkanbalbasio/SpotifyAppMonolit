package com.balbasio.MonolitSpotify.mapper;

import com.balbasio.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.balbasio.MonolitSpotify.repository.entity.Muzik;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MuzikMapper {

    MuzikMapper INSTANCE = Mappers.getMapper(MuzikMapper.class);

//    @Mappings({
//            @Mapping(target = "",source = ""),
//            @Mapping(target = "",source = ""),
//            @Mapping(target = "",source = "")
//    })
    Muzik muzikFromDto(final SaveMuzikRequestDto dto);
}
