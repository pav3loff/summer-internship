package hr.truenorth.rest;

import hr.truenorth.model.Application;
import hr.truenorth.model.Company;
import hr.truenorth.model.CompanyEmployee;
import hr.truenorth.model.Intern;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

@Path("/applications")
public class ApplicationController {

    @GET
    @RolesAllowed("company_employee")
    public List<Application> getApplicationsForCompany(@Context SecurityContext securityContext) {
        CompanyEmployee companyEmployee = CompanyEmployee.findByUsername(securityContext.getUserPrincipal().getName());

        return Application.findByCompany(companyEmployee.getCompany());
    }

    @POST
    @Path("/{company_id}")
    @RolesAllowed("intern")
    @Transactional
    public void applyForCompany(@PathParam("company_id") Long companyId, @Context SecurityContext securityContext) {
        Intern intern = Intern.findByUsername(securityContext.getUserPrincipal().getName());

        Application application = new Application();
        application.setCompany(Company.findById(companyId));
        application.setIntern(intern);
        application.persist();
    }

}


