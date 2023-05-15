package MyProject.webapp.modle.request.report;

import lombok.Data;

@Data
public class ReportRequestEditDetail {
    private int idDetail;
    private String title;
    private int function;
    private String issue;
    private int status;
    private int priority;
    private float totalTime;
    private float realTime;
    private String workDate;
    private int memberId;
}
