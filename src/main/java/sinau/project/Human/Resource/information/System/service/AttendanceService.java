package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinau.project.Human.Resource.information.System.HumanResourceInformationSystemApplication;
import sinau.project.Human.Resource.information.System.dao.AttendanceDAO;
import sinau.project.Human.Resource.information.System.dao.BaseDAO;
import sinau.project.Human.Resource.information.System.entity.Attendance;
import sinau.project.Human.Resource.information.System.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class AttendanceService extends BaseService<Attendance> {

    @Autowired
    private AttendanceDAO dao;

    @Override
    protected BaseDAO<Attendance> getDAO() {
        return dao;
    }

    @Autowired
    private EmployeeService employeeService;

    @Transactional
    public Attendance save(Attendance param) {
        param.setStartTime(new Date());

        User user = HumanResourceInformationSystemApplication.getCurrentUser();

        param.setEmployee(employeeService.findByUserId(user));

        return dao.save(param);
    }

    @Transactional
    public Attendance update(Attendance entity) {
        if (entity.getId() != null) {
            Attendance reference = getDAO().findReference(entity.getId());

            reference.setEndTime(entity.getEndTime() != null
                    ? entity.getEndTime()
                    : new Date());

            reference.setNote(entity.getNote() != null
                    ? entity.getNote()
                    : reference.getNote());

            entity = reference;

            return entity;
        }

        return null;
    }

    @Transactional
    public Attendance startRest(Attendance entity) {
        if (entity.getId() != null) {
            Attendance reference = getDAO().findReference(entity.getId());

            reference.setRestStartTime(entity.getRestStartTime() != null
                    ? entity.getRestStartTime()
                    : new Date());

            entity = reference;

            return entity;
        }

        return null;
    }

    @Transactional
    public Attendance endRest(Attendance entity) {
        if (entity.getId() != null) {
            Attendance reference = getDAO().findReference(entity.getId());

            reference.setRestEndTime(entity.getRestEndTime() != null
                    ? entity.getRestEndTime()
                    : new Date());

            entity = reference;

            return entity;
        }

        return null;
    }

    @Transactional
    public Collection<Attendance> findByDate(Attendance entity, Date startDate, Date endDate) {
        Collection<Attendance> result = dao.findByDate(entity, startDate, endDate);
        return result.size() > 0 ? result : new ArrayList<>();
    }
}
