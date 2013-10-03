package bo.aduana.gob.demomongo.controller;

import bo.aduana.gob.demomongo.model.Aduana;
import bo.aduana.gob.demomongo.model.Form;
import bo.aduana.gob.demomongo.model.JsonForm;
import bo.aduana.gob.demomongo.model.JsonResult;
import bo.aduana.gob.demomongo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FormController {

    @Autowired
    private FormService formService;

    @RequestMapping(value = "/rest/getForms/{idApp}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Form> getForms(@PathVariable String idApp) {
        List<Form> formList = formService.listFormByIdApp(idApp);
        return formList;
    }

    @RequestMapping(value = "/rest/saveForm", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResult setForms(JsonForm jsonForm) {
        JsonResult jsonResult = formService.saveForm(jsonForm);
        return jsonResult;
    }

    @RequestMapping(value = "/rest/saveAduana", method = RequestMethod.POST)
    public
    @ResponseBody
    void setAduana(Aduana aduana) {
        formService.saveAduana(aduana);
    }
}
