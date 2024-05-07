package org.springboot.merchantapp.repository;

import org.springboot.merchantapp.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    List<Merchant> findByName(String name);

    Optional<Merchant> findByPhone(long phone);

    Optional<Merchant> findByPhoneAndPassword(long phone, String password);

    @Query("select m from Merchant m where m.email=?1 and m.password=?2")
    Optional<Merchant> verifyByEmailAndPassword(String email, String password);

    @Query("select name from Merchant m")
    List<String> findName();
}
