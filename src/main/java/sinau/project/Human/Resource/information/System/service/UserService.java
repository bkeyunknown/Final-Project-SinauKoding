package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinau.project.Human.Resource.information.System.repo.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO dao;

}
