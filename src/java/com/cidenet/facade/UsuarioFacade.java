/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.facade;

import com.cidenet.entity.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ControlAccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createQuery("SELECT u FROM Usuario u");
            return qt.getResultList();
        } catch (Exception e) {
            System.out.println("com.cidenet.facade.UsuarioFacade.listarTodosUsuarios()" + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean registrarUsuario(String primerApellido, String segundoApellido, String primerNombre, String otrosNombres, int idPais, int idTipoIdentificacion, String numeroIdentificacion, String correo, String fechaIngreso, int idArea, int idEstado, String fechaRegistro) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createNativeQuery("INSERT INTO usuario (primer_apellido, segundo_apellido, primer_nombre, otros_nombres, paisEmpleo_idpais, tipo_identificacion_idtipo_id, numero_identificacion, correo_electronico, fecha_ingreso, area_idarea, estado_idestado, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            qt.setParameter(1, primerApellido);
            qt.setParameter(2, segundoApellido);
            qt.setParameter(3, primerNombre);
            qt.setParameter(4, otrosNombres);
            qt.setParameter(5, idPais);
            qt.setParameter(6, idTipoIdentificacion);
            qt.setParameter(7, numeroIdentificacion);
            qt.setParameter(8, correo);
            qt.setParameter(9, fechaIngreso);
            qt.setParameter(10, idArea);
            qt.setParameter(11, idEstado);
            qt.setParameter(12, fechaRegistro);
            int salida = qt.executeUpdate();

            return salida == 1;
        } catch (Exception e) {
            System.out.println("com.cidenet.facade.UsuarioFacade.registrarUsuario()" + e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario seleccionarUsuario(int idUsuario) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.idusuario = :idUsuario");
            qt.setParameter("idUsuario", idUsuario);
            return (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            System.out.println("com.cidenet.facade.UsuarioFacade.seleccionarUsuario()" + e.getMessage());
            return new Usuario();
        }
    }

    @Override
    public boolean editarUsuario(String primer_apellido, String segundo_apellido, String primer_nombre, String otros_nombres, int paisEmpleo_idpais, int tipo_identificacion_idtipo_id, String numero_identificacion, String correo_electronico, int area_idarea, String fecha_modificacion, int idusuario) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createNativeQuery("UPDATE usuario SET primer_apellido = ?, segundo_apellido = ?, primer_nombre = ?, otros_nombres = ?, paisEmpleo_idpais = ?, tipo_identificacion_idtipo_id = ?, numero_identificacion = ?, correo_electronico = ?, area_idarea = ?, fecha_modificacion = ? WHERE (idusuario = ?)");
            qt.setParameter(1, primer_apellido);
            qt.setParameter(2, segundo_apellido);
            qt.setParameter(3, primer_nombre);
            qt.setParameter(4, otros_nombres);
            qt.setParameter(5, paisEmpleo_idpais);
            qt.setParameter(6, tipo_identificacion_idtipo_id);
            qt.setParameter(7, numero_identificacion);
            qt.setParameter(8, correo_electronico);
            qt.setParameter(9, area_idarea);
            qt.setParameter(10, fecha_modificacion);
            qt.setParameter(11, idusuario);
            int salida = qt.executeUpdate();
            return (salida == 1) ? true : false;
        } catch (Exception e) {
            System.out.println("com.cidenet.facade.UsuarioFacade.editarUsuario()" + e.getMessage());
            return false;
        }
    }

}
