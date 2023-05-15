package MyProject.webapp.modle.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "report_detail")
public class ReportDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "report_id")
    private int reportId;
    @Column(name = "title")
    private String title;
    @Column(name = "issue")
    private String issue;
    @Column(name = "priority_id")
    private int priorityId;
    @Column(name = "status_id")
    private int statusId;
    @Column(name = "function_id")
    private int functionId;
    @Column(name = "progress")
    private String progress;
    @Column(name = "link")
    private String link;
    @Column(name = "work_time")
    private float workTime;
    @Column(name = "real_time")
    private float realTime;
    @Column(name = "work_date")
    private Date workDate;
    @Column(name = "member_id")
    private int memberId;
}
