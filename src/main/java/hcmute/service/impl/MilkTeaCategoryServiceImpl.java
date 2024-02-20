package hcmute.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.repository.MilkTeaCategoryRepository;
import hcmute.service.IMilkTeaCategoryService;

@Service
public class MilkTeaCategoryServiceImpl implements IMilkTeaCategoryService{
	
	@Autowired
	MilkTeaCategoryRepository milkTeaCategoryRepository;

	public MilkTeaCategoryServiceImpl(MilkTeaCategoryRepository milkTeaCategoryRepository) {
		this.milkTeaCategoryRepository = milkTeaCategoryRepository;
	}
	
	@Override
    public List<MilkTeaCategoryEntity> findAll() {
        return milkTeaCategoryRepository.findAll();
    }

	@Override
	public Optional<MilkTeaCategoryEntity> findById(int id) {
		return milkTeaCategoryRepository.findById(id);
	}

	@Override
	public <S extends MilkTeaCategoryEntity> S save(S entity) {
		return milkTeaCategoryRepository.save(entity);
	}


	
}
