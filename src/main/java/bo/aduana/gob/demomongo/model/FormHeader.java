package bo.aduana.gob.demomongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FormHeader {


    private String status;
    private String code;
    private String name;
    private String descrip;
    private String id_app;
    private String version;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getId_app() {
        return id_app;
    }

    public void setId_app(String id_app) {
        this.id_app = id_app;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
