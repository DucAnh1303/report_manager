package MyProject.webapp.response.response.report;

import MyProject.webapp.modle.entity.ReportDetailEntity;
import MyProject.webapp.until.DateUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportDetailResponse {
    private int id;
    private String title;
    private String issue;
    private int priority;
    private int status;
    private String progress;
    private String link;
    private float workTime;
    private String workDate;
    private float realTime;
    private int memberId;

    public ReportDetailResponse(ReportProcedure reportProcedure) {
        this.id = reportProcedure.getDetailId();
        this.title = reportProcedure.getTitle();
        this.issue = reportProcedure.getIssue();
        this.progress = reportProcedure.getProgress();
        this.link = reportProcedure.getLink();
        this.workTime = reportProcedure.getWorkTime();
        this.workDate = reportProcedure.getWorkDate();
        this.realTime = reportProcedure.getRealTime();
        this.memberId = reportProcedure.getMemberId();
    }

    public ReportDetailResponse(ReportDetailEntity reportDetailEntity) {
        this.id = reportDetailEntity.getId();
        this.title = reportDetailEntity.getTitle();
        this.issue = reportDetailEntity.getIssue();
        this.progress = reportDetailEntity.getProgress();
        this.link = reportDetailEntity.getLink();
        this.workTime = reportDetailEntity.getWorkTime();
        this.workDate = DateUtil.dateToString(reportDetailEntity.getWorkDate(), "yyyy-MM-dd");
        this.memberId = reportDetailEntity.getMemberId();
    }
}
