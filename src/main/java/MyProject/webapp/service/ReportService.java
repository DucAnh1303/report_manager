package MyProject.webapp.service;

import MyProject.webapp.exception.GeneralException;
import MyProject.webapp.modle.request.report.ReportRequest;
import MyProject.webapp.modle.request.report.ReportRequestEdit;
import MyProject.webapp.response.response.report.ReportResponse;

import java.util.Set;

public interface ReportService {
    Set<ReportResponse> report(int pageSize, int pageNo) throws GeneralException;

    ReportResponse addReport(ReportRequest request) throws GeneralException;

    ReportResponse editReport(ReportRequestEdit requestEdit) throws GeneralException;

}
