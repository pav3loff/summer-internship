package hr.truenorth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "SI_COMPANY")
public class Company extends PanacheEntity {

    private String name;
    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<CompanyEmployee> employees;

    public static void add(String name, List<CompanyEmployee> employees) {
        Company company = new Company();
        company.name = name;
        company.employees = employees;
        company.persist();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CompanyEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<CompanyEmployee> employees) {
        this.employees = employees;
    }

}



