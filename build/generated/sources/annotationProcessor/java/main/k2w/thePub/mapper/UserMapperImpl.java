package k2w.thePub.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import k2w.thePub.dto.OrderDTO;
import k2w.thePub.dto.UserDTO;
import k2w.thePub.entity.OrderEntity;
import k2w.thePub.entity.UserEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T20:31:53+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserDTO source) {
        if ( source == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( source.getId() );
        userEntity.setName( source.getName() );
        userEntity.setActive( source.isActive() );
        userEntity.setWallet( source.getWallet() );
        userEntity.setDateOfBirth( source.getDateOfBirth() );

        return userEntity;
    }

    @Override
    public UserDTO toDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setOrders( orderEntityListToOrderDTOList( user.getOrderEntities() ) );
        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setActive( user.isActive() );
        userDTO.setWallet( user.getWallet() );
        userDTO.setDateOfBirth( user.getDateOfBirth() );

        return userDTO;
    }

    @Override
    public OrderDTO toDTO(OrderEntity order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserId( orderUserId( order ) );
        orderDTO.setId( order.getId() );
        orderDTO.setProductName( order.getProductName() );
        orderDTO.setAmount( order.getAmount() );
        orderDTO.setPrice( order.getPrice() );

        return orderDTO;
    }

    protected List<OrderDTO> orderEntityListToOrderDTOList(List<OrderEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDTO> list1 = new ArrayList<OrderDTO>( list.size() );
        for ( OrderEntity orderEntity : list ) {
            list1.add( toDTO( orderEntity ) );
        }

        return list1;
    }

    private Long orderUserId(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }
        UserEntity user = orderEntity.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
