package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.User;
import sinau.project.Human.Resource.information.System.service.UserService;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        User user = param != null ? new ObjectMapper().readValue(param, User.class) : null;
        Long rows = service.count(user);

        return new RestResult(rows > 0 ? service.find(user, offset, limit) : new ArrayList<>(), rows);

    }

    @PutMapping
    public RestResult update(@RequestBody User entity) {
        RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

        if (entity != null) {
            result.setData(service.update(entity));
            result.setStatus(StatusCode.UPDATE_SUCCESS);
        }

        return result;
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        boolean deleted = false;
        User entity = service.findById(id);

        if (entity != null) {
            service.updateDeleteStatus(id);
            deleted = service.delete(id);
        }

        return new RestResult(deleted ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }
}
