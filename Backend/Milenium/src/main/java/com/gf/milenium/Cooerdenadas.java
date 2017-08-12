/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gf.milenium;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilmer
 */
@Entity
@Table(name = "cooerdenadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cooerdenadas.findAll", query = "SELECT c FROM Cooerdenadas c")
    , @NamedQuery(name = "Cooerdenadas.findByIdCooerdenadas", query = "SELECT c FROM Cooerdenadas c WHERE c.idCooerdenadas = :idCooerdenadas")
    , @NamedQuery(name = "Cooerdenadas.findByLatitud", query = "SELECT c FROM Cooerdenadas c WHERE c.latitud = :latitud")
    , @NamedQuery(name = "Cooerdenadas.findByLongitud", query = "SELECT c FROM Cooerdenadas c WHERE c.longitud = :longitud")
    , @NamedQuery(name = "Cooerdenadas.findByDescripcion", query = "SELECT c FROM Cooerdenadas c WHERE c.descripcion = :descripcion")})
public class Cooerdenadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCooerdenadas")
    private Integer idCooerdenadas;
    @Size(max = 45)
    @Column(name = "latitud")
    private String latitud;
    @Size(max = 45)
    @Column(name = "longitud")
    private String longitud;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cooerdenadas")
    private Collection<Favoritos> favoritosCollection;

    public Cooerdenadas() {
    }

    public Cooerdenadas(Integer idCooerdenadas) {
        this.idCooerdenadas = idCooerdenadas;
    }

    public Integer getIdCooerdenadas() {
        return idCooerdenadas;
    }

    public void setIdCooerdenadas(Integer idCooerdenadas) {
        this.idCooerdenadas = idCooerdenadas;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Favoritos> getFavoritosCollection() {
        return favoritosCollection;
    }

    public void setFavoritosCollection(Collection<Favoritos> favoritosCollection) {
        this.favoritosCollection = favoritosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCooerdenadas != null ? idCooerdenadas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cooerdenadas)) {
            return false;
        }
        Cooerdenadas other = (Cooerdenadas) object;
        if ((this.idCooerdenadas == null && other.idCooerdenadas != null) || (this.idCooerdenadas != null && !this.idCooerdenadas.equals(other.idCooerdenadas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gf.milenium.Cooerdenadas[ idCooerdenadas=" + idCooerdenadas + " ]";
    }
    
}
