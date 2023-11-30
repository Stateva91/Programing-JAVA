package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;
import com.example.jsonexercise.domain.entities.User;
import com.example.jsonexercise.reposiitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constant.Paths.USERS_WITH_SOLD_PRODUCTS_JSON_PATH;
import static com.example.jsonexercise.constant.Utils.MODEL_MAPPER;
import static com.example.jsonexercise.constant.Utils.writeJsonIntoFile;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UsersWithSoldProductsDto> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName() throws IOException {
      final  List<UsersWithSoldProductsDto> usersWithSoldProductsDtoList = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UsersWithSoldProductsDto.class))
                .collect(Collectors.toList());
      writeJsonIntoFile(usersWithSoldProductsDtoList, USERS_WITH_SOLD_PRODUCTS_JSON_PATH);
    return usersWithSoldProductsDtoList;

    }
}
