package com.example.jsonexercise.domain.dtos.products;

import com.example.jsonexercise.domain.dtos.categories.CategoryDto;
import com.example.jsonexercise.domain.dtos.users.UserDto;
import com.example.jsonexercise.domain.entities.Category;
import com.example.jsonexercise.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private  String name;

    private BigDecimal price;

    private UserDto buyer;

    private UserDto seller;

    private Set<CategoryDto> categories;

    public ProductInRangeWithNoBayerDto toProductInRangeWithNoBayerDto(){
        return new ProductInRangeWithNoBayerDto(name, price, seller.getFullName());
    }
}
