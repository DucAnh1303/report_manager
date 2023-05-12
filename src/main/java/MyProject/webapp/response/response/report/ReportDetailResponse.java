package MyProject.webapp.response.response.report;

import MyProject.webapp.modle.entity.ReportDetailEntity;
import MyProject.webapp.until.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
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

    public ReportDetailResponse(ReportProcudure reportProcudure) {
        this.id = reportProcudure.getId();
        this.title = reportProcudure.getTitle();
        this.issue = reportProcudure.getIssue();
        this.progress = reportProcudure.getProgress();
        this.link = reportProcudure.getLink();
        this.workTime = reportProcudure.getWorkTime();
        this.workDate = reportProcudure.getWorkDate();
    }
}
