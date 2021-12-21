package sinau.project.Human.Resource.information.System.dao;

import org.springframework.stereotype.Repository;
import sinau.project.Human.Resource.information.System.entity.Division;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DivisionDAO extends BaseDAO<Division> {
    @Override
    public List<Predicate> predicates(Division param, CriteriaBuilder builder, Root<Division> root, boolean isCount) {
        return super.predicates(param, builder, root, isCount);
    }
}