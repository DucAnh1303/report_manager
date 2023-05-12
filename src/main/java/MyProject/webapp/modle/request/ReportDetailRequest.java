package MyProject.webapp.modle.request;

import lombok.Data;

@Data
public class ReportDetailRequest {
    private String title;
    private int function;
    private String issue;
    private int status;
    private int priority;
    private float totalTime;
    private float realTime;
    private String workDate;
}
