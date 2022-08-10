package com.cidenet.entity;

import com.cidenet.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-27T23:11:26")
@StaticMetamodel(TipoIdentificacion.class)
public class TipoIdentificacion_ { 

    public static volatile SingularAttribute<TipoIdentificacion, Integer> idtipoId;
    public static volatile SingularAttribute<TipoIdentificacion, String> nombreId;
    public static volatile CollectionAttribute<TipoIdentificacion, Usuario> usuarioCollection;

}