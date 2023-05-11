package MyProject.webapp.modle.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parameter")
public class ParameterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "key_code")
    private String keyCode;
    @Column(name = "key_id")
    private int keyId;
    @Column(name = "code_name")
    private String codeName;
}
