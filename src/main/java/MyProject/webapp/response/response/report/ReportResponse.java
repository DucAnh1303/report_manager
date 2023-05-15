package MyProject.webapp.response.response.report;

import MyProject.webapp.modle.entity.ReportDetailEntity;
import MyProject.webapp.modle.entity.ReportEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ReportResponse {
    private int id;
    private int taskId;
    private float totalTime;
    List<ReportDetailResponse> contents = new ArrayList<>();

    public ReportResponse(ReportProcedure reportProcedure) {
        this.id = reportProcedure.getId();
        this.taskId = reportProcedure.getTaskId();
    }

    public ReportResponse(ReportEntity reportEntity, List<ReportDetailEntity> reportDetailEntities) {
        this.id = reportEntity.getId();
        this.taskId = reportEntity.getTaskId();
        reportDetailEntities.forEach(p -> this.contents.add(new ReportDetailResponse(p)));
    }

}
