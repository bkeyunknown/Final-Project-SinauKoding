package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.Division;
import sinau.project.Human.Resource.information.System.service.DivisionService;

import java.util.ArrayList;

@RestController
@RequestMapping("/divisions")
public class DivisionController extends BaseController {

    @Autowired
    private DivisionService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Division division = param != null ? new ObjectMapper().readValue(param, Division.class) : null;
        Long rows = service.count(division);

        return new RestResult(rows > 0 ? service.find(division, offset, limit) : new ArrayList<>(), rows);

    }

    @PostMapping
    public RestResult save(@RequestBody Division param) {
        param = service.save(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Division division) {
        division = service.update(division);
        return new RestResult(division, division != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
