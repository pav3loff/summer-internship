package hr.truenorth.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@UserDefinition
@Entity
@Table(name = "SI_USER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends PanacheEntity {

    @Username
    public String username;
    @Password
    @JsonIgnore
    public String password;
    @Roles
    public String role;

}









