package MyProject.webapp.controller;

import MyProject.webapp.modle.request.ReportRequest;
import MyProject.webapp.modle.response.BaseResponse;
import MyProject.webapp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public ResponseEntity<Object> reportAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>(HttpStatus.OK.value(), "success", reportService.report()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/report/add")
    public ResponseEntity<Object> add(@Valid @RequestBody ReportRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>(HttpStatus.CREATED.value(), "add success", reportService.addReport(request)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
