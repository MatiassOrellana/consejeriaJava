/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Persona;
import io.ebean.Finder;

/**
 * The Finder of Persona.
 *
 * @author Matias Orellana.
 */
public class PersonaFinder extends Finder<Long, Persona> {


    /**
     * The Constructor.
     */
    public PersonaFinder() {
        super(Persona.class);
    }

    /**
     * Find a Persona by rut.
     *
     * @param rut to use.
     * @return the Persona.
     */

    /**
    //todo lo del rut se ha cambiado a string
    public Optional<Persona> byRut(@NotNull String rut) {
        return new QPersona().rut.eq(rut).findOneOrEmpty();
    }
     */
}
