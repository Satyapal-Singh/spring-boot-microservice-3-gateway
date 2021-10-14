package com.sha.springbootmicroservice3gateway.controller;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gateway/product")
public class ProductController
{
    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody List<JsonElement> product)
    {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId)
    {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts()
    {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> showProductById(@PathVariable Long productId)
    {
        return ResponseEntity.ok(productService.showProductById(productId));
    }
}
