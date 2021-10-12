package com.sha.springbootmicroservice3gateway.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Optional;

public interface IProductServiceRequest
{
    @POST("/api/product")
    Call<List<JsonElement>> saveProduct(@Body List<JsonElement> requestBody);

    @DELETE("/api/product/{productId}")
    Call<Void> deleteProduct(@Path("productId") Long productId);

    @GET("/api/product")
    Call<List<JsonElement>> getAllProducts();

    @GET("/api/product/{productId}")
    Call<Optional<JsonElement>> findById(@Path("productId") Long productId);
}
