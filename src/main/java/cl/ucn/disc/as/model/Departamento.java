package cl.ucn.disc.as.model;

import io.avaje.lang.Nullable;
import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;

/**
 * The Departamento class.
 *
 * @author Matias Orellana-Hormazabal.
 */

@ToString(callSuper = true)//hecha por lombo, tambien llama a la clase padre
@AllArgsConstructor
@Builder
@Entity//clase del modelo del dominio

public class Departamento extends BaseModel{

    /**
     * The numero.
     */
    @NotNull
    @Getter
    private Integer numero;

    /**
     * The piso.
     */
    @NotNull
    @Getter
    private Integer piso;

    @Nullable
    @Getter
    @Setter
    private Long edificioId;
}
