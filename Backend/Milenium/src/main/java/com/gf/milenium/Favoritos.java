/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gf.milenium;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilmer
 */
@Entity
@Table(name = "favoritos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favoritos.findAll", query = "SELECT f FROM Favoritos f")
    , @NamedQuery(name = "Favoritos.findByIdFavoritos", query = "SELECT f FROM Favoritos f WHERE f.favoritosPK.idFavoritos = :idFavoritos")
    , @NamedQuery(name = "Favoritos.findByUsuarioidUsuario", query = "SELECT f FROM Favoritos f WHERE f.favoritosPK.usuarioidUsuario = :usuarioidUsuario")
    , @NamedQuery(name = "Favoritos.findByCooerdenadasidCooerdenadas", query = "SELECT f FROM Favoritos f WHERE f.favoritosPK.cooerdenadasidCooerdenadas = :cooerdenadasidCooerdenadas")})
public class Favoritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoritosPK favoritosPK;
    @JoinColumn(name = "Cooerdenadas_idCooerdenadas", referencedColumnName = "idCooerdenadas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cooerdenadas cooerdenadas;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Favoritos() {
    }

    public Favoritos(FavoritosPK favoritosPK) {
        this.favoritosPK = favoritosPK;
    }

    public Favoritos(int idFavoritos, int usuarioidUsuario, int cooerdenadasidCooerdenadas) {
        this.favoritosPK = new FavoritosPK(idFavoritos, usuarioidUsuario, cooerdenadasidCooerdenadas);
    }

    public FavoritosPK getFavoritosPK() {
        return favoritosPK;
    }

    public void setFavoritosPK(FavoritosPK favoritosPK) {
        this.favoritosPK = favoritosPK;
    }

    public Cooerdenadas getCooerdenadas() {
        return cooerdenadas;
    }

    public void setCooerdenadas(Cooerdenadas cooerdenadas) {
        this.cooerdenadas = cooerdenadas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favoritosPK != null ? favoritosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favoritos)) {
            return false;
        }
        Favoritos other = (Favoritos) object;
        if ((this.favoritosPK == null && other.favoritosPK != null) || (this.favoritosPK != null && !this.favoritosPK.equals(other.favoritosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gf.milenium.Favoritos[ favoritosPK=" + favoritosPK + " ]";
    }
    
}
