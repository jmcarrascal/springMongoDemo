package bo.aduana.gob.demomongo.controller;

import bo.aduana.gob.demomongo.model.Manifiesto;
import bo.aduana.gob.demomongo.service.ManifiestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: esalamanca
 * Date: 03-10-13
 * Time: 06:46 PM
 * Servicios REST para Manifiesto.
 */

@Controller
public class ManifiestoController {

    @Autowired
    private ManifiestoService manifiestoService;

    @RequestMapping(value = "/rest/saveManifiesto", method = RequestMethod.POST)
    public
    @ResponseBody
    void setManifiesto(Manifiesto manifiesto) {
        manifiestoService.saveManifiesto(manifiesto);
    }
}
