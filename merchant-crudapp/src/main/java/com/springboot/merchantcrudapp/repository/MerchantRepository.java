package com.springboot.merchantcrudapp.repository;

import com.springboot.merchantcrudapp.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    List<Merchant> findByName(String merchantName);
    Optional<Merchant> findByPhoneNo(long merchantPhone);
    Optional<Merchant> findByPhoneAndPassword(long merchantPhone, String merchantPassword);
    @Query("select m from Merchant m where m.merchantEmail = :merchantEmail and m.merchantPassword = :merchantPassword")
    Optional<Merchant> verifyByEmailAndPassword(@Param("merchantEmail") String merchantEmail, @Param("merchantPassword") String merchantPassword);
}
