package com.cidenet.entity;

import com.cidenet.entity.Area;
import com.cidenet.entity.Estado;
import com.cidenet.entity.Paisempleo;
import com.cidenet.entity.TipoIdentificacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-27T23:11:26")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> fechaModificacion;
    public static volatile SingularAttribute<Usuario, String> primerApellido;
    public static volatile SingularAttribute<Usuario, String> primerNombre;
    public static volatile SingularAttribute<Usuario, String> numeroIdentificacion;
    public static volatile SingularAttribute<Usuario, String> fechaRegistro;
    public static volatile SingularAttribute<Usuario, String> segundoApellido;
    public static volatile SingularAttribute<Usuario, Paisempleo> paisEmpleoidpais;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile SingularAttribute<Usuario, Estado> estadoIdestado;
    public static volatile SingularAttribute<Usuario, String> fechaIngreso;
    public static volatile SingularAttribute<Usuario, TipoIdentificacion> tipoIdentificacionIdtipoId;
    public static volatile SingularAttribute<Usuario, String> otrosNombres;
    public static volatile SingularAttribute<Usuario, Area> areaIdarea;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;

}