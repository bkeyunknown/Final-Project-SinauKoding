package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.Position;
import sinau.project.Human.Resource.information.System.service.PositionService;

import java.util.ArrayList;

@RestController
@RequestMapping("/positions")
public class PositionController extends BaseController {

    @Autowired
    private PositionService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Position position = param != null ? new ObjectMapper().readValue(param, Position.class) : null;
        Long rows = service.count(position);

        return new RestResult(rows > 0 ? service.find(position, offset, limit) : new ArrayList<>(), rows);

    }

    @PostMapping
    public RestResult save(@RequestBody Position param) {
        param = service.save(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Position position) {
        position = service.update(position);
        return new RestResult(position, position != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
