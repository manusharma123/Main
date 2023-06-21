package com.UserCoupons.MyCoupons.controller;

import com.UserCoupons.MyCoupons.exception.CouponNotFound;
import com.UserCoupons.MyCoupons.model.Coupons;
import com.UserCoupons.MyCoupons.service.MyCoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class MyCouponController {

    @Autowired
    private MyCoupService myCoupService;

    @GetMapping("/viewMyCoupons")
    public ResponseEntity<List<Coupons>> getMyCoupons() {
        try {
            return ResponseEntity.ok(myCoupService.getMyCoupon());

        } catch (CouponNotFound e) {
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping("/addMyCoupons")
    public ResponseEntity<?> addMyCoupons(@RequestBody Coupons myCoupon) {
        Coupons save = this.myCoupService.addMyCoupons(myCoupon);
        return ResponseEntity.ok(save);

    }

    @DeleteMapping("/deleteCoupons")
    public ResponseEntity<?> deleteCoupon(@RequestParam("couponId") String couponId){
        try {
            myCoupService.deleteCoupon(couponId);


        }catch(CouponNotFound e){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.noContent().build();
    }


}
