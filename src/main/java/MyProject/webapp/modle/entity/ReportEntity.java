package MyProject.webapp.modle.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "report")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "report_name")
    private String reportName;
    @Column(name = "issue_id")
    private int issueId;
    @Column(name = "priority_id")
    private int priorityId;
    @Column(name = "status_id")
    private int statusId;
    @Column(name = "work_time")
    private float workTime;
    @Column(name = "word_date")
    private Date wordDate;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;
    @Column(name = "tickit_id")
    private String tickitId;
    @Column(name = "task_give_person")
    private String taskGivePerson;
    @Column(name = "parent_id")
    private String parentId;

}
