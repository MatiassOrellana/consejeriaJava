package cl.ucn.disc.as.model.exceptions;

import javax.persistence.PersistenceException;

public class SystemEceptions extends RuntimeException{

    public SystemEceptions(String message, PersistenceException ex){
        super(message, ex);
    }

}
