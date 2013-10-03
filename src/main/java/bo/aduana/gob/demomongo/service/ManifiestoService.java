package bo.aduana.gob.demomongo.service;

import bo.aduana.gob.demomongo.model.Manifiesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: esalamanca
 * Date: 03-10-13
 * Time: 06:34 PM
 * Capa acceso a datos: Manifiestos
 */

@Repository
public class ManifiestoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "manifiesto";

    public void saveManifiesto(Manifiesto manifiesto) {
        manifiesto.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(manifiesto, COLLECTION_NAME);
    }
}
