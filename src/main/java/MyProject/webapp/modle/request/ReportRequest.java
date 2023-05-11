package MyProject.webapp.modle.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReportRequest {
    private String member;
    private int taskId;
    private String title;
    private String issue;
    private int priority;
    private int status;
    private String progress;
    private String link;
    private float work_time;
    private String workDate;
    private Date createdDate;
}
