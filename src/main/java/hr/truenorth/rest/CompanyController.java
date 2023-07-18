package hr.truenorth.rest;

import hr.truenorth.model.Company;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/companies")
public class CompanyController {

    @POST
    @Transactional
    public void createCompany(Company company) {
        Company.add(company.getName(), company.getEmployees());
    }

}
