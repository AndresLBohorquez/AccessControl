/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.facade;

import com.cidenet.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DarkJack
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public List<Usuario> listarTodosUsuarios();

    public boolean registrarUsuario(String primerApellido, String segundoApellido, String primerNombre, String otrosNombres, int idPais, int idTipoIdentificacion, String numeroIdentificacion, String correo, String fechaIngreso, int idArea, int idEstado, String fechaRegistro);

    public Usuario seleccionarUsuario(int idUsuario);

    public boolean editarUsuario(String primer_apellido, String segundo_apellido, String primer_nombre, String otros_nombres, int paisEmpleo_idpais, int tipo_identificacion_idtipo_id, String numero_identificacion, String correo_electronico, int area_idarea, String fecha_modificacion, int idusuario);

    

    
}
