package com.MyProductDeal.ProductDealService.service;

import com.MyProductDeal.ProductDealService.exception.ProductNotFound;
import com.MyProductDeal.ProductDealService.model.Product;

public interface MyDealService {

    public Product addMyDeals(Product product);
    public void deleteById(String id) throws ProductNotFound;
}
