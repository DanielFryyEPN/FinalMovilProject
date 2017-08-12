package com.mycompany.mileniumappws;

import com.mycompany.mileniumappws.Favoritos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T14:07:51")
@StaticMetamodel(Cooerdenadas.class)
public class Cooerdenadas_ { 

    public static volatile SingularAttribute<Cooerdenadas, String> descripcion;
    public static volatile CollectionAttribute<Cooerdenadas, Favoritos> favoritosCollection;
    public static volatile SingularAttribute<Cooerdenadas, String> latitud;
    public static volatile SingularAttribute<Cooerdenadas, String> longitud;
    public static volatile SingularAttribute<Cooerdenadas, Integer> idCooerdenadas;

}