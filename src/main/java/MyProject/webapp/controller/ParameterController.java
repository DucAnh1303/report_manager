package MyProject.webapp.controller;

import MyProject.webapp.response.response.BaseResponse;
import MyProject.webapp.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping("/parameter")
    public ResponseEntity<Object> getParameter(@RequestParam("keyCode") String keyCode) {
        try {
            return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "success", parameterService.getStatus(keyCode)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
