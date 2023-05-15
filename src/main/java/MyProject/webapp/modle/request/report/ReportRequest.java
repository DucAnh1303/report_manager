package MyProject.webapp.modle.request.report;

import lombok.Data;

import java.util.List;

@Data
public class ReportRequest {
    private int taskId;
    private List<ReportDetailRequest> contents;
}
