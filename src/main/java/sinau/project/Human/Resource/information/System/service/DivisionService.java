package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinau.project.Human.Resource.information.System.dao.BaseDAO;
import sinau.project.Human.Resource.information.System.dao.DivisionDAO;
import sinau.project.Human.Resource.information.System.entity.Division;

@Service
public class DivisionService extends BaseService<Division> {

    @Autowired
    private DivisionDAO dao;

    @Override
    protected BaseDAO<Division> getDAO() {
        return dao;
    }

    @Transactional
    public Division update(Division entity) {
        if (entity.getId() != null) {
            Division reference = getDAO().findReference(entity.getId());

            reference.setName(entity.getName() != null
                    ? entity.getName()
                    : reference.getName());

            reference.setNote(entity.getNote() != null
                    ? entity.getNote()
                    : reference.getNote());

            entity = reference;

            return entity;
        }

        return null;
    }

    public Division findByName(Division param) {
        return dao.findByName(param);
    }

}
