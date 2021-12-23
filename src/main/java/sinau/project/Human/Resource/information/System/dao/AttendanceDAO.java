package sinau.project.Human.Resource.information.System.dao;

import org.springframework.stereotype.Repository;
import sinau.project.Human.Resource.information.System.entity.Attendance;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
public class AttendanceDAO extends BaseDAO<Attendance> {
    @Override
    public List<Predicate> predicates(Attendance param, CriteriaBuilder builder, Root<Attendance> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

        if (!isCount) {
            root.fetch("employee", JoinType.INNER).fetch("user", JoinType.INNER);
        }

        return predicates;
    }

    public List<Attendance> findByDate(Attendance param, Date startDate, Date endDate) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Attendance> query = builder.createQuery(Attendance.class);

        Root<Attendance> root = query.from(Attendance.class);

        if (param != null) {
            if (param.getEmployee() != null) {
                query.where(builder.equal(root.get("employee").get("id"), param.getEmployee().getId()));
            }
        }

        query.where(builder.between(root.get("date"), startDate, endDate));
        query.orderBy(builder.asc(root.get("id")));

        root.fetch("employee", JoinType.INNER).fetch("user", JoinType.INNER);

        TypedQuery<Attendance> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}
