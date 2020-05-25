package com.dona.practica.service;

import java.util.List;

import com.dona.practica.dao.ImportanceDao;
import com.dona.practica.domain.Importance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ImportanceServiceImpl implements ImportanceService {

    @Autowired
    ImportanceDao importanceDao;


    @Override
    public List<Importance> findAll() throws DataAccessException {
        return importanceDao.findAll();
    }
    
}