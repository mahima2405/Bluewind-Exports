package com.bluewind.exports.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "enquiries")
    public class Enquiry {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "full_name", nullable = false)
        private String fullName;

        @Column(nullable = false)
        private String email;

        private String phone;

        @Column(name = "organization_name")
        private String organization;

        @Column(name = "enquiry_type")
        private String enquiryType;

        @Column(name = "product_category")
        private String productCategory;

        @Column(name = "shipment_mode")
        private String shipmentMode;

        @Column(length = 2000)
        private String message;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @PrePersist
        public void onCreate() {
            this.createdAt = LocalDateTime.now();
        }

        // ===== GETTERS & SETTERS =====

        public Long getId() {
            return id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getEnquiryType() {
            return enquiryType;
        }

        public void setEnquiryType(String enquiryType) {
            this.enquiryType = enquiryType;
        }

        public String getProductCategory() {
            return productCategory;
        }

        public void setProductCategory(String productCategory) {
            this.productCategory = productCategory;
        }

        public String getShipmentMode() {
            return shipmentMode;
        }

        public void setShipmentMode(String shipmentMode) {
            this.shipmentMode = shipmentMode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }


