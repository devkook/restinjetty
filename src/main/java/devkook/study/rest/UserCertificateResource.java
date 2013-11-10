package devkook.study.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import devkook.study.rest.UserVO;

@Path("/user")
public class UserCertificateResource {

    @POST
    @Path("/whoau")
    @Produces({ "text/plain" })
    public String sayHello() {
        return "If you're curious, 500 won : ) http://devkook.tumbrl.com";
    }

    @GET
    @Path("/getUser")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public UserVO getUserJson() {
        UserVO user = new UserVO();
        return user;
    }

    @GET
    @Path("/getUser")
    @Consumes({ MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_XML })
    public UserVO getUserXML() {
        UserVO user = new UserVO();
        return user;
    }

    @POST
    @Path("/setUser")
    @Produces({ MediaType.APPLICATION_JSON })
    public UserVO setUser(@FormParam("name") String name, @FormParam("age") int age) {
        UserVO user = new UserVO();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
