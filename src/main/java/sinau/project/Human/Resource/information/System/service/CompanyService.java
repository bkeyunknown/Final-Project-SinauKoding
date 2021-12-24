package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinau.project.Human.Resource.information.System.dao.BaseDAO;
import sinau.project.Human.Resource.information.System.dao.CompanyDAO;
import sinau.project.Human.Resource.information.System.entity.Company;

@Service
public class CompanyService extends BaseService<Company> {

    @Autowired
    private CompanyDAO dao;

    @Override
    protected BaseDAO<Company> getDAO() {
        return dao;
    }

    @Transactional
    public Company update(Company entity) {
        if (entity.getId() != null) {
            Company reference = getDAO().findReference(entity.getId());

            reference.setName(entity.getName() != null
                    ? entity.getName()
                    : reference.getName());

            reference.setAddress(entity.getAddress() != null
                    ? entity.getAddress()
                    : reference.getAddress());

            reference.setLatitude(entity.getLatitude() != null
                    ? entity.getLatitude()
                    : reference.getLatitude());

            reference.setLongitude(entity.getLongitude() != null
                    ? entity.getLongitude()
                    : reference.getLongitude());

            reference.setPhone(entity.getPhone() != null
                    ? entity.getPhone()
                    : reference.getPhone());

            entity = reference;

            return entity;
        }

        return null;
    }

    public Company findByName(Company param) {
        return dao.findByName(param);
    }

}
