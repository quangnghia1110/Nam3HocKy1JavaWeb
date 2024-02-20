package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.PayMethodEntity;
import hcmute.repository.PayMethodRepository;
import hcmute.service.IPayMethodService;

@Service
public class PayMethodServiceImpl implements IPayMethodService{
	@Autowired
	PayMethodRepository payMethodRepository;

	public PayMethodServiceImpl(PayMethodRepository payMethodRepository) {
		super();
		this.payMethodRepository = payMethodRepository;
	}

	@Override
	public List<PayMethodEntity> findAll() {
		return payMethodRepository.findAll();
	}

	@Override
	public List<PayMethodEntity> findAllById(Iterable<String> ids) {
		return payMethodRepository.findAllById(ids);
	}

	@Override
	public Optional<PayMethodEntity> findById(String id) {
		return payMethodRepository.findById(id);
	}

	@Override
	public <S extends PayMethodEntity> S save(S entity) {
		return payMethodRepository.save(entity);
	}

}
