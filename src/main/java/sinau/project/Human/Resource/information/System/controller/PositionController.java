package sinau.project.Human.Resource.information.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinau.project.Human.Resource.information.System.service.PositionService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/positions")
public class PositionController extends BaseController {

    @Autowired
    private PositionService service;

}
