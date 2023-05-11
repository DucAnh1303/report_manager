package MyProject.webapp.modle.response.report;

import MyProject.webapp.modle.entity.ReportEntity;
import MyProject.webapp.until.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
public class ReportResponse {
    private String member;
    private int taskId;
    private String title;
    private String issue;
    private int priority;
    private int status;
    private String progress;
    private String link;
    private float totalTime;
    private float work_time;
    private String workDate;
    private Date createdDate;

    public ReportResponse(ReportEntity reportEntity, float totalTime) {
        this.member = reportEntity.getMember();
        this.taskId = reportEntity.getTaskId();
        this.title = reportEntity.getTitle();
        this.issue = reportEntity.getIssue();
        this.priority = reportEntity.getPriority();
        this.status = reportEntity.getStatus();
        this.progress = reportEntity.getProgress();
        this.link = reportEntity.getLink();
        this.totalTime = totalTime;
        this.work_time = reportEntity.getWork_time();
        this.workDate = DateUtil.dateToString(reportEntity.getWorkDate(), "yyyy-MM-dd");
        this.createdDate = reportEntity.getCreatedDate();
    }
}
