package cl.ucn.disc.as.Services;

import cl.ucn.disc.as.model.*;
import cl.ucn.disc.as.model.exceptions.SystemException;
import io.ebean.Database;
import io.ebean.PersistenceIOException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

@Slf4j
public class SystemImpl implements System {

    /**
    * The database
     */
    private final Database database;

    private List<Contrato> contratos;

    private List<Persona> personas;

    private List<Pago> pagos;

    public SystemImpl(Database database) {
        this.database = database;
    }

    /**
     * (@inheritDoc)
     *
     * @return
     */
    @Override
    public Edificio add(@NotNull Edificio edificio) {
        try{

            this.database.save(edificio);//AQUI SE PRODUCE EL ERROR Y HAY QUE MANEJARLO

        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un eficio", ex);
        }

        //need to retriev the id
        return edificio;
    }

    @Override
    public Persona add(@NotNull Persona persona) {
        try{

            this.database.save(persona);//AQUI SE PRODUCE EL ERROR Y HAY QUE MANEJARLO

        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar una persona", ex);
        }

        //need to retriev the id
        return persona;
    }

    @Override
    public Departamento addDepto(Departamento departamento, Edificio edificio) {
        try{

            edificio.getDepartamentos().add(departamento);
            this.database.save(departamento);//AQUI SE PRODUCE EL ERROR Y HAY QUE MANEJARLO


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un departamento", ex);
        }

        //need to retriev the id
        return departamento;
    }

    @Override
    public Departamento addDepto(Departamento departamento, Long idEdificio) {
        try{

            departamento.setEdificioId(idEdificio);
            this.database.save(departamento);//AQUI SE PRODUCE EL ERROR Y HAY QUE MANEJARLO


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un departamento", ex);
        }

        //need to retriev the id
        return departamento;
    }

    @Override
    public Contrato realizarContrato(Persona dueño, Departamento departamento, Date fechaPago, Contrato contrato) {
        try{

            contrato.setPersona(dueño);
            contrato.setDepartamento(departamento);
            contrato.setFechaPago(fechaPago);
            this.database.save(contrato);//AQUI SE PRODUCE EL ERROR Y HAY QUE MANEJARLO


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un departamento", ex);
        }

        //need to retriev the id
        return contrato;
    }

    @Override
    public Contrato realizarContrato(Long idPersona, Long idDepartamento, Date fechaPago, Contrato contrato) {
        try{

            contrato.setPersonaId(idPersona);
            contrato.setDeptoId(idDepartamento);
            contrato.setFechaPago(fechaPago);
            this.database.save(contrato);//AQUI SE PRODUCE EL ERROR Y HAY QUE MANEJARLO


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un departamento", ex);
        }

        //need to retriev the id
        return contrato;
    }

    public List<Pago> getPagos(String rut){

        return pagos;

    }

    @Override
    public List<Persona> getPersonas() {
        //TODO: Implement offset and max rows
        return database.find(Persona.class).findList();
    }
}
