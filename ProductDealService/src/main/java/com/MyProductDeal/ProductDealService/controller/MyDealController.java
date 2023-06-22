package com.MyProductDeal.ProductDealService.controller;

import com.MyProductDeal.ProductDealService.exception.ProductNotFound;
import com.MyProductDeal.ProductDealService.model.Product;
import com.MyProductDeal.ProductDealService.service.MyDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyDealController {

    @Autowired
    private MyDealService myDealService;

    @PostMapping("/addMyDeals")
    public ResponseEntity<Product> addDeal(@RequestBody Product product) {

        Product res = myDealService.addMyDeals(product);

        return ResponseEntity.ok(res);
    }



    @DeleteMapping("deleteDealById")
    public ResponseEntity<?> deleteDealById(@RequestParam("id") String id){
        try {
            System.out.println(id);
            myDealService.deleteById(id);


        }catch(ProductNotFound e){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.noContent().build();
    }

}
