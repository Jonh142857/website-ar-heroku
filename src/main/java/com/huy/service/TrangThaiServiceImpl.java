package com.huy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.domain.TrangThai;
import com.huy.repository.TrangThaiRepository;

@Service
public class TrangThaiServiceImpl implements TrangThaiService {
	
	@Autowired
    private TrangThaiRepository trangthaiRepository;

	@Override
	public Iterable<TrangThai> findAll() {
		// TODO Auto-generated method stub
		return trangthaiRepository.findAll();
	}

	@Override
	public List<TrangThai> search(String q) {
		// TODO Auto-generated method stub
		return trangthaiRepository.findByNameContaining(q);
	}

	@Override
	public TrangThai findOne(int id) {
		// TODO Auto-generated method stub
		return trangthaiRepository.findOne(id);
	}

	@Override
	public void save(TrangThai trangthai) {
		// TODO Auto-generated method stub
		trangthaiRepository.save(trangthai);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		trangthaiRepository.delete(id);
	}
}