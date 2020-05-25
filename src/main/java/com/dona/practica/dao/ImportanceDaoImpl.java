package com.dona.practica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dona.practica.domain.Importance;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ImportanceDaoImpl implements ImportanceDao {

    @PersistenceContext(unitName = "practica")
    private EntityManager entityManager;

    @Override
    public List<Importance> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from importancia");
        Query query = entityManager.createNativeQuery(sb.toString(), Importance.class);
        List<Importance> res = query.getResultList();
        return res;
    }
    
}