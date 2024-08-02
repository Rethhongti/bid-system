package com.api.bid_system.modules.bid.data;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BidMapper {
    BidMapper INSTANCE  = Mappers.getMapper(BidMapper.class);

    BidEntity toBidEntity(CreateBidRequestDto requestDto);
}
