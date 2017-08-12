/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mileniumappws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Wilmer
 */
@Embeddable
public class FavoritosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idFavoritos")
    private int idFavoritos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cooerdenadas_idCooerdenadas")
    private int cooerdenadasidCooerdenadas;

    public FavoritosPK() {
    }

    public FavoritosPK(int idFavoritos, int usuarioidUsuario, int cooerdenadasidCooerdenadas) {
        this.idFavoritos = idFavoritos;
        this.usuarioidUsuario = usuarioidUsuario;
        this.cooerdenadasidCooerdenadas = cooerdenadasidCooerdenadas;
    }

    public int getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(int idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getCooerdenadasidCooerdenadas() {
        return cooerdenadasidCooerdenadas;
    }

    public void setCooerdenadasidCooerdenadas(int cooerdenadasidCooerdenadas) {
        this.cooerdenadasidCooerdenadas = cooerdenadasidCooerdenadas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFavoritos;
        hash += (int) usuarioidUsuario;
        hash += (int) cooerdenadasidCooerdenadas;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritosPK)) {
            return false;
        }
        FavoritosPK other = (FavoritosPK) object;
        if (this.idFavoritos != other.idFavoritos) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.cooerdenadasidCooerdenadas != other.cooerdenadasidCooerdenadas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mileniumappws.FavoritosPK[ idFavoritos=" + idFavoritos + ", usuarioidUsuario=" + usuarioidUsuario + ", cooerdenadasidCooerdenadas=" + cooerdenadasidCooerdenadas + " ]";
    }
    
}
