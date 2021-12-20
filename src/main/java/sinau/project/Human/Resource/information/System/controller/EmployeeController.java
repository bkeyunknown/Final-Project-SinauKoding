package sinau.project.Human.Resource.information.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinau.project.Human.Resource.information.System.service.EmployeeService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/employees")
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService service;

}
