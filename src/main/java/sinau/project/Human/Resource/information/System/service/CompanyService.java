package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinau.project.Human.Resource.information.System.repo.CompanyDAO;

@Service
public class CompanyService {

    @Autowired
    private CompanyDAO dao;

}
