package com.huy.service;

import java.util.List;

import com.huy.domain.GioHang;

public interface GioHangService {

    Iterable<GioHang> findAll();

    List<GioHang> search(String q);

    GioHang findOne(int id);

    void save(GioHang giohang);

    void delete(int id);

}