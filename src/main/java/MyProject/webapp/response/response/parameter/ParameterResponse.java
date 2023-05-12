package MyProject.webapp.response.response.parameter;

import MyProject.webapp.modle.entity.ParameterEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParameterResponse {
    private String codeName;
    private int keyId;
    private String keyCode;

    public ParameterResponse(ParameterEntity parameterEntity) {
        this.codeName = parameterEntity.getCodeName();
        this.keyId = parameterEntity.getKeyId();
        this.keyCode = parameterEntity.getKeyCode();
    }
}
