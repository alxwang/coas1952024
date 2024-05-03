import ServiceController.AirCraftServiceController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
public class server {
    public static void main(String[] args) {
        var app = Javalin.create(
                javalinConfig -> {
                    javalinConfig.staticFiles.add("/htdocs",Location.CLASSPATH);
                })
                .get("/", ctx -> ctx.result("Welcome to COSa 195 App Server"))
                .start(7070);
        app.get("/aircrafts", AirCraftServiceController.fetchAllAirCrafts);
        app.get("/aircrafts/{country}", AirCraftServiceController.fetchAllAirCraftsByCountryHandler);
        app.post("/aircrafts",AirCraftServiceController.postorputAirCraftHandler);
        app.put("/aircrafts",AirCraftServiceController.postorputAirCraftHandler);
        app.delete("/aircrafts/{id}",AirCraftServiceController.deleteAirCraftHandler);
    }
}
