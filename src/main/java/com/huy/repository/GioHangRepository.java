package com.huy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huy.domain.GioHang;

public interface GioHangRepository extends CrudRepository<GioHang, Integer> {

    List<GioHang> findByIdContaining(Integer i);

}