package hr.truenorth.rest;

import hr.truenorth.dto.CompanyEmployeeDto;
import hr.truenorth.model.Company;
import hr.truenorth.model.CompanyEmployee;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/company-employees")
public class CompanyEmployeeController {

    @POST
    @Transactional
    public void createCompanyEmployee(CompanyEmployeeDto companyEmployeeDto) {
        CompanyEmployee.add(companyEmployeeDto.getUsername(), companyEmployeeDto.getPassword(), "company_employee",
                companyEmployeeDto.getFirstName(), companyEmployeeDto.getLastName(),
                Company.findById(companyEmployeeDto.getCompanyId()));
    }

}
