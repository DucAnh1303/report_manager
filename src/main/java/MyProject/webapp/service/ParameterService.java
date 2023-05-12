package MyProject.webapp.service;

import MyProject.webapp.modle.entity.ParameterEntity;

import java.util.List;

public interface ParameterService {
    List<ParameterEntity> getStatus(String keyCode);
}
