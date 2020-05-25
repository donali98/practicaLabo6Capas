package com.dona.practica.dao;

import java.util.List;

import com.dona.practica.domain.Contributor;

import org.springframework.dao.DataAccessException;

public interface ContributorDao {

    public List<Contributor> getContributors() throws DataAccessException;
    public void save(Contributor contributor) throws DataAccessException;
    
}