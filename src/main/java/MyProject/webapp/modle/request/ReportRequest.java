package MyProject.webapp.modle.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class ReportRequest {
    @NotNull
    private int taskId;
    private List<ReportDetailRequest> contents;
}
