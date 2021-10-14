package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.request.IProductServiceRequest;
import com.sha.springbootmicroservice3gateway.util.RetrofitUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService implements IProductService
{
    @Autowired
    private IProductServiceRequest productServiceRequest;

    @Override
    public List<JsonElement> saveProduct(List<JsonElement> requestBody)
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.saveProduct(requestBody));
    }

    @Override
    public void deleteProduct(Long productId)
    {
        RetrofitUtils.executeInBlock(productServiceRequest.deleteProduct(productId));
    }

    @Override
    public List<JsonElement> getAllProducts()
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.getAllProducts());
    }

    @Override
    public JsonElement getProductById(Long productId)
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.getProductById(productId));
    }

    @Override
    public JsonElement showProductByName(String productName)
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.showProductByName(productName));
    }

    @Override
    public JsonElement getProductByPrice(Double productPrice)
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.getProductByPrice(productPrice));
    }
}
