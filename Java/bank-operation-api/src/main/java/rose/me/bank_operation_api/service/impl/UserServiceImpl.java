package rose.me.bank_operation_api.service.impl;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import rose.me.bank_operation_api.domain.model.User;
import rose.me.bank_operation_api.domain.model.repository.UserRepository;
import rose.me.bank_operation_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}