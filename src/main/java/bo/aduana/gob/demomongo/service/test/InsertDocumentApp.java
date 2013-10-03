package bo.aduana.gob.demomongo.service.test;

import com.mongodb.*;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;

/**
 * Java MongoDB : Insert a Document
 */
public class InsertDocumentApp {
    public static void main(String[] args) {

        try {

            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("test");

            DBCollection collection = db.getCollection("dummyColl");

            // 4. JSON parse example
            System.out.println("JSON parse example...");

            String json = "{'database' : 'mkyongDB','table' : 'hosting'," +
                    "'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";

            DBObject dbObject = (DBObject) JSON.parse(json);

            System.out.println(dbObject.get("database"));

            collection.insert(dbObject);
            //ObjectId id = (ObjectId)dbObject.get( "_id" );

            DBCursor cursorDocJSON = collection.find();

            while (cursorDocJSON.hasNext()) {

                System.out.println(cursorDocJSON.next());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}