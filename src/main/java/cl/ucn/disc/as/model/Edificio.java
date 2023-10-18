package cl.ucn.disc.as.model;

import io.avaje.lang.Nullable;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * The Edificio class.
 *
 * @author Matias Orellana-Hormazabal.
 */

@ToString(callSuper = true)//hecha por lombo, tambien llama a la clase padre
@AllArgsConstructor
@Builder
@Entity//clase del modelo del dominio

public class Edificio extends BaseModel {


    /**
     * The cantidadDePisos.
     */
    @NotNull
    private Integer cantidadDePisos;

    /**
     * The nombre.
     */
    @NotNull
    @Getter
    private String nombre;

    /**
     * The direccion.
     */
    @NotNull
    @Getter
    private String direccion;


    @NotNull
    @Getter
    private List<Departamento> departamentos;
}
