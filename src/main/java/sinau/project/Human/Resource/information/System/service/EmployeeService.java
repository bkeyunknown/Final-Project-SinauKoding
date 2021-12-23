package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinau.project.Human.Resource.information.System.HumanResourceInformationSystemApplication;
import sinau.project.Human.Resource.information.System.dao.BaseDAO;
import sinau.project.Human.Resource.information.System.dao.EmployeeDAO;
import sinau.project.Human.Resource.information.System.entity.Employee;
import sinau.project.Human.Resource.information.System.entity.User;

import java.util.Date;

@Service
public class EmployeeService extends BaseService<Employee> {

    @Autowired
    private EmployeeDAO dao;

    @Override
    protected BaseDAO<Employee> getDAO() {
        return dao;
    }

    @Transactional
    public Employee save(Employee param) {
        param.setStartDate(new Date());
        param.setUser(HumanResourceInformationSystemApplication.getCurrentUser());

        return dao.save(param);
    }

    @Transactional
    public Employee update(Employee entity) {
        if (entity.getId() != null) {
            Employee reference = getDAO().findReference(entity.getId());

            reference.setEndDate(entity.getEndDate() != null ? entity.getEndDate() : new Date());

            reference.setStatus(reference.getStatus().equals(Employee.StatusEmployee.ACTIVE)
                    ? Employee.StatusEmployee.DEACTIVATE
                    : reference.getStatus());

            entity.setEndDate(reference.getEndDate());
            entity.setStatus(reference.getStatus());

            return entity;
        }

        return null;
    }

    public Employee findByUserId(User param) {
        return dao.findByUserId(param);
    }
}
