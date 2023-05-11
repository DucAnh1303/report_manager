package MyProject.webapp.service.impl;

import MyProject.webapp.modle.entity.ReportEntity;
import MyProject.webapp.modle.request.ReportRequest;
import MyProject.webapp.modle.response.report.ReportResponse;
import MyProject.webapp.repository.repositoryjpa.ReportRepository;
import MyProject.webapp.service.ReportService;
import MyProject.webapp.until.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<ReportResponse> report() {
        List<ReportResponse> responses = new ArrayList<>();
        reportRepository.findAll().forEach(
                report -> responses.add(new ReportResponse(report, 0))
        );
        return responses;
    }

    public ReportResponse addReport(ReportRequest request) throws ParseException {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setMember(reportEntity.getMember());
        reportEntity.setTaskId(request.getTaskId());
        reportEntity.setTitle(request.getTitle());
        reportEntity.setIssue(request.getIssue());
        reportEntity.setPriority(request.getPriority());
        reportEntity.setStatus(request.getStatus());
        reportEntity.setProgress(request.getProgress());
        reportEntity.setLink(request.getLink());
        reportEntity.setWork_time(request.getWork_time());
        reportEntity.setWorkDate(DateUtil.formatStringToDate(request.getWorkDate(), "yyyy-MM-dd"));
        reportEntity.setCreatedDate(new Date());
        reportEntity = reportRepository.save(reportEntity);
        return new ReportResponse(reportEntity, 0);
    }
}
