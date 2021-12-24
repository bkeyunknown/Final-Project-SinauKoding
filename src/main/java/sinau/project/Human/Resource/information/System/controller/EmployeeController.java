package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.Employee;
import sinau.project.Human.Resource.information.System.service.EmployeeService;

import java.util.ArrayList;

@RestController
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
        RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

        if (param != null) {
            result.setData(service.save(param));
            result.setStatus(StatusCode.SAVE_SUCCESS);
        }

        return result;
    }

    @PutMapping
    public RestResult update(@RequestBody Employee employee) {
        RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

        if (employee != null) {
            result.setData(service.update(employee));
            result.setStatus(StatusCode.UPDATE_SUCCESS);
        }

        return result;
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        boolean deleted = false;
        Employee entity = service.findById(id);

        if (entity != null) {
            service.updateDeleteStatus(id);
            deleted = service.delete(id);
        }

        return new RestResult(deleted ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
