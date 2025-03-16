package k2w.thePub.service;

import k2w.thePub.dto.OrderDTO;
import k2w.thePub.entity.DrinkEntity;
import k2w.thePub.entity.OrderEntity;
import k2w.thePub.entity.UserEntity;
import k2w.thePub.entity.repository.DrinkRepository;
import k2w.thePub.entity.repository.OrderRepository;
import k2w.thePub.entity.repository.UserRepository;
import k2w.thePub.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private DrinkService drinkService;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().
                stream()
                .map(entity ->
                        orderMapper.toDTO(entity))
                .toList();
    }

    public OrderDTO create(OrderDTO data) {
        OrderEntity entity = orderMapper.toEntity(data);

        DrinkEntity drink = drinkRepository.findById(data.getDrinkId())
                .orElseThrow(() -> new RuntimeException("Drink not found"));
        UserEntity user = userRepository.findById(data.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (drink.isForAdult() && !(user.getDateOfBirth().until(LocalDate.now()).getYears() >= 18)) {
            throw new RuntimeException("Drink is only for adults.");
        }

        double orderPrice = drink.getPrice() * data.getAmount();

        if (user.getWallet() < orderPrice) {
            throw new RuntimeException("Cannot afford order");
        }

        user.setWallet(user.getWallet() - orderPrice);
        entity.setPrice(orderPrice);
        entity.setDrink(drink);
        entity.setUser(user);
        entity.setProductName(drink.getProductName());
        entity = orderRepository.save(entity);
        System.out.println(drink.getId() + "ID DRINKU");
        return orderMapper.toDTO(entity);
    }

    public List<OrderDTO> getOrdersByUser(Long userId) {
        List<OrderEntity> listOfOrdersForUser = orderRepository.findByUserId(userId);
        return listOfOrdersForUser.stream().map(order ->
                new OrderDTO(
                        order.getId(),
                        order.getProductName(),
                        order.getAmount(),
                        order.getPrice(),
                        order.getUser().getId(),
                        order.getDrink().getId())).collect(Collectors.toList());
    }

}
