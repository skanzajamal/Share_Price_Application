package com.repository;

import com.model.SharedPrice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedPriceRepository extends JpaRepository<SharedPrice, Integer> {

} //ENDINTERFACE
