package bo.aduana.gob.demomongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: esalamanca
 * Date: 03-10-13
 * Time: 06:32 PM
 * Entidad Manifiesto.
 */

@Document
public class Manifiesto {

    @Id
    private String id;

    private String codigo;

    private String descripcion;

    //proxy
    public Manifiesto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
