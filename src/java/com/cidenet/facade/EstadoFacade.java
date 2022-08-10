/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.facade;

import com.cidenet.entity.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DarkJack
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> implements EstadoFacadeLocal {

    @PersistenceContext(unitName = "ControlAccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    
    @Override
    public List<Estado> listarTodosEstados(){
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createQuery("SELECT e FROM Estado e");
            return qt.getResultList();
        } catch (Exception e) {
            System.out.println("com.cidenet.facade.EstadoFacade.listarTodosEstados()" + e.getMessage());
            return new ArrayList<>();
        }
    }
}
