package MyProject.webapp.response.response.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProcedure {
    private int id;
    private int taskId;
    private int detailId;
    private float totalTime;
    private float realTime;
    private String title;
    private String issue;
    private int priority;
    private int status;
    private String progress;
    private String link;
    private float workTime;
    private String workDate;
    private int memberId;
}
