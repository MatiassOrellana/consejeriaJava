package cl.ucn.disc.as.Services;

/*
* System
*
* @author Matias orellana
* */

import cl.ucn.disc.as.model.*;

import java.util.Date;
import java.util.List;

public interface System {

    /**
     * @param edificio a agregar
     * @return
     */
    public Edificio add(Edificio edificio);

    public Persona add(Persona persona);

    public Departamento addDepto(Departamento departamento, Edificio edificio);

    public Departamento addDepto(Departamento departamento, Long idEdificio);

    public Contrato realizarContrato(Persona dueño, Departamento departamento, Date fechaPago, Contrato contrato);

    public Contrato realizarContrato(Long idPersona ,Long idDepartamento, Date fechaPago, Contrato contrato);

    public List<Persona> getPersonas();
}
