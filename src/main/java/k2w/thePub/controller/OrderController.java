package k2w.thePub.controller;

import k2w.thePub.dto.OrderDTO;
import k2w.thePub.entity.repository.OrderRepository;
import k2w.thePub.mapper.OrderMapper;
import k2w.thePub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public  @ResponseBody List<OrderDTO> getAll(){
        return orderService.getAll();
    }

    @PostMapping("/order-create")
    public @ResponseBody OrderDTO create(@RequestBody OrderDTO data) {
        return orderService.create(data);
    }

    @PostMapping("/order-by-user")
    public @ResponseBody List<OrderDTO> getOrdersByUser(@RequestBody Long id){
        return orderService.getOrdersByUser(id);
    }
}
