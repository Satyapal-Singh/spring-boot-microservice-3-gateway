package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import retrofit2.Call;

import java.util.List;
import java.util.Optional;

public interface IProductService
{
    List<JsonElement> saveProduct(List<JsonElement> requestBody);

    void deleteProduct(Long productId);

    List<JsonElement> getAllProducts();

    JsonElement getProductById(Long productId);

    JsonElement showProductByName(String productName);

    JsonElement getProductByPrice(Double productPrice);
}
