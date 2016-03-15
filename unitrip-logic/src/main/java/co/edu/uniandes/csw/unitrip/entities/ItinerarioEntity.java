/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.unitrip.entities;

import co.edu.uniandes.csw.unitrip.exceptions.BusinesLogicException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ANDRES
 */
public class ItinerarioEntity implements Serializable{
    
     @PersistenceContext(unitName = "Itinerario")
    protected EntityManager em;

    public ItinerarioEntity create(ItinerarioEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ItinerarioEntity update(ItinerarioEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ItinerarioEntity entity = em.find(ItinerarioEntity.class, id);
        em.remove(entity);
    }

    public ItinerarioEntity find(Long id) {
        return em.find(ItinerarioEntity.class, id);
    }

    public List<ItinerarioEntity> findAll() {
        Query q;
         q = em.createQuery("select u from AuthorEntity u");
        return q.getResultList();
    }
    
    public void setId(Long itinerarioId) throws BusinesLogicException {
        throw new BusinesLogicException("Not supported yet.");
    }

    
    
}
