package com.dona.practica.dao;

import java.util.List;

import com.dona.practica.domain.Importance;

import org.springframework.dao.DataAccessException;

public interface ImportanceDao {
    public List<Importance> findAll() throws DataAccessException;
}