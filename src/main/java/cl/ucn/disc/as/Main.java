package cl.ucn.disc.as;

import cl.ucn.disc.as.Services.System;
import cl.ucn.disc.as.Services.SystemImpl;
import cl.ucn.disc.as.dao.PersonaFinder;
import cl.ucn.disc.as.model.*;
import cl.ucn.disc.as.model.exceptions.IllegalDomainException;
import io.ebean.DB;
import io.ebean.Database;
import io.ebean.config.JsonConfig;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;

import java.util.Date;
import java.util.Optional;

/**
 * The Main
 *
 * @autor Matias orellana
 */

@Slf4j //simple login faltale for java, nos injecta un atributo del logger
//entrega mucho mas imformacion que el system.out.print ln
//nombre de la clase
//la hora, todo
public class Main {

    public static void main(String[] args) throws IllegalDomainException {

        log.debug("starting main...");

        Database db = DB.getDefault();//crea la base de datos

        System system = new SystemImpl(db);

        Edificio edificio = Edificio.builder().nombre("y1")
                .direccion("av. perez zujovic")
                .cantidadDePisos(5).build();

        log.debug("edificio before dc: {}",edificio);

        edificio = system.add(edificio);

        log.debug("edificio before dc: {}",edificio);

        //Se han agregado objetos
        //donde se escribe el builder y con el builder se van añadiendo cada parametro
        //con ese parametro termina en .build
        Persona persona1 = Persona.builder().rut("20416699-4").nombre("Matias")
                .apellidos("Orellana Hormazabal")
                .email("matias.orellana@alumnos.ucn.cl")
                .telefono("+56213671283").build();
        Persona persona2 = Persona.builder().rut("20416699-4").nombre("Oscar")
                .apellidos("Laura Hurtado")
                .email("oscarLauraH@gmail.com")
                .telefono("+56245465466").build();
        Edificio edificio1 = Edificio.builder()
                .nombre("calipso")
                .direccion("Enrique segoviano")
                .cantidadDePisos(1).build();
        Departamento depto1 = Departamento.builder()
                .numero(01)
                .piso(1).build();
        Departamento depto2 = Departamento.builder()
                .numero(02)
                .piso(1)
                .build();
        Departamento depto3 = Departamento.builder()
                .numero(03)
                .piso(1)
                .build();
        Pago pago1 = Pago.builder()
                .fechaPago(LocalDate.now().toDate())
                .monto(34.1).build();
        Pago pago2 = Pago.builder()
                .fechaPago(LocalDate.now().toDate())
                .monto(41.4).build();


        log.debug("the persona before db: ${}", persona1);

        db.save(persona1);//guarda la persona a la base de datos
        db.save(persona2);
        db.save(edificio);
        db.save(depto1);
        db.save(depto2);
        db.save(depto3);
        db.save(pago1);
        db.save(pago2);
        // la base de datos utiliza SQLite
        // consejeria.db esa es la base de datos

        log.debug("The Persona: ${}", persona1);


//        PersonaFinder df = new PersonaFinder();//creador de objeto
//        Optional<Persona> oPersona = df.byRut("20416699-4");//opcional de la persona en caso de nulos
//        oPersona.ifPresent(p -> log.debug("Persona: {}", p));//busca la persona con ese rut

        log.debug("Done.  ");

    }
}
