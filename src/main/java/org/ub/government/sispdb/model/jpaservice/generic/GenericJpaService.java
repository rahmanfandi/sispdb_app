/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.model.jpaservice.generic;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author bagus
 */
public interface GenericJpaService<T, ID extends Serializable> {
     public List<T> findAll();
     public List<T> findAllRefreshHint();
          
     public List<T> findAllByField(String fieldName, String strValue, Long longValue);
     public List<T> findAllDetilByRefno(Long longValue);
     public List<T> findAllDetilByRefnoOnly(Long longValue);
     
     public T findById(Serializable ID);
     public List<T> findAllById(Serializable ID);
     public void createObject(T domain);
     public void updateObject(T domain);
     public void removeObject(T domain);
     public long count();
}
