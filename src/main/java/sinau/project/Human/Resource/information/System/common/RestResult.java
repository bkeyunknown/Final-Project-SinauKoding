package sinau.project.Human.Resource.information.System.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult implements Serializable {

    private Object data;

    private Long rows;

    private String status = StatusCode.OPERATION_SUCCESS;

    public RestResult(Object data, Long rows, String status) {
        this.data = data;
        this.rows = rows;
        this.status = status;
    }

    public RestResult(Object data, Long rows) {
        this.data = data;
        this.rows = rows;
    }

    public RestResult(Object data, String status) {
        this.data = data;
        this.status = status;
    }

    public RestResult(Object data) {
        this.data = data;
    }

    public RestResult(String status) {
        this.status = status;
    }
}
