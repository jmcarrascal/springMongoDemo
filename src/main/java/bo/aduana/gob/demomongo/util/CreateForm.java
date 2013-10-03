package bo.aduana.gob.demomongo.util;

import bo.aduana.gob.demomongo.model.Form;
import bo.aduana.gob.demomongo.model.FormHeader;
import bo.aduana.gob.demomongo.model.FormPayload;

public class CreateForm {

    public static Form getForm() {


        FormHeader header = new FormHeader();
        header.setCode("C1");
        header.setDescrip("D1");
        header.setId_app("CNC2220");
        header.setName("N1");
        header.setStatus("Status");

        FormPayload p = new FormPayload();
        Form form = new Form();
//		form.set_id("oksdoksodk123");
        form.setHeader(header);

//		form.setO(header);

        p.setComponents("{'sin_titulo1': {'type': 'group', 'properties': {'columns': 5, 'label': '[ningu00fan texto de leyenda]'}, 'components': {'sin_titulo5': {'type': 'text', 'properties': {'readonly': false, 'required': false, 'label': '[ningu00fan texto de leyenda]'}}, 'sin_titulo4': {'type': 'numeric', 'properties': {'readonly': false, 'required': false, 'label': '[ningu00fan texto de leyenda]'}}, 'sin_titulo3': {'type': 'text', 'properties': {'readonly': false, 'required': false, 'label': '[ningu00fan texto de leyenda]'}}, 'sin_titulo2': {'type': 'text', 'properties': {'readonly': false, 'required': false, 'label': '[ningu00fan texto de leyenda]'}}}}}");

//		form.setPayload(p);

        return form;
    }

}
