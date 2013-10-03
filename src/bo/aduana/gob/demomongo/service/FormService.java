package bo.aduana.gob.demomongo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import bo.aduana.gob.demomongo.model.Form;
import bo.aduana.gob.demomongo.model.JsonForm;
import bo.aduana.gob.demomongo.model.JsonResult;
import bo.aduana.gob.demomongo.model.Select;
import bo.aduana.gob.demomongo.model.ServiceSelect;
import bo.aduana.gob.demomongo.util.Constants;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@Repository
public class FormService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "forms";
	
	public List<Form> listForm() {
		return mongoTemplate.findAll(Form.class, COLLECTION_NAME);
	}
	
	public void deleteForm(Form form) {
		mongoTemplate.remove(form, COLLECTION_NAME);
	}
	
	public void updateForm(Form form) {
		mongoTemplate.insert(form, COLLECTION_NAME);		
	}
	
	public JsonResult saveForm(JsonForm jsonForm){	 
		DBObject dbObject = (DBObject)JSON.parse(jsonForm.getJson());
		JsonResult jsonResult = new JsonResult();
		if (jsonForm.getMode().equals("edit")){
			String idStr = (String) dbObject.get( "_id" );
			dbObject.put("_id", new ObjectId(idStr));
			mongoTemplate.getCollection(COLLECTION_NAME).save(dbObject);				
			jsonResult.setResult("updated");
			jsonResult.setSuccess(true);
		}else{
			//Put the version and status from ..... temp static var
			DBObject header = (DBObject) dbObject.get("header");
			header.put("version", Constants.FORM_FIRST_VERSION);
			header.put("status", Constants.FORM_FIRST_STATUS);
			dbObject.put("header" , header);		
			mongoTemplate.getCollection(COLLECTION_NAME).insert(dbObject);				
			jsonResult.setResult("inserted");
			jsonResult.setSuccess(true);			
		}
		
		
		return jsonResult;
	}
	
	public JsonResult getDocumentByObjectId(String idStr){		
		JsonResult jsonResult = new JsonResult();
		try{
			DBObject searchById = new BasicDBObject("_id", new ObjectId(idStr));
			DBObject found = mongoTemplate.getCollection(COLLECTION_NAME).findOne(searchById);
			System.out.println(found);
			jsonResult.setResult(found.toString());
			jsonResult.setSuccess(true);
		}catch(Exception e){
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}
 
	public List<Form> listFormByIdApp(String idApp) {		
		Query query = new Query();
		query.addCriteria(Criteria.where("header.id_app").is(idApp));	
		List<Form> listForms = mongoTemplate.find(query, Form.class, COLLECTION_NAME);		
		return listForms;
	}

	public JsonResult isCodeValid(String code) {
		JsonResult jsonResult = new JsonResult();
		try{
			DBObject searchByCode = new BasicDBObject("header.code", code);
			Long count = mongoTemplate.getCollection(COLLECTION_NAME).count(searchByCode);
			if (count > 0)
				jsonResult.setResult("false");
			else
				jsonResult.setResult("true");
			jsonResult.setSuccess(true);
		}catch(Exception e){
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}

	
	

	}
