package com.springboot.merchantcrudapp.entity;

import jakarta.persistence.*;

@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int merchantId;
    @Column(nullable = false)
    private String merchantName;
    @Column(nullable = false)
    private String merchantEmail;
    @Column(nullable = false)
    private String merchantPassword;
    @Column(nullable = false)
    private long merchantPhone;
    @Column(nullable = false, unique = true)
    private String merchantGSTNo;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public long getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(long merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public String getMerchantGSTNo() {
        return merchantGSTNo;
    }

    public void setMerchantGSTNo(String merchantGSTNo) {
        this.merchantGSTNo = merchantGSTNo;
    }
}
