package com.huy.service;

import java.util.List;

import com.huy.domain.DonHang;

public interface DonHangService {

    Iterable<DonHang> findAll();

    List<DonHang> search(String q);

    DonHang findOne(int id);

    void save(DonHang donhang);

    void delete(int id);

}