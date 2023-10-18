package cl.ucn.disc.as.model;

import io.avaje.lang.Nullable;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@ToString(callSuper = true)//hecha por lombo, tambien llama a la clase padre
@AllArgsConstructor
@Builder
@Entity//clase del modelo del dominio
public class Pago extends BaseModel{

    @NotNull
    @Getter
    private Date fechaPago;

    @NotNull
    @Getter
    private double monto;

}
