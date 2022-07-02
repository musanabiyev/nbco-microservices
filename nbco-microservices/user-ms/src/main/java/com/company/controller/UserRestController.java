package com.company.controller;

import com.company.dto.UserDTO;
import com.company.dto.request.CreateUserRequestDTO;
import com.company.dto.request.UpdateUserRequestDTO;
import com.company.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(value = "users", description = "Rest api for User Management")
@RestController
@RequestMapping("/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully User Created"),
            @ApiResponse(code = 400, message = "Invalid user object."),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(value = "/sign-up",
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(
            @Valid @RequestBody CreateUserRequestDTO createUserRequestDTO) {

        return ResponseEntity.ok(userService.createUser(createUserRequestDTO));
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid user object."),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    @PutMapping(path = {"/{id}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable(value = "id", required = true) Long userId,
            @Valid @RequestBody UpdateUserRequestDTO updateUserRequestDTO) {

        return ResponseEntity.ok(userService.updateUser(userId, updateUserRequestDTO));
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }


    @GetMapping("/profile/{id}")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable(value = "id", required = true) Long userId) {

        return ResponseEntity.ok(userService.getUserById(userId));
    }


    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(
            @PathVariable(value = "username", required = true) String username) {

        return ResponseEntity.ok(userService.findUserByUsername(username));
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable(value = "email", required = true) String email) {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }


    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteUser(
            @PathVariable(value = "id", required = true) Long userId) {

        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
