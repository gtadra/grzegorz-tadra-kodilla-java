package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Employee.findEmployeeByLastname",
                query = "FROM Employee WHERE lastname =  :LASTNAME"
        )
})

@NamedNativeQuery(
        name = "Employee.findEmployeeBasedOnNamePart",
        query = "SELECT * FROM EMPLOYEES " +
                "WHERE FIRSTNAME LIKE :NAMEPART OR LASTNAME LIKE :NAMEPART",
        resultClass = Employee.class
)

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private int id;
    private String firstname;
    private String lastname;
    private List<Company> companies= new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")}
            )
    public List<Company> getCompanies() {
        return companies;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
