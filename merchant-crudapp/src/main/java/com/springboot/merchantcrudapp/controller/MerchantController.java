package com.springboot.merchantcrudapp.controller;

import com.springboot.merchantcrudapp.entity.Merchant;
import com.springboot.merchantcrudapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("crudApi/merchants")
public class MerchantController {
    @Autowired
    private MerchantRepository merchantRepository;

    //-------------------------Add The Merchant----------------------------

    @PostMapping
    public Merchant saveMerchant(@RequestBody Merchant merchant) {
        return merchantRepository.save(merchant);
    }
    //-------------------------Find Merchant By Id----------------------------

    @GetMapping("/{merchantId}")
    public Merchant findById(@PathVariable(name = "merchantId") int merchantId) {
        Optional<Merchant> rcvMerchant = merchantRepository.findById(merchantId);
        if (rcvMerchant.isPresent()) {
            return rcvMerchant.get();
        } else {
            return null;
        }
    }
    //-------------------------Update The Merchant----------------------------

    @PutMapping("/{merchantId}")
    public Merchant updateMerchant(@RequestBody Merchant merchant) {
        Optional<Merchant> rcvMerchant = merchantRepository.findById(merchant.getMerchantId());
        if (rcvMerchant.isPresent()) {
            Merchant dbMerchant = rcvMerchant.get();
            dbMerchant.setMerchantName((merchant.getMerchantName()));
            dbMerchant.setMerchantEmail(merchant.getMerchantEmail());
            dbMerchant.setMerchantPhone(merchant.getMerchantPhone());
            dbMerchant.setMerchantGSTNo(merchant.getMerchantGSTNo());
            dbMerchant.setMerchantPassword(merchant.getMerchantPassword());
            merchantRepository.save(dbMerchant);
            return dbMerchant;
        } else {
            return null;
        }
    }
    //-------------------------Find All Merchant----------------------------

    @GetMapping
    public List<Merchant> findAll() {
        return merchantRepository.findAll();

    }

    //-------------------------Delete The Merchant----------------------------
    @DeleteMapping("/{merchantId}")
    public String deleteMerchant(@PathVariable(name = "merchantId") int merchantId) {
        Optional<Merchant> rcvMerchant = merchantRepository.findById(merchantId);
        if (rcvMerchant.isPresent()) {
            merchantRepository.delete(rcvMerchant.get());
            return "Merchant is Deleted Successfully...!";
        } else {
            return "Cann't Delete Merchant";
        }
    }
    //-------------------------Find Merchant By Name----------------------------

    @GetMapping("/find-by-name/{name}")
    public List<Merchant> findByName(@PathVariable(name = "name") String name){

            return merchantRepository.findByName(name);

    }
    //-------------------------Find Merchant By Phone No----------------------------
    @GetMapping("/find-by-phone/{phone}")
    public Merchant findByPhoneNo(@PathVariable(name = "phone") long phone){
        Optional<Merchant> rcvMerchant = merchantRepository.findByPhoneNo(phone);
        if (rcvMerchant.isPresent()) {
            return rcvMerchant.get();

        } else {
            return null;
        }
    }
    //-------------------------Find Merchant By Phone No And Password----------------------------
    @PostMapping("/find-by-phone-and-password")
    public Merchant findByPhoneNoAndPassword(@RequestParam(name = "phone")long phone, @RequestParam(name = "password")String password){
        Optional<Merchant> rcvMerchant = merchantRepository.findByPhoneAndPassword(phone, password);
        if (rcvMerchant.isPresent()) {
            return rcvMerchant.get();

        } else {
            return null;
        }
    }


    //-------------------------Verify Merchant By Email And Password----------------------------
    @PostMapping("/verify-by-email")
    public Merchant veifyByEmail(@RequestParam(name = "phone")String email,@RequestParam(name = "password")String password){
        Optional<Merchant> rcvMerchant = merchantRepository.verifyByEmailAndPassword(email, password);
        if (rcvMerchant.isPresent()) {
            return rcvMerchant.get();

        } else {
            return null;
        }
    }
}
