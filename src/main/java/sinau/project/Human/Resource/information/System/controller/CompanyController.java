package sinau.project.Human.Resource.information.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinau.project.Human.Resource.information.System.service.CompanyService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService service;

}
