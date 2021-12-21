package sinau.project.Human.Resource.information.System.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult implements Serializable {

    private Object data;

    private Long rows;

    private String status = StatusCode.OPERATION_SUCCESS;

}
