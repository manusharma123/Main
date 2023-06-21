package com.viewCoupons.ViewService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="addCoupons")
public class Coupons {
    @Id
    private String couponId;
    private String couponName;
    private String couponType;
    private String couponDiscount;
    private String couponTC;
    private String couponCode;

    public Coupons(String couponId, String couponName, String couponType, String couponDiscount, String couponTC, String couponCode) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponDiscount = couponDiscount;
        this.couponTC = couponTC;
        this.couponCode = couponCode;
    }

    public Coupons() {
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(String couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCouponTC() {
        return couponTC;
    }

    public void setCouponTC(String couponTC) {
        this.couponTC = couponTC;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
