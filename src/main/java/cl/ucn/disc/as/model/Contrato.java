package cl.ucn.disc.as.model;

import io.avaje.lang.Nullable;
import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * The Contrato class.
 *
 * @author Matias Orellana-Hormazábal.
 */

@ToString(callSuper = true)//hecha por lombo, tambien llama a la clase padre
@AllArgsConstructor
@Builder
@Entity//clase del modelo del dominio
public class Contrato extends BaseModel{


    @NotNull
    @Getter
    private List<Pago> pagos;

    @Nullable
    @Setter
    private Date fechaPago;

    @Nullable
    @Getter
    @Setter
    private Persona persona;

    @Nullable
    @Getter
    @Setter
    private Long personaId;

    @Nullable
    @Getter
    @Setter
    private Departamento departamento;

    @Nullable
    @Getter
    @Setter
    private Long deptoId;

}
