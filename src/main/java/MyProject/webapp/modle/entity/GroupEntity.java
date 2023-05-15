package MyProject.webapp.modle.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "member")
@Entity
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "member_name")
    private String memberName;
}
