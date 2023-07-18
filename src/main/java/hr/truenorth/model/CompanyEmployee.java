package hr.truenorth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.truenorth.security.User;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SI_COMPANY_EMPLOYEE")
public class CompanyEmployee extends User {

    private String firstName;
    private String lastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Company company;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static CompanyEmployee findByUsername(String username) {
        return CompanyEmployee.find("username", username).firstResult();
    }

    public static void add(String username, String password, String role,
                           String firstName, String lastName, Company company) {
        CompanyEmployee companyEmployee = new CompanyEmployee();
        companyEmployee.username = username;
        companyEmployee.password = BcryptUtil.bcryptHash(password);
        companyEmployee.role = role;
        companyEmployee.firstName = firstName;
        companyEmployee.lastName = lastName;
        companyEmployee.company = company;
        companyEmployee.persist();
    }

}





