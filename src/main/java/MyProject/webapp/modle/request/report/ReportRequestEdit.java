package MyProject.webapp.modle.request.report;

import lombok.Data;

import java.util.List;

@Data
public class ReportRequestEdit {
    private int id;
    private int taskId;
    private List<ReportRequestEditDetail> contents;
}
