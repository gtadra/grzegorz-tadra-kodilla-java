package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;




@Service
public class SearchFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }


    public List<String> findCompanyBasedOnNamePart (String partName) throws SearchExceptation{
        LOGGER.info("Searching for company with '" + partName + "' in name");

        List<String> result =  companyDao.findCompanyBasedOnNamePart("%" + partName + "%").stream()
               .map(n -> n.getName())
                .collect(Collectors.toList());

        if (result.size() == 0){
            LOGGER.info(SearchExceptation.INFO_NO_COMPANY);
            throw new SearchExceptation(SearchExceptation.INFO_NO_COMPANY);
        }
        return result;
    }

    public List<String> findEmployeeBasedOnNamePart (String partName) throws SearchExceptation{
        LOGGER.info("Searching for employee with '" + partName + "' in name");

        List<String> result = employeeDao.findEmployeeBasedOnNamePart("%"+ partName +"%").stream()
                .map(n -> n.getFirstname() + " " + n.getLastname())
                .collect(Collectors.toList());

        if (result.size() == 0){
            LOGGER.info(SearchExceptation.INFO_NO_EMPLOYEE);
            throw new SearchExceptation(SearchExceptation.INFO_NO_EMPLOYEE);
        }
        return result;
    }
}
