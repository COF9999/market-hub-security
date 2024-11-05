package com.markethub.security.genesis_guard.infraestructure.rest.controllers;


import com.markethub.security.genesis_guard.domain.dtos.user.UserRequestDto;
import com.markethub.security.genesis_guard.domain.dtos.user.UserResponseDto;
import com.markethub.security.genesis_guard.infraestructure.aspects.interceptables.PreInterceptor;
import com.markethub.security.genesis_guard.infraestructure.globalbeans.SpringConfigBeans;
import com.markethub.security.genesis_guard.infraestructure.aspects.interceptables.InterceptableIndermitateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserControllerRest {

    private final RestTemplate restTemplate;

    private final String baseUriUserKernel = "/user";

    public UserControllerRest(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @PreInterceptor
    @InterceptableIndermitateException
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDto){
            return ResponseEntity.ok(restTemplate.postForObject(SpringConfigBeans.urlBaseKernel+baseUriUserKernel+"/register",
                    userRequestDto,
                    UserResponseDto.class));

    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id){
        return null;
    }

    @PostMapping("/")
    public UserResponseDto createUser(@RequestBody UserRequestDto user){
        return null;
    }

    @PutMapping("/")
    public UserResponseDto updateUser(@RequestBody UserRequestDto user){
        return null;
    }

    @DeleteMapping("/{id}")
    public UserResponseDto deleteUser(@PathVariable Long id){
        return null;
    }

    @GetMapping("/my-products/id")
    public List<UserResponseDto> findAllmyProducts(@PathVariable Long id){
        return null;
    }

    /*

    Recordar hacer

    @PostMapping("/my-points")
    public PointsDto getMyPoints(@RequestBody TokenDto tokenDto){
        return pointsService.findPointsByUser(tokenDto);
    }

     */
}
