package com.aamer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aamer.model.Coupon;
import com.aamer.repos.CouponRepo;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponRestController {

    @Autowired
    private CouponRepo repo;

    @PostMapping("/")
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        Coupon savedCoupon = repo.save(coupon);
        return new ResponseEntity<>(savedCoupon, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Coupon> getCoupon(@PathVariable String code) {
        Coupon coupon = repo.findByCode(code);
        return coupon != null ? new ResponseEntity<>(coupon, HttpStatus.OK) :
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/")
	public List<Coupon> getProducts(){
		List<Coupon> coupons = null;
		try {
			coupons = repo.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return coupons;
        
    }
}

