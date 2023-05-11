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
    @Column(name = "member")
    private String member;
    @Column(name = "task_id")
    private int taskId;
    @Column(name = "title")
    private String title;
    @Column(name = "issue")
    private String issue;
    @Column(name = "priority")
    private int priority;
    @Column(name = "status")
    private int status;
    @Column(name = "progress")
    private String progress;
    @Column(name = "link")
    private String link;
    @Column(name = "work_time")
    private float work_time;
    @Column(name = "work_date")
    private Date workDate;
    @Column(name = "created_date")
    private Date createdDate;


}
