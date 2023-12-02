package com.example.jsonexercise.domain.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersWithProductsWrapperDto {

    private Integer usersCount;

    private List<UserWithProductsDto> users;

    public UsersWithProductsWrapperDto(List<UserWithProductsDto> users) {
        this.users = users;
        this.usersCount=users.size();
    }
}
