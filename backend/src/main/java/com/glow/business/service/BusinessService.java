package com.glow.business.service;

import com.glow.business.repository.BusinessRepository;
import com.glow.business.service.dto.BusinessDTO;
import com.glow.business.service.mapper.BusinessMapper;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final BusinessMapper businessMapper;

    public BusinessService(BusinessRepository businessRepository, BusinessMapper businessMapper) {
        this.businessRepository = businessRepository;
        this.businessMapper = businessMapper;
    }

    public BusinessDTO save(BusinessDTO businessDTO) {
        var entity = businessMapper.toEntity(businessDTO);
        entity = businessRepository.save(entity);
        return businessMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<BusinessDTO> findAll(Pageable pageable) {
        return businessRepository.findAll(pageable).map(businessMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<BusinessDTO> findOne(Long id) {
        return businessRepository.findById(id).map(businessMapper::toDto);
    }

    public void delete(Long id) {
        businessRepository.deleteById(id);
    }
}
