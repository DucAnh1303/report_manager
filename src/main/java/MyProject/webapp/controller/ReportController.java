package MyProject.webapp.controller;

import MyProject.webapp.exception.GeneralException;
import MyProject.webapp.modle.request.report.ReportRequest;
import MyProject.webapp.modle.request.report.ReportRequestEdit;
import MyProject.webapp.response.response.BaseResponse;
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
    public ResponseEntity<Object> reportAll(@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) throws GeneralException {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "success", reportService.report(pageSize, pageNo)));
    }

    @PostMapping("/report/add")
    public ResponseEntity<Object> add(@Valid @RequestBody ReportRequest request) throws GeneralException {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.CREATED.value(), "add success", reportService.addReport(request)));
    }

    @PostMapping("/report/edit")
    public ResponseEntity<Object> edit(@Valid @RequestBody ReportRequestEdit request) throws GeneralException {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.CREATED.value(), "add success", reportService.editReport(request)));
    }
}
