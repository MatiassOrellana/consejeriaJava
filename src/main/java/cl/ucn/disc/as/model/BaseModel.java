/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;

//lombok hace el trabajo de los getter y setter
import lombok.Getter;//nos ahorra un monton de codigo
import lombok.Setter;
import lombok.ToString;

//para obtener el @Id, pertenecen a un glomedado de empresas
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;

/**
 * Base Class.
 *
 * @author Diego Urrutia-Astorga.
 */
@ToString
@MappedSuperclass
public abstract class BaseModel {

    /**
     * The Id.
     */
    @Getter
    @Setter
    @Id
    private Long id;//abstracta

    /**
     * The Version.
     */
    @Getter
    @Setter
    @Version
    private Long version;//hora con respecto a la localidad

    /**
     * Creation date.
     */
    @Getter
    @Setter
    @WhenCreated
    private Instant created;//depende de la iplementacion,
    //la fecha que se utiliza es de la base de datos

    /**
     * Modified date.
     */
    @Getter
    @Setter
    @WhenModified
    private Instant modified;

}
