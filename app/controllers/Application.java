package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Bill;
import models.Member;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Application extends Controller {


    public static Result index() {
        return ok(index.render());
    }

    public static Result createBill() throws IOException {
        JsonNode data = request().body().asJson();
        String billName = data.get("name").textValue();
        ObjectMapper mapper = new ObjectMapper();
        List<Member> members = mapper.convertValue(data.get("members"), mapper.getTypeFactory().constructCollectionType(List.class, Member.class));
        Bill bill = new Bill(billName, members);
        Bill.create(bill);
        return updateBillsJson();
    }

    private static Result updateBillsJson() throws IOException {
        JsonNode bills = Json.toJson(Bill.all());
        FileWriter file = new FileWriter("/Users/twer/IdeaProjects/PayBill/public/bills/bills.json");
        file.write(bills.toString());
        file.flush();
        file.close();
        return ok();
    }

    public static Result showBillDetail() {
        String id = request().getQueryString("id");
        Bill bill = Bill.find.byId(Long.parseLong(id));
        return ok(Json.toJson(bill));
    }

    public static Result createRecord() {
        return ok();
    }
}
