package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.Company;
import sinau.project.Human.Resource.information.System.service.CompanyService;

import java.util.ArrayList;

@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Company company = param != null ? new ObjectMapper().readValue(param, Company.class) : null;
        Long rows = service.count(company);

        return new RestResult(rows > 0 ? service.find(company, offset, limit) : new ArrayList<>(), rows);

    }

    @PostMapping
    public RestResult save(@RequestBody Company param) {
        param = service.save(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Company company) {
        company = service.update(company);
        return new RestResult(company, company != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
