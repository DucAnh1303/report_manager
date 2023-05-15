package MyProject.webapp.modle.request.report;

import lombok.Data;

@Data
public class ReportDetailRequest {
    private String title;
    private int functionId;
    private String issue;
    private int statusId;
    private int priorityId;
    private float totalTime;
    private float realTime;
    private String workDate;
    private int memberId;
}
