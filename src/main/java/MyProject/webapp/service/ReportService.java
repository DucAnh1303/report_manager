package MyProject.webapp.service;

import MyProject.webapp.exception.GeneralException;
import MyProject.webapp.modle.request.ReportRequest;
import MyProject.webapp.response.response.report.ReportDetailResponse;
import MyProject.webapp.response.response.report.ReportProcudure;
import MyProject.webapp.response.response.report.ReportResponse;

import java.util.List;

public interface ReportService {
    List<ReportResponse> report(int pageSize, int pageNo) throws GeneralException;

}
