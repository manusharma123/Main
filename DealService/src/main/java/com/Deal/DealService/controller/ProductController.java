package com.Deal.DealService.controller;

import com.Deal.DealService.exception.ProductNotFound;
import com.Deal.DealService.model.Product;
import com.Deal.DealService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addDeal")
    public ResponseEntity<Product> addDeal(@RequestBody Product product) {

        Product res = productService.addDeals(product);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/viewDeals")
    public ResponseEntity<List<Product>> getDeals() {
        try {
            return ResponseEntity.ok(productService.getDeals());

        } catch (ProductNotFound e) {
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("viewDealsByName/{platformName}")
    public ResponseEntity<List<Product>> getDealsByName(@PathVariable String platformName) {
        try {
            return ResponseEntity.ok(productService.getDealsByName(platformName));

        } catch (ProductNotFound e) {
            return ResponseEntity.notFound().build();

        }
    }
    @DeleteMapping("deleteDealById")
    public ResponseEntity<?> deleteDealById(@RequestParam("id") String id){
        try {
            System.out.println(id);
            productService.deleteById(id);


        }catch(ProductNotFound e){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.noContent().build();
    }
}
