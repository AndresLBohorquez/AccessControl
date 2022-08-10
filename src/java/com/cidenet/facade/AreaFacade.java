/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.facade;

import com.cidenet.entity.Area;
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
public class AreaFacade extends AbstractFacade<Area> implements AreaFacadeLocal {

    @PersistenceContext(unitName = "ControlAccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaFacade() {
        super(Area.class);
    }
    
    @Override
    public List<Area> listarTodasAreas(){
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createQuery("SELECT a FROM Area a");
            return qt.getResultList();
        } catch (Exception e) {
            System.out.println("com.cidenet.facade.AreaFacade.listarTodasAreas()" + e.getMessage());
            return new ArrayList<>();
        }
    }
}
