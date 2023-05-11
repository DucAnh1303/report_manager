package MyProject.webapp.service;

import MyProject.webapp.modle.request.ReportRequest;
import MyProject.webapp.modle.response.report.ReportResponse;

import java.text.ParseException;
import java.util.List;

public interface ReportService {
    List<ReportResponse> report();

    ReportResponse addReport(ReportRequest request) throws ParseException;
}
