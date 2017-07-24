package com.huy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.domain.GioHang;
import com.huy.repository.GioHangRepository;

@Service
public class GioHangServiceImpl implements GioHangService {
	
	@Autowired
    private GioHangRepository giohangRepository;

	@Override
	public Iterable<GioHang> findAll() {
		// TODO Auto-generated method stub
		return giohangRepository.findAll();
	}

	@Override
	public List<GioHang> search(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GioHang findOne(int id) {
		// TODO Auto-generated method stub
		return giohangRepository.findOne(id);
	}

	@Override
	public void save(GioHang giohang) {
		// TODO Auto-generated method stub
		giohangRepository.save(giohang);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		giohangRepository.delete(id);
	}
	
}