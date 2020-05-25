package com.dona.practica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dona.practica.domain.Contributor;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ContributorDaoImpl implements ContributorDao {

    @PersistenceContext(unitName = "practica")
    private EntityManager entityManager;
    
    @Override
    public List<Contributor> getContributors() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from contribuyente");
        Query query = entityManager.createNativeQuery(sb.toString(), Contributor.class);
        List<Contributor> contributors = query.getResultList();
        return contributors;
    }

    @Override
    @Transactional
    public void save(Contributor contributor) throws DataAccessException {

        try{
            if(contributor.getCodContrib() == null)
                entityManager.persist(contributor);
            else{
                entityManager.merge(contributor);
                entityManager.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}