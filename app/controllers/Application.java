package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
    public static Result index() {
        return ok(index.render());
    }

    public static Result createBill() {
        JsonNode data = request().body().asJson();
        //TODO: create json file
        //TODO: update bills.json
        return ok(data.toString());
    }
}
