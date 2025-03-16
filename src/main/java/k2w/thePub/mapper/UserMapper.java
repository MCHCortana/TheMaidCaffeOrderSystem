package k2w.thePub.mapper;

import k2w.thePub.dto.OrderDTO;
import k2w.thePub.dto.UserDTO;
import k2w.thePub.entity.OrderEntity;
import k2w.thePub.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDTO source);

    @Mapping(source = "orderEntities", target = "orders")
    UserDTO toDTO(UserEntity user);

    @Mapping(source = "user.id", target = "userId")
    OrderDTO toDTO(OrderEntity order);
}

