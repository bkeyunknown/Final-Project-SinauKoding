package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.Employee;
import sinau.project.Human.Resource.information.System.service.EmployeeService;

import java.util.ArrayList;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/employees")
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Employee employee = param != null ? new ObjectMapper().readValue(param, Employee.class) : null;
        Long rows = service.count(employee);

        return new RestResult(rows > 0 ? service.find(employee, offset, limit) : new ArrayList<>(), rows);

    }

    @PostMapping
    public RestResult save(@RequestBody Employee param) {
        param = service.save(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Employee employee) {
        employee = service.update(employee);
        return new RestResult(employee, employee != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
