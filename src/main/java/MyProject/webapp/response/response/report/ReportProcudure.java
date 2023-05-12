package MyProject.webapp.response.response.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProcudure {
    private int id;
    private int taskId;
    private float totalTime;
    private String title;
    private String issue;
    private int priority;
    private int status;
    private String progress;
    private String link;
    private float workTime;
    private String workDate;
}
