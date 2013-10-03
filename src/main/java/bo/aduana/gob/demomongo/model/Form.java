package bo.aduana.gob.demomongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Form {

    @Id
    private String _id;
    private FormHeader header;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public FormHeader getHeader() {
        return header;
    }

    public void setHeader(FormHeader header) {
        this.header = header;
    }


}
