package com.fndsoft.demonstration.service.impl;

import com.fndsoft.demonstration.dao.ProvincesRepository;
import com.fndsoft.demonstration.entity.Provinces;
import com.fndsoft.demonstration.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/11
 * @描述：
 */
@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Autowired
    ProvincesRepository provincesRepository;

    @Override
    public List<Provinces> findAll() {
        return provincesRepository.findAll();
    }
}
