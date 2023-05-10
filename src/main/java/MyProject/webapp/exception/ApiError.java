package MyProject.webapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiError {
    private int code;
    private HttpStatus status;
    private List<String> errors;
}
