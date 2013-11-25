package devkook.study.rest.contact;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import devkook.study.rest.UserVO;

@Path("/Contact")
public class ContactService {
    static ContactDao dao = new ContactDao();
    
    @POST
    @Path("/whoau")
    @Produces({ "text/plain" })
    public String sayHello() {
        return "Hi I'm from http://bcho.tistory.com/732";
    }
    
    @GET
    @Path("/getUser")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public UserVO getUserJson() {
        UserVO user = new UserVO();
        return user;
    }
    
    @POST
    public void Create(ContactVo instance){
        dao.add(instance.getEmail(), instance);
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("{email}")
    public ContactVo Get(@PathParam("email") String email){
        return dao.get(email);
    }
    
    @PUT
    @Path("{email}")
    public void Update(@PathParam("email") String email, ContactVo instance){
        dao.update(email, instance);
    }
    
    @DELETE
    @Path("{email}")
    public void Delete(@PathParam("email") String email){
        dao.remove(email);
    }
}
