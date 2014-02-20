package controllers;

import models.Bill;
import models.ConsumptionRecord;
import models.Partner;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    static Form<Partner> partnerForm = Form.form(Partner.class);
    static Form<ConsumptionRecord> recordForm = Form.form(ConsumptionRecord.class);

    public static Result index() {
        Bill bill = new Bill();
        return ok(index.render(bill, partnerForm, recordForm));
    }

    public static Result addPartner() {
        return Results.TODO;
    }

    public static Result addRecord() {
        return Results.TODO;
    }
}
