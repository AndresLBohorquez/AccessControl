/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.facade;

import com.cidenet.entity.TipoIdentificacion;
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
public class TipoIdentificacionFacade extends AbstractFacade<TipoIdentificacion> implements TipoIdentificacionFacadeLocal {

    @PersistenceContext(unitName = "ControlAccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoIdentificacionFacade() {
        super(TipoIdentificacion.class);
    }

    @Override
    public List<TipoIdentificacion> listarTodosTiposId() {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createQuery("SELECT t FROM TipoIdentificacion t");
            return qt.getResultList();
        } catch (Exception e) {
            System.out.println("com.cidenet.facade.TipoIdentificacionFacade.listarTodosTiposId()" + e.getMessage());
            return new ArrayList<>();
        }
    }

}
