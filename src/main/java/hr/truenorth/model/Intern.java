package hr.truenorth.model;

import hr.truenorth.security.User;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "SI_INTERN")
public class Intern extends User {

    private String firstName;
    private String lastName;
    private String university;
    private int studyYear;
    private LocalDate dateOfBirth;

    public static Intern findByUsername(String username) {
        return find("username", username).firstResult();
    }

    public static void add(String username, String password, String role,
                           String firstName, String lastName, String university, int studyYear, LocalDate dateOfBirth) {
        Intern intern = new Intern();
        intern.username = username;
        intern.password = BcryptUtil.bcryptHash(password);
        intern.role = role;
        intern.firstName = firstName;
        intern.lastName = lastName;
        intern.university = university;
        intern.studyYear = studyYear;
        intern.dateOfBirth = dateOfBirth;
        intern.persist();
    }

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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}


