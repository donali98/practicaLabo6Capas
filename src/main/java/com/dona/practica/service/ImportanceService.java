package com.dona.practica.service;

import java.util.List;

import com.dona.practica.domain.Importance;

import org.springframework.dao.DataAccessException;

public interface ImportanceService {
    public List<Importance> findAll() throws DataAccessException;
    
}