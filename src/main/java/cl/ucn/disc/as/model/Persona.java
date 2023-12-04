/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import cl.ucn.disc.as.model.exceptions.IllegalDomainException;
import cl.ucn.disc.as.utils.ValidationUtils;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * The Persona class.
 *
 * @author Matias Orellana-Hormazabal.
 */
@ToString(callSuper = true)//hecha por lombo, tambien llama a la clase padre
@AllArgsConstructor
@Builder
@Entity//clase del modelo del dominio
public class Persona extends BaseModel {

    /**
     * The RUT.
     */
    @NotNull
    @Getter
    private String rut;

    /**
     * The Nombre.
     */
    @NotNull
    @Getter
    private String nombre;

    /**
     * The Apellidos.
     */
    @NotNull
    @Getter
    private String apellidos;

    /**
     * The Email.
     */
    @NotNull
    @Getter
    private String email;

    /**
     * The Telefono.
     */
    @NotNull
    @Getter
    private String telefono;

    /**
     * custom build
     */

    public static class PersonaBuilder {


        /**
         * @return persona
         */
        public Persona build() throws IllegalDomainException {

            //Se agrego la validadcion del rut
            //validate the rut
            if (!ValidationUtils.isRutValid(this.rut)) {

                //se debe noticar de esa excepcion
                throw new IllegalDomainException("rut no valido: " + this.rut);
                //esa excepcion lo creamos en la carpeta almacenada en exceptions
                //y esa carpeta se creo manualmente

            }
            //validar correo electronico
            if ((!ValidationUtils.isEmailValid(this.email))) {
                throw new IllegalDomainException("Email no valido");
                //tanto para email , como para rut
            }

            //Todo: Agregar resto de validaciones
            return new Persona(
                    this.rut,
                    this.nombre,
                    this.apellidos,
                    this.email,
                    this.telefono
            );
        }
    }
}
