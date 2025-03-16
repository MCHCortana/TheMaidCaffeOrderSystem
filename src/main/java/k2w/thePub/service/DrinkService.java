package k2w.thePub.service;

import k2w.thePub.dto.DrinkDTO;
import k2w.thePub.entity.DrinkEntity;
import k2w.thePub.entity.repository.DrinkRepository;
import k2w.thePub.entity.repository.OrderRepository;
import k2w.thePub.mapper.DrinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DrinkMapper drinkMapper;

    public List<DrinkDTO> getAll() {
        return drinkRepository.findAll().
                stream()
                .map(entity -> drinkMapper.toDTO(entity))
                .toList();
    }

    public DrinkDTO create(DrinkDTO data ){
        DrinkEntity entity = drinkMapper.toEntity(data);
        entity = drinkRepository.save(entity);
        return drinkMapper.toDTO(entity);
    }

}
