package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.users.UsersWithProductsWrapperDto;
import com.example.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;
import com.example.jsonexercise.domain.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UsersWithSoldProductsDto> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName() throws IOException;

    UsersWithProductsWrapperDto usersAndProducts() throws IOException;
}
