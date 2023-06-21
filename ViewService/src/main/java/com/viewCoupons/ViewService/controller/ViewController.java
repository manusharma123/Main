package com.viewCoupons.ViewService.controller;

import com.viewCoupons.ViewService.exception.CouponNotFound;
import com.viewCoupons.ViewService.model.Coupons;
import com.viewCoupons.ViewService.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @GetMapping("/viewCoupons/{couponName}")
    public ResponseEntity<List<Coupons>> getCouponsByCouponName(@PathVariable String couponName){
        return ResponseEntity.ok(viewService.getCouponByName(couponName));
    }

    @DeleteMapping("/deleteCoupons")
    public ResponseEntity<?> deleteCoupon(@RequestParam("couponId") String couponId){
        try {
             viewService.deleteCoupon(couponId);


        }catch(CouponNotFound e){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.noContent().build();
    }


}
