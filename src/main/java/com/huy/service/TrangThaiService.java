package com.huy.service;

import java.util.List;

import com.huy.domain.TrangThai;

public interface TrangThaiService {

    Iterable<TrangThai> findAll();

    List<TrangThai> search(String q);

    TrangThai findOne(int id);

    void save(TrangThai trangthai);

    void delete(int id);

}