package hr.truenorth.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "SI_APPLICATION")
public class Application extends PanacheEntity {

    @OneToOne
    private Intern intern;
    @OneToOne
    private Company company;

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static List<Application> findByCompany(Company company) {
        return find("company", company).list();
    }

    public static void add(Intern intern, Company company) {
        Application application = new Application();
        application.intern = intern;
        application.company = company;
        application.persist();
    }

}



