package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.Attendance;
import sinau.project.Human.Resource.information.System.service.AttendanceService;
import sinau.project.Human.Resource.information.System.utils.DateUtils;

import java.util.ArrayList;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/attendances")
public class AttendanceController extends BaseController {

    @Autowired
    private AttendanceService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Attendance attendance = param != null ? new ObjectMapper().readValue(param, Attendance.class) : null;
        Long rows = service.count(attendance);

        return new RestResult(rows > 0 ? service.find(attendance, offset, limit) : new ArrayList<>(), rows);

    }

    @GetMapping("/by-date")
    public RestResult findByDate(@RequestParam(value = "param", required = false) String param,
                                 @RequestParam(value = "start-date") String startDate,
                                 @RequestParam(value = "end-date") String endDate) throws JsonProcessingException {
        RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

        Attendance attendance = param != null ? new ObjectMapper().readValue(param, Attendance.class) : null;

        result.setData(service.findByDate(attendance,
                DateUtils.fromString(startDate),
                DateUtils.fromString(endDate)));
        result.setRows((long) service.findByDate(attendance,
                DateUtils.fromString(startDate),
                DateUtils.fromString(endDate)).size());

        return result;

    }

    @PostMapping
    public RestResult save(@RequestBody Attendance param) {
        param = service.save(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Attendance attendance) {
        attendance = service.update(attendance);
        return new RestResult(attendance, attendance != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
