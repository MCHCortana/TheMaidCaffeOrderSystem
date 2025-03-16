package k2w.thePub.mapper;

import k2w.thePub.dto.DrinkDTO;
import k2w.thePub.dto.OrderDTO;
import k2w.thePub.dto.UserDTO;
import k2w.thePub.entity.DrinkEntity;
import k2w.thePub.entity.OrderEntity;
import k2w.thePub.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toEntity(OrderDTO source);
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "drink.id", target = "drinkId")
    OrderDTO toDTO(OrderEntity order);
}
