package com.example.jsonexercise.domain.dtos.users;

import com.example.jsonexercise.domain.dtos.products.ProductBasicInfo;
import com.example.jsonexercise.domain.dtos.products.ProductDto;
import com.example.jsonexercise.domain.dtos.products.ProductsSoldWithCountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private Integer age;

    private Set<ProductDto> sellingProducts;

    private Set<ProductDto> boughtProducts;

    private Set<UserDto> friends;

    public String getFullName(){
        return firstName + " " + lastName;

    }
    public UsersWithProductsWrapperDto usersWithProductsWrapperDto(){
       return new UsersWithProductsWrapperDto();
    }
    public UserWithProductsDto toUserWithProductsDto(){
       return new UserWithProductsDto(firstName, lastName, age, toProductsSoldWithCountDto());
    }
    public ProductsSoldWithCountDto toProductsSoldWithCountDto(){
        return new ProductsSoldWithCountDto(sellingProducts
                .stream()
                .map(this::toProductBasicInfo)
                .collect(Collectors.toList()));
    }

    public ProductBasicInfo toProductBasicInfo(ProductDto productDto){
        return new ProductBasicInfo(productDto.getName(), productDto.getPrice());
    }
}
