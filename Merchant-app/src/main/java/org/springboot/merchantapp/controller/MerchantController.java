package org.springboot.merchantapp.controller;

import org.springboot.merchantapp.dto.Merchant;
import org.springboot.merchantapp.dto.ResponseStructure;
import org.springboot.merchantapp.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
        return merchantService.saveMerchant(merchant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable(name = "id") int id) {
        return merchantService.findById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
        return merchantService.updateMerchant(merchant);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Merchant>>> findAllMerchants() {
        return merchantService.findAllMerchants();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteMerchant(@PathVariable(name = "id") int id) {
        return merchantService.deleteMerchant(id);
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(@PathVariable(name = "name") String name) {
        return merchantService.findByName(name);
    }

    @GetMapping("/find-by-phone/{phone}")
    public ResponseEntity<ResponseStructure<Merchant>> findByPhone(@PathVariable(name = "phone") long phone) {
        return merchantService.findByPhone(phone);
    }

    @PostMapping("/verify-by-phone")
    public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam(name = "phone") long phone,
                                                                      @RequestParam(name = "password") String password) {
        return merchantService.verifyMerchant(phone, password);
    }

    @PostMapping("/verify-by-email")
    public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam(name = "email") String email,
                                                                      @RequestParam(name = "password") String password) {
        return merchantService.verifyMerchant(email, password);
    }
}