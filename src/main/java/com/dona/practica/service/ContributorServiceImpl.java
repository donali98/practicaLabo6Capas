package com.dona.practica.service;

import java.util.List;

import com.dona.practica.domain.Contributor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.dona.practica.dao.ContributorDao;

@Service
public class ContributorServiceImpl implements ContributorService {

    @Autowired
    ContributorDao contributorDao;

    @Override
    public List<Contributor> getContributors() throws DataAccessException {
        return contributorDao.getContributors();
    }

    @Override
    public void save(Contributor contributor) throws DataAccessException {

        contributorDao.save(contributor);
    }
    
}