package com.mycompany.mileniumappws;

import com.mycompany.mileniumappws.Favoritos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T14:07:51")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Favoritos> favoritosCollection;
    public static volatile SingularAttribute<Usuario, String> apellidoUsuario;
    public static volatile SingularAttribute<Usuario, String> correoUsuario;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> passUsuario;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;

}