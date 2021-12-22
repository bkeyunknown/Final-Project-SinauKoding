package sinau.project.Human.Resource.information.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.dao.BaseDAO;
import sinau.project.Human.Resource.information.System.dao.UserDAO;
import sinau.project.Human.Resource.information.System.entity.User;

import java.util.ArrayList;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserDAO dao;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    protected BaseDAO<User> getDAO() {
        return dao;
    }

    @Transactional
    public User register(User param, User.Role role) {
        User reference = dao.findByUsername(param);

        if (reference.getUsername() != null) {
            return null;
        } else {
            param.setRole(role);
            param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

            dao.save(param);

            return param;
        }
    }

    @Transactional
    public RestResult login(User param) {
        RestResult result = new RestResult(StatusCode.PASSWORD_OR_USER_NOT_REGISTERED);

        User currentUser = dao.findByUsername(param);

        if (currentUser == null) {
            return result;
        } else if (currentUser.getPassword() != null &&
                BCrypt.checkpw(param.getPassword(), currentUser.getPassword())) {

            UserDetails userDetails = new org.springframework.security.core.userdetails.
                    User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            currentUser.setToken(jwtTokenService.generateToken(userDetails));

            result.setData(currentUser);
            result.setStatus(StatusCode.LOGIN_SUCCESS);
        } else {
            result.setStatus(StatusCode.LOGIN_FAILED);
        }

        return result;
    }

    public User findByUsername(User param) {
        return dao.findByUsername(param);
    }
}
