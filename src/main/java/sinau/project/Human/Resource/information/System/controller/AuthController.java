package sinau.project.Human.Resource.information.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.User;
import sinau.project.Human.Resource.information.System.service.UserService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Autowired
    private UserService service;

    @PostMapping(value = "do-login")
    public RestResult login(@RequestBody User user) {
        return new RestResult(StatusCode.OPERATION_FAILED);
    }

    @PostMapping(value = "do-register")
    public RestResult register(@RequestBody User param) {
        return new RestResult(StatusCode.OPERATION_FAILED);
    }


}
