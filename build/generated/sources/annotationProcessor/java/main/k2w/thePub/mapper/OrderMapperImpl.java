package k2w.thePub.mapper;

import javax.annotation.processing.Generated;
import k2w.thePub.dto.OrderDTO;
import k2w.thePub.entity.DrinkEntity;
import k2w.thePub.entity.OrderEntity;
import k2w.thePub.entity.UserEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T21:12:15+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity toEntity(OrderDTO source) {
        if ( source == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( source.getId() );
        orderEntity.setProductName( source.getProductName() );
        orderEntity.setAmount( source.getAmount() );
        orderEntity.setPrice( source.getPrice() );

        return orderEntity;
    }

    @Override
    public OrderDTO toDTO(OrderEntity order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserId( orderUserId( order ) );
        orderDTO.setDrinkId( orderDrinkId( order ) );
        orderDTO.setId( order.getId() );
        orderDTO.setProductName( order.getProductName() );
        orderDTO.setAmount( order.getAmount() );
        orderDTO.setPrice( order.getPrice() );

        return orderDTO;
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

    private Long orderDrinkId(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }
        DrinkEntity drink = orderEntity.getDrink();
        if ( drink == null ) {
            return null;
        }
        Long id = drink.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
