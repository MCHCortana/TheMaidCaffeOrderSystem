package k2w.thePub.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import k2w.thePub.dto.DrinkDTO;
import k2w.thePub.dto.OrderDTO;
import k2w.thePub.entity.DrinkEntity;
import k2w.thePub.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T20:31:53+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class DrinkMapperImpl implements DrinkMapper {

    @Override
    public DrinkEntity toEntity(DrinkDTO source) {
        if ( source == null ) {
            return null;
        }

        DrinkEntity drinkEntity = new DrinkEntity();

        drinkEntity.setId( source.getId() );
        drinkEntity.setProductName( source.getProductName() );
        drinkEntity.setPrice( source.getPrice() );
        drinkEntity.setForAdult( source.isForAdult() );

        return drinkEntity;
    }

    @Override
    public DrinkDTO toDTO(DrinkEntity drink) {
        if ( drink == null ) {
            return null;
        }

        DrinkDTO drinkDTO = new DrinkDTO();

        drinkDTO.setOrders( orderEntityListToOrderDTOList( drink.getOrderEntities() ) );
        drinkDTO.setId( drink.getId() );
        drinkDTO.setProductName( drink.getProductName() );
        drinkDTO.setPrice( drink.getPrice() );
        drinkDTO.setForAdult( drink.isForAdult() );

        return drinkDTO;
    }

    @Override
    public OrderDTO toDTO(OrderEntity order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setDrinkId( orderDrinkId( order ) );
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
