package k2w.thePub.service;

import k2w.thePub.dto.UserDTO;
import k2w.thePub.entity.UserEntity;
import k2w.thePub.entity.repository.OrderRepository;
import k2w.thePub.entity.repository.UserRepository;
import k2w.thePub.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    public List<UserDTO> getAll() {
        return userRepository.findAll().
                stream()
                .map(entity -> userMapper.toDTO(entity))
                .toList();
    }

    public UserDTO create(UserDTO data) {
        UserEntity entity = userMapper.toEntity(data);
        entity = userRepository.save(entity);
        return userMapper.toDTO(entity);
    }

    public UserDTO findUser(Long id) {
        UserEntity foundUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(foundUser);
    }


}
