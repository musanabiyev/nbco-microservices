package com.company.dto.converter;

import com.company.domain.User;
import com.company.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOConverter {

    public UserDTO convert(User from) {
        return new UserDTO(
                from.getId(),
                from.getFirstname(),
                from.getLastname(),
                from.getUsername(),
                from.getEmail(),
                from.getPhoneNumber(),
                from.getCreationDate(),
                from.getUpdatedAt());
    }

    public List<UserDTO> convert(List<User> fromList) {
        return fromList.stream()
                .map(from -> new UserDTO(
                        from.getId(),
                        from.getFirstname(),
                        from.getLastname(),
                        from.getUsername(),
                        from.getEmail(),
                        from.getPhoneNumber(),
                        from.getCreationDate(),
                        from.getUpdatedAt()))
                .collect(Collectors.toList());
    }

}