package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinau.project.Human.Resource.information.System.dao.AttendanceDAO;
import sinau.project.Human.Resource.information.System.dao.BaseDAO;
import sinau.project.Human.Resource.information.System.entity.Attendance;

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

    @Transactional
    public Collection<Attendance> findByDate(Attendance entity, Date startDate, Date endDate) {
        Collection<Attendance> result = dao.findByDate(entity, startDate, endDate);
        return result.size() > 0 ? result : new ArrayList<>();
    }
}
