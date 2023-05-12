package MyProject.webapp.response.response.report;

import lombok.Data;

import java.util.List;

@Data
public class ReportResponse {
    private int id;
    private int taskId;
    private float totalTime;
    List<ReportDetailResponse> contents;

    public ReportResponse(List<ReportProcudure> reportProcudure) {
        this.id = reportProcudure.get(0).getId();
        this.taskId = reportProcudure.get(0).getTaskId();
        reportProcudure.stream().forEach(i ->
                this.contents.add(new ReportDetailResponse(i)));

    }
}
