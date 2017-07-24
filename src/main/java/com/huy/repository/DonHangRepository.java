package com.huy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huy.domain.DonHang;

public interface DonHangRepository extends CrudRepository<DonHang, Integer> {

    List<DonHang> findByNameContaining(String i);

}