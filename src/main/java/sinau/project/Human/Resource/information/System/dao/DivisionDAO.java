package sinau.project.Human.Resource.information.System.dao;

import org.springframework.stereotype.Repository;
import sinau.project.Human.Resource.information.System.entity.Division;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DivisionDAO extends BaseDAO<Division> {
    @Override
    public List<Predicate> predicates(Division param, CriteriaBuilder builder, Root<Division> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

        if (param != null) {
            if (param.getName() != null) {
                predicates.add(builder.like(root.get("name"), "%" + param.getName() + "%"));
            }
        }

        return predicates;
    }

    public Division findByName(Division param) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Division> query = builder.createQuery(Division.class);

        Root<Division> root = query.from(Division.class);

        Predicate usernamePredicate = builder.equal(root.get("name"), param.getName());
        query.where(usernamePredicate);

        TypedQuery<Division> result = entityManager.createQuery(query);
        List<Division> resultList = result.getResultList();

        return resultList.size() > 0 ? resultList.get(0) : new Division();
    }
}
