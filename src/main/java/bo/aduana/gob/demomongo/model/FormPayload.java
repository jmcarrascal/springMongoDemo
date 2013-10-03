package bo.aduana.gob.demomongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FormPayload {

	
	private String components;

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}


}
