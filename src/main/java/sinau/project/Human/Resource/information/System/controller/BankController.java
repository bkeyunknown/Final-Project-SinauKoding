package sinau.project.Human.Resource.information.System.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinau.project.Human.Resource.information.System.common.RestResult;
import sinau.project.Human.Resource.information.System.common.StatusCode;
import sinau.project.Human.Resource.information.System.entity.Bank;
import sinau.project.Human.Resource.information.System.service.BankService;

import java.util.ArrayList;

@RestController
@RequestMapping("/banks")
public class BankController extends BaseController {

    @Autowired
    private BankService service;

    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {

        Bank bank = param != null ? new ObjectMapper().readValue(param, Bank.class) : null;
        Long rows = service.count(bank);

        return new RestResult(rows > 0 ? service.find(bank, offset, limit) : new ArrayList<>(), rows);

    }

    @PostMapping
    public RestResult save(@RequestBody Bank param) {
        param = service.save(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Bank bank) {
        bank = service.update(bank);
        return new RestResult(bank, bank != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
