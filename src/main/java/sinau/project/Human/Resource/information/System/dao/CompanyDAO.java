package sinau.project.Human.Resource.information.System.dao;

import org.springframework.stereotype.Repository;
import sinau.project.Human.Resource.information.System.entity.Company;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CompanyDAO extends BaseDAO<Company> {
    @Override
    public List<Predicate> predicates(Company param, CriteriaBuilder builder, Root<Company> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

        if (param != null) {
            if (param.getName() != null) {
                predicates.add(builder.like(root.get("name"), "%" + param.getName() + "%"));
            }

            if (param.getAddress() != null) {
                predicates.add(builder.like(root.get("address"), "%" + param.getAddress() + "%"));
            }
        }

        return predicates;
    }
}
