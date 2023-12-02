package com.example.jsonexercise.domain.dtos.users;

import com.example.jsonexercise.domain.dtos.products.ProductsSoldWithCountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWithProductsDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private ProductsSoldWithCountDto products;
}
