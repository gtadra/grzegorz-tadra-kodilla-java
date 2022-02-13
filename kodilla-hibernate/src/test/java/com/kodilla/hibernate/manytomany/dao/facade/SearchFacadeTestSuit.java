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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        System.out.println("CREATE DATA");
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
            System.out.println("DELETED");
        } catch (Exception e) {
            //do nothing
        }
    }



    @Test
    void testFindCompanyBasedOnNamePart() {
        //Given
        List<String> result = new ArrayList<>();
        //When
        try {
        result = searchFacade.findCompanyBasedOnNamePart("Mac");
        } catch (SearchExceptation e) {
            System.out.println(e.getMessage());
        }
        //Then
        assertNotEquals(0, result.size());
    }

    @Test
    void testFindEmployeeBasedOnNamePart() {
        //Given
        List<String> result = new ArrayList<>();
        //When
        try {
        result = searchFacade.findEmployeeBasedOnNamePart("mi");
        } catch (SearchExceptation e) {
            System.out.println(e.getMessage());
        }
        //Then
        assertNotEquals(0, result.size());
    }

}
