package sinau.project.Human.Resource.information.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinau.project.Human.Resource.information.System.entity.Bank;
import sinau.project.Human.Resource.information.System.service.BankService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/banks")
public class BankController extends BaseController {

    @Autowired
    private BankService service;

    @PostMapping
    public Bank save(@RequestBody Bank param) {
        return service.save(param);
    }

}
