package sinau.project.Human.Resource.information.System.dao;

import org.springframework.stereotype.Repository;
import sinau.project.Human.Resource.information.System.entity.Position;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PositionDAO extends BaseDAO<Position> {
    @Override
    public List<Predicate> predicates(Position param, CriteriaBuilder builder, Root<Position> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

        if (param != null) {
            if (param.getName() != null) {
                predicates.add(builder.like(root.get("name"), "%" + param.getName() + "%"));
            }
        }

        return predicates;
    }
}
