package devkook.study.rest.satelite;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/SatelliteTower")
public class SateliteSevice {
    @POST
    @Path("/ping")
    @Produces({ "text/plain" })
    public String ping() {
        long ageOfTheUniverse = Universe.whatTimeIsItNow();
        return "This MHIS filed cosmology. Roger. Space-time:" + ageOfTheUniverse;
    }
}
