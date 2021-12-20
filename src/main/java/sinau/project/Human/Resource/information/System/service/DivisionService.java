package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinau.project.Human.Resource.information.System.repo.DivisionDAO;

@Service
public class DivisionService {

    @Autowired
    private DivisionDAO dao;

}
