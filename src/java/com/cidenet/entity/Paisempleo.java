/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarkJack
 */
@Entity
@Table(name = "paisempleo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paisempleo.findAll", query = "SELECT p FROM Paisempleo p")
    , @NamedQuery(name = "Paisempleo.findByIdpais", query = "SELECT p FROM Paisempleo p WHERE p.idpais = :idpais")
    , @NamedQuery(name = "Paisempleo.findByNombrePais", query = "SELECT p FROM Paisempleo p WHERE p.nombrePais = :nombrePais")})
public class Paisempleo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpais")
    private Integer idpais;
    @Size(max = 30)
    @Column(name = "nombre_pais")
    private String nombrePais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisEmpleoidpais", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;

    public Paisempleo() {
    }

    public Paisempleo(Integer idpais) {
        this.idpais = idpais;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paisempleo)) {
            return false;
        }
        Paisempleo other = (Paisempleo) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cidenet.entity.Paisempleo[ idpais=" + idpais + " ]";
    }
    
}
