package sinau.project.Human.Resource.information.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinau.project.Human.Resource.information.System.service.UserService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Autowired
    private UserService service;

}
