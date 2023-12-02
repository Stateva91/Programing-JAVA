package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.users.UserDto;
import com.example.jsonexercise.domain.dtos.users.UserWithProductsDto;
import com.example.jsonexercise.domain.dtos.users.UsersWithProductsWrapperDto;
import com.example.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;
import com.example.jsonexercise.reposiitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constant.Paths.USERS_AND_PRODUCTS_JSON_PATH;
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
        final List<UsersWithSoldProductsDto> usersWithSoldProductsDtoList = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UsersWithSoldProductsDto.class))
                .collect(Collectors.toList());
        writeJsonIntoFile(usersWithSoldProductsDtoList, USERS_WITH_SOLD_PRODUCTS_JSON_PATH);
        return usersWithSoldProductsDtoList;
    }

        @Override
        public UsersWithProductsWrapperDto usersAndProducts() throws IOException {
            final List<UserWithProductsDto> usersAndProducts =
                    this.userRepository
                            .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
                            .orElseThrow(NoSuchElementException::new)
                            .stream()
                            .map(user -> MODEL_MAPPER.map(user, UserDto.class))
                            .map(UserDto::toUserWithProductsDto)
                            .collect(Collectors.toList());
            final UsersWithProductsWrapperDto usersWithProductsWrapperDto = new UsersWithProductsWrapperDto((usersAndProducts));

            writeJsonIntoFile(usersAndProducts, USERS_AND_PRODUCTS_JSON_PATH);
            return usersWithProductsWrapperDto;
        }
    }
