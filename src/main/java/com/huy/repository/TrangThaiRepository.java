package com.huy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huy.domain.TrangThai;

public interface TrangThaiRepository extends CrudRepository<TrangThai, Integer> {

    List<TrangThai> findByNameContaining(String q);

}