package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinau.project.Human.Resource.information.System.dao.BaseDAO;
import sinau.project.Human.Resource.information.System.dao.EmployeeDAO;
import sinau.project.Human.Resource.information.System.entity.Employee;
import sinau.project.Human.Resource.information.System.entity.User;

@Service
public class EmployeeService extends BaseService<Employee> {

    @Autowired
    private EmployeeDAO dao;

    @Override
    protected BaseDAO<Employee> getDAO() {
        return dao;
    }

    public Employee findByUserId(User param) {
        return dao.findByUserId(param);
    }
}
