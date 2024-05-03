package ServiceController;
import DataAccessObject.AirCraftDAO;
import DataObject.AirCraft;
import io.javalin.http.Handler;

import java.util.List;
import java.util.Objects;

public class AirCraftServiceController {
    public static Handler fetchAllAirCrafts = ctx -> {
        List<AirCraft> list = AirCraftDAO.getAllAirCraft();
        ctx.json(list);
    };

    public static Handler fetchAllAirCraftsByCountryHandler = ctx -> {
        String country = Objects.requireNonNull(ctx.pathParam("country"));
        List<AirCraft> list = AirCraftDAO.getAllAirCraft(country);
        ctx.json(list);
    };

    public static Handler deleteAirCraftHandler = ctx -> {
        int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
        AirCraftDAO.delAirCraft(id);
    };

    public static Handler postorputAirCraftHandler = ctx -> {
        AirCraft airCraft = ctx.bodyAsClass(AirCraft.class);//Convert the JSON in HTTP POST BODY to an AirCraft Object based on the information in .class
        AirCraftDAO.addAirCraft(airCraft);
    };


}
