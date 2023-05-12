package MyProject.webapp.modle.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "report")
@Entity
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "task_id")
    private String taskId;
    @Column(name = "created_date")
    private Date createdDate;
}
