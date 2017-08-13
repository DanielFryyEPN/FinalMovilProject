/**
 * Usuario.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'myDB',
  autoCreatedAt: false,
  autoUpdatedAt: false,
  attributes: {
    nombre: {
      type: 'string',
      required: true
    },
    apellido: {
      type: 'string',
      required: true
    },
    correo: {
      type: 'email',
      unique: true,
      required: true
    },
    password: {
      type: 'string',
      required: true
    },
    favoritos: {
      collection: 'favoritos',
      via: 'idUsuario'
    }
  }
};

