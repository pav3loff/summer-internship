package hr.truenorth;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("/public")
    @PermitAll
    public String helloPublic() {
        return "Hello public!";
    }

    @GET
    @Path("/intern")
    @RolesAllowed("intern")
    public String helloIntern() {
        return "Hello intern!";
    }

    @GET
    @Path("/company_employee")
    @RolesAllowed("company_employee")
    public String helloCompanyEmployee() {
        return "Hello company employee!";
    }

}












