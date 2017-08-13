/**
 * Coordenadas.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'myDB',
  autoCreatedAt: false,
  autoUpdatedAt: false,
  attributes: {
    longitud: {
      type: 'float',
      required: true
    },
    latitud: {
      type: 'float',
      required: true
    },
    descripcion: {
      type: 'string',
      defaultsTo: 'Nueva coordenada'
    },
    favoritos: {
      collection: 'favoritos',
      via: 'idCoordenadas'
    }
  }
};

