package devkook.study.rest.satelite;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/SatelliteTower")
public class SateliteSevice {
	
	static SateliteDao dao = new SateliteDao();
    
	@POST
    @Path("/ping")
    @Produces({ "text/plain" })
    public String ping() {
        long ageOfTheUniverse = Universe.whatTimeIsItNow();
        return "This MHIS filed cosmology. Roger. Space-time:" + ageOfTheUniverse;
    }
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
    public void insert(SateliteVo instance){
        dao.insert(instance.getLaunchKey(), instance);
    }
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("{LaunchKey}")
    public SateliteVo select(@PathParam("LaunchKey") String LaunchKey){
        return dao.select(LaunchKey);
    }
	
	@PUT
    @Path("{LaunchKey}")
    public void update(@PathParam("LaunchKey") String LaunchKey, SateliteVo instance){
        dao.update(LaunchKey, instance);
    }
	
	@DELETE
    @Path("{email}")
    public void delete(@PathParam("LaunchKey") String LaunchKey){
        dao.delete(LaunchKey);
    }
	
}
