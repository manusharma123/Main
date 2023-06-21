package com.UserCoupons.MyCoupons.repository;

import com.UserCoupons.MyCoupons.model.Coupons;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyCouponsRepository extends MongoRepository<Coupons,String> {
}
