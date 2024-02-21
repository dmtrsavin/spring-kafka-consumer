package ru.savin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.savin.dto.FoodOrderDto;
import ru.savin.entity.FoodOrder;

@Mapper(componentModel = "spring")
public interface FoodOrderMapper {
    FoodOrder mapToEntity(FoodOrderDto foodOrderDto);

    @Mapping(source = "message", target = "item")
    FoodOrderDto mapToDto(String message);
}
