/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mileniumappws.service;

import com.mycompany.mileniumappws.Favoritos;
import com.mycompany.mileniumappws.FavoritosPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Wilmer
 */
@Stateless
@Path("com.mycompany.mileniumappws.favoritos")
public class FavoritosFacadeREST extends AbstractFacade<Favoritos> {

    @PersistenceContext(unitName = "com.mycompany_MileniumappWS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private FavoritosPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idFavoritos=idFavoritosValue;usuarioidUsuario=usuarioidUsuarioValue;cooerdenadasidCooerdenadas=cooerdenadasidCooerdenadasValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.mycompany.mileniumappws.FavoritosPK key = new com.mycompany.mileniumappws.FavoritosPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idFavoritos = map.get("idFavoritos");
        if (idFavoritos != null && !idFavoritos.isEmpty()) {
            key.setIdFavoritos(new java.lang.Integer(idFavoritos.get(0)));
        }
        java.util.List<String> usuarioidUsuario = map.get("usuarioidUsuario");
        if (usuarioidUsuario != null && !usuarioidUsuario.isEmpty()) {
            key.setUsuarioidUsuario(new java.lang.Integer(usuarioidUsuario.get(0)));
        }
        java.util.List<String> cooerdenadasidCooerdenadas = map.get("cooerdenadasidCooerdenadas");
        if (cooerdenadasidCooerdenadas != null && !cooerdenadasidCooerdenadas.isEmpty()) {
            key.setCooerdenadasidCooerdenadas(new java.lang.Integer(cooerdenadasidCooerdenadas.get(0)));
        }
        return key;
    }

    public FavoritosFacadeREST() {
        super(Favoritos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Favoritos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Favoritos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.mycompany.mileniumappws.FavoritosPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Favoritos find(@PathParam("id") PathSegment id) {
        com.mycompany.mileniumappws.FavoritosPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Favoritos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Favoritos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
