package com.aamer.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aamer.model.Coupon;


public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);
	
}
