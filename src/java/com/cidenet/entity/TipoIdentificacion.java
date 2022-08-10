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
@Table(name = "tipo_identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT t FROM TipoIdentificacion t")
    , @NamedQuery(name = "TipoIdentificacion.findByIdtipoId", query = "SELECT t FROM TipoIdentificacion t WHERE t.idtipoId = :idtipoId")
    , @NamedQuery(name = "TipoIdentificacion.findByNombreId", query = "SELECT t FROM TipoIdentificacion t WHERE t.nombreId = :nombreId")})
public class TipoIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_id")
    private Integer idtipoId;
    @Size(max = 30)
    @Column(name = "nombre_id")
    private String nombreId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoIdentificacionIdtipoId", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Integer idtipoId) {
        this.idtipoId = idtipoId;
    }

    public Integer getIdtipoId() {
        return idtipoId;
    }

    public void setIdtipoId(Integer idtipoId) {
        this.idtipoId = idtipoId;
    }

    public String getNombreId() {
        return nombreId;
    }

    public void setNombreId(String nombreId) {
        this.nombreId = nombreId;
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
        hash += (idtipoId != null ? idtipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.idtipoId == null && other.idtipoId != null) || (this.idtipoId != null && !this.idtipoId.equals(other.idtipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cidenet.entity.TipoIdentificacion[ idtipoId=" + idtipoId + " ]";
    }
    
}
