package com.huy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.domain.DonHang;
import com.huy.repository.DonHangRepository;

@Service
public class DonHangServiceImpl implements DonHangService {
	
	@Autowired
    private DonHangRepository donhangRepository;

	@Override
	public Iterable<DonHang> findAll() {
		// TODO Auto-generated method stub
		return donhangRepository.findAll();
	}

	@Override
	public List<DonHang> search(String q) {
		// TODO Auto-generated method stub
		return donhangRepository.findByNameContaining(q);
	}

	@Override
	public DonHang findOne(int id) {
		// TODO Auto-generated method stub
		return donhangRepository.findOne(id);
	}

	@Override
	public void save(DonHang donhang) {
		// TODO Auto-generated method stub
		donhangRepository.save(donhang);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		donhangRepository.delete(id);
	}

}