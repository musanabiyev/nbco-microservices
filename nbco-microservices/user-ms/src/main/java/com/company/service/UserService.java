package com.company.service;

import com.company.domain.User;
import com.company.dto.UserDTO;
import com.company.dto.converter.UserDTOConverter;
import com.company.dto.request.CreateUserRequestDTO;
import com.company.dto.request.UpdateUserRequestDTO;
import com.company.exception.UserExistException;
import com.company.exception.UserNotFoundException;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOConverter userDTOConverter;
    private final BCryptPasswordEncoder cryptPasswordEncoder;


    public UserDTO createUser(CreateUserRequestDTO createUserRequestDTO) {
        validateUser(createUserRequestDTO.getEmail(),
                createUserRequestDTO.getUsername(), createUserRequestDTO.getPhone());

        User user =
                User.builder()
                        .firstname(createUserRequestDTO.getFirstname())
                        .lastname(createUserRequestDTO.getLastname()).
                        username(createUserRequestDTO.getUsername())
                        .password(cryptPasswordEncoder.encode(createUserRequestDTO.getPassword()))
                        .phoneNumber(createUserRequestDTO.getPhone())
                        .creationDate(LocalDateTime.now())
                        .build();

        return userDTOConverter.convert(userRepository.save(user));
    }


    public List<UserDTO> getAllUser() {
        return userDTOConverter.convert(userRepository.findAll());
    }

    public UserDTO updateUser(Long userId, UpdateUserRequestDTO updateUserRequestDTO) {
        if (userRepository.existsById(userId) == false) {
            throw new UserNotFoundException("User couldn't be found by following id:");
        }

        validateUser(updateUserRequestDTO.getEmail(),
                updateUserRequestDTO.getUsername(), updateUserRequestDTO.getPhone());

        User user =
                User.builder()
                        .id(userId).firstname(updateUserRequestDTO.getFirstname())
                        .lastname(updateUserRequestDTO.getLastname())
                        .username(updateUserRequestDTO.getUsername())
                        .phoneNumber(updateUserRequestDTO.getPhone())
                        .updatedAt(LocalDateTime.now())
                        .build();

        return userDTOConverter.convert(userRepository.save(user));
    }

    public UserDTO getUserById(Long id) {
        return userDTOConverter.convert(userRepository.getById(id));
    }

    private User getUserByPhone(String phone) {
        return userRepository.findUserByPhone(phone);
    }

    public UserDTO findUserByUsername(String username) {
        return userDTOConverter.convert(userRepository.findUserByUsername(username)
                .orElseThrow(() ->
                        new UserNotFoundException("User couldn't be found by following username: " + username)));
    }


    public UserDTO findUserByEmail(String email) {
        return userDTOConverter.convert(userRepository.findUserByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User couldn't be found by following email: " + email)));
    }


    private void validateUser(String email, String username, String phone) {

        if (userRepository.existsByUsername(username))
            throw new UserExistException("User exist by following username");

        if (userRepository.existsByEmail(email))
            throw new UserExistException("User exist by following email");

        if (userRepository.existsByPhone(phone))
            throw new UserExistException("User exist by following phone number");
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
