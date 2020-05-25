package com.dona.practica.service;

import java.util.List;
import com.dona.practica.domain.Contributor;

import org.springframework.dao.DataAccessException;

public interface ContributorService {
    public List<Contributor> getContributors() throws DataAccessException;
    public void save(Contributor contributor) throws DataAccessException;
}