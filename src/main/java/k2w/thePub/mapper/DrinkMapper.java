package k2w.thePub.mapper;

import k2w.thePub.dto.DrinkDTO;
import k2w.thePub.dto.OrderDTO;
import k2w.thePub.entity.DrinkEntity;
import k2w.thePub.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DrinkMapper {
    DrinkEntity toEntity(DrinkDTO source);

    @Mapping(source = "orderEntities", target = "orders")
    DrinkDTO toDTO(DrinkEntity drink);

    @Mapping(source = "drink.id", target = "drinkId")
    OrderDTO toDTO(OrderEntity order);
}
