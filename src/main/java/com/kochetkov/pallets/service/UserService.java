package com.kochetkov.pallets.service;

import com.kochetkov.pallets.DTO.UserDTO;
import com.kochetkov.pallets.domain.User;
import com.kochetkov.pallets.exeption.AlreadyExistException;
import com.kochetkov.pallets.exeption.ResourceNotFoundException;
import com.kochetkov.pallets.mapper.UserMapper;
import com.kochetkov.pallets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private List<UserDTO> getAll() {
        return allToDTO(userRepository.findAll());
    }

    private UserDTO getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return toDTO(user.get());
        }
        throw new ResourceNotFoundException("User with id = "+ id + " not found", "");
    }

    private UserDTO create(UserDTO userDTO) {
        if (!userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            userRepository.save(toEntity(userDTO));
            return toDTO(userRepository.findByUsername(userDTO.getUsername()).get());
        }
        throw new AlreadyExistException("User with name = " + userDTO.getUsername() + " already exist", "");
    }

    private UserDTO update(UserDTO userDTO) {
        if (!userRepository.findById(userDTO.getId()).isPresent()) {
            userRepository.save(toEntity(userDTO));
            return toDTO(userRepository.getById(userDTO.getId()));
        }
        throw new ResourceNotFoundException("User with id = "+ userDTO.getId() + " not found", "");
    }

    public boolean deleteById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return false;
        }
        userRepository.delete(user.get());
        return true;
    }

    //TODO Возможно тут надо отлавливать если пытаешься удалить связанные обьекты

    public User getCurrentUser() {
        UserDetails securityUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(securityUser.getUsername()).get();
    }

    private User toEntity(UserDTO userDTO) {
        return UserMapper.USER_MAPPER.toEntity(userDTO);
    }
    private UserDTO toDTO(User user) {
        return UserMapper.USER_MAPPER.toDTO(user);
    }
    private List<User> allToEntity(List<UserDTO> userDTOList) {
        return UserMapper.USER_MAPPER.allToEntity(userDTOList);
    }
    private List<UserDTO> allToDTO(List<User> userList) {
        return UserMapper.USER_MAPPER.allToDTO(userList);
    }
}
