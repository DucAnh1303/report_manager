package MyProject.webapp.service.impl;

import MyProject.webapp.exception.GeneralException;
import MyProject.webapp.modle.entity.ReportDetailEntity;
import MyProject.webapp.modle.entity.ReportEntity;
import MyProject.webapp.modle.request.ReportDetailRequest;
import MyProject.webapp.modle.request.ReportRequest;
import MyProject.webapp.repository.repositoryjpa.ReportRepository;
import MyProject.webapp.response.response.report.ReportDetailResponse;
import MyProject.webapp.repository.repositoryjpa.ReportDetailRepository;
import MyProject.webapp.response.response.report.ReportProcudure;
import MyProject.webapp.response.response.report.ReportResponse;
import MyProject.webapp.service.ReportService;
import MyProject.webapp.until.DateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportDetailRepository reportDetailRepository;
    private final ReportRepository reportRepository;

    private final JdbcTemplate jdbcTemplate;

    public ReportServiceImpl(ReportDetailRepository reportDetailRepository, ReportRepository reportRepository, JdbcTemplate jdbcTemplate) {
        this.reportDetailRepository = reportDetailRepository;
        this.reportRepository = reportRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<ReportProcudure> getReport(int pageSize, int pageNo) {
        int offset = pageSize * (pageNo - 1);
        return jdbcTemplate.query("{CALL get_report(" + pageSize + "," + offset + ")}", new BeanPropertyRowMapper<>(ReportProcudure.class));
    }

    public ReportResponse report(int pageSize, int pageNo) throws GeneralException {
        try {
            List<ReportProcudure> reportProcudures = getReport(pageSize, pageNo);
            return new ReportResponse(reportProcudures);
        } catch (Exception exception) {
            throw new GeneralException(exception);
        }
    }

    public List<ReportResponse> addReport(ReportRequest request) throws GeneralException {
        try {
            ReportEntity reportEntity = new ReportEntity();
            reportEntity.setTaskId(reportEntity.getTaskId());
            reportEntity.setCreatedDate(new Date());
            reportEntity = reportRepository.save(reportEntity);
            List<ReportDetailEntity> detailEntities = convertDetail(request, reportEntity.getId());
            float totalTime = (float) detailEntities.stream().mapToDouble(ReportDetailEntity::getRealTime).sum();
            reportDetailRepository.saveAll(detailEntities);
            return null;
        } catch (Exception ex) {
            throw new GeneralException(ex);
        }
    }

    private List<ReportDetailEntity> convertDetail(ReportRequest request, int reportId) throws ParseException {
        List<ReportDetailEntity> detailEntities = new ArrayList<>();
        for (ReportDetailRequest detailRequest : request.getContents()) {
            ReportDetailEntity reportDetailEntity = new ReportDetailEntity();
            reportDetailEntity.setReportId(reportId);
            reportDetailEntity.setTitle(detailRequest.getTitle());
            reportDetailEntity.setFunctionId(detailRequest.getFunction());
            reportDetailEntity.setIssue(detailRequest.getIssue());
            reportDetailEntity.setStatusId(detailRequest.getStatus());
            reportDetailEntity.setPriorityId(detailRequest.getPriority());
            reportDetailEntity.setWorkTime(detailRequest.getTotalTime());
            reportDetailEntity.setRealTime(detailRequest.getRealTime());
            reportDetailEntity.setWorkDate(DateUtil.formatStringToDate(detailRequest.getWorkDate(), "yyyy-MM-dd"));
            detailEntities.add(reportDetailEntity);
        }
        return detailEntities;

    }
}
