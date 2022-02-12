package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.SearchExceptation;
import com.kodilla.hibernate.manytomany.facade.SearchFacade;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SearchFacadeTestSuit {

    @Autowired
    SearchFacade searchFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    private int softwareMachineId;
    private int dataMaestersId;
    private int greyMatterId;


    @BeforeEach
    void AddDateForTests() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");


        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        greyMatterId = greyMatter.getId();
    }

    @AfterEach
    void DelateAllTestData() {
        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteAll();
            employeeDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }




    @Test
    void testFindCompanyBasedOnNamePart() {
        try {
          searchFacade.findCompanyBasedOnNamePart("Ma").forEach(n -> System.out.println(n));
        } catch (SearchExceptation e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void testFindEmployeeBasedOnNamePart() {
        try {
            searchFacade.findEmployeeBasedOnNamePart("i").forEach(n -> System.out.println(n));
        } catch (SearchExceptation e) {
            System.out.println(e.getMessage());
        }
    }

}
