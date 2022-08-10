/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.facade;

import com.cidenet.entity.Paisempleo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DarkJack
 */
@Local
public interface PaisempleoFacadeLocal {

    void create(Paisempleo paisempleo);

    void edit(Paisempleo paisempleo);

    void remove(Paisempleo paisempleo);

    Paisempleo find(Object id);

    List<Paisempleo> findAll();

    List<Paisempleo> findRange(int[] range);

    int count();

    public List<Paisempleo> listarTodosPaises();
    
}
