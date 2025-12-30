package com.bluewind.exports.repository;

import com.bluewind.exports.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

    // Fetch latest enquiries first
    List<Enquiry> findAllByOrderByCreatedAtDesc();
}
