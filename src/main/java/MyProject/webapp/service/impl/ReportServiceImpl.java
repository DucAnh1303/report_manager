package MyProject.webapp.service.impl;

import MyProject.webapp.exception.GeneralException;
import MyProject.webapp.modle.entity.ReportDetailEntity;
import MyProject.webapp.modle.entity.ReportEntity;
import MyProject.webapp.modle.request.report.ReportDetailRequest;
import MyProject.webapp.modle.request.report.ReportRequest;
import MyProject.webapp.modle.request.report.ReportRequestEdit;
import MyProject.webapp.modle.request.report.ReportRequestEditDetail;
import MyProject.webapp.repository.repositoryjpa.ReportRepository;
import MyProject.webapp.repository.repositoryjpa.ReportDetailRepository;
import MyProject.webapp.response.response.report.ReportDetailResponse;
import MyProject.webapp.response.response.report.ReportProcedure;
import MyProject.webapp.response.response.report.ReportResponse;
import MyProject.webapp.service.ReportService;
import MyProject.webapp.until.DateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

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

    private List<ReportProcedure> getReport(int pageSize, int pageNo) {
        int offset = pageSize * (pageNo - 1);
        return jdbcTemplate.query("{CALL get_report(" + pageSize + "," + offset + ")}", new BeanPropertyRowMapper<>(ReportProcedure.class));
    }

    public Set<ReportResponse> report(int pageSize, int pageNo) throws GeneralException {
        try {
            List<ReportResponse> reportRes = new ArrayList<>();
            List<ReportProcedure> reportProcedures = getReport(pageSize, pageNo);
            reportProcedures.forEach(report -> reportRes.add(new ReportResponse(report)));
            Set<ReportResponse> getReports = new HashSet<>(reportRes);
            for (ReportResponse response : getReports) {
                List<ReportDetailResponse> reportDetailResponses = new ArrayList<>();
                reportProcedures.stream().filter(procedure -> procedure.getId() == response.getId()).collect(Collectors.toList())
                        .forEach(p -> reportDetailResponses.add(new ReportDetailResponse(p)));
                response.setTotalTime((float) reportDetailResponses.stream().mapToDouble(ReportDetailResponse::getRealTime).sum());
                response.setContents(reportDetailResponses);
            }
            return getReports;
        } catch (Exception exception) {
            throw new GeneralException(exception.getMessage());
        }
    }

    public ReportResponse addReport(ReportRequest request) throws GeneralException {
        try {
            ReportEntity reportEntity = new ReportEntity();
            reportEntity.setTaskId(request.getTaskId());
            reportEntity.setCreatedDate(new Date());
            reportEntity = reportRepository.save(reportEntity);
            List<ReportDetailEntity> detailEntities = reportDetailRepository.saveAll(convertDetail(request, reportEntity.getId()));
            return new ReportResponse(reportEntity, detailEntities);
        } catch (Exception ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public ReportResponse editReport(ReportRequestEdit requestEdit) throws GeneralException {
        try {
            ReportEntity reportEntity = new ReportEntity();
            reportEntity.setId(reportEntity.getId());
            reportEntity.setTaskId(requestEdit.getTaskId());
            reportEntity.setCreatedDate(new Date());
            reportEntity = reportRepository.save(reportEntity);
            List<ReportDetailEntity> detailEntities = reportDetailRepository.saveAll(convertEditDetail(requestEdit, reportEntity.getId()));
            return new ReportResponse(reportEntity, detailEntities);
        } catch (Exception ex) {
            throw new GeneralException(ex.getMessage());
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

    private List<ReportDetailEntity> convertEditDetail(ReportRequestEdit request, int reportId) throws ParseException {
        List<ReportDetailEntity> detailEntities = new ArrayList<>();
        for (ReportRequestEditDetail detailRequest : request.getContents()) {
            ReportDetailEntity reportDetailEntity = new ReportDetailEntity();
            reportDetailEntity.setId(detailRequest.getIdDetail());
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
