package MyProject.webapp.service.impl;

import MyProject.webapp.modle.entity.ParameterEntity;
import MyProject.webapp.repository.repositoryjpa.ParameterRepository;
import MyProject.webapp.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private ParameterRepository parameterRepository;

    public List<ParameterEntity> getStatus(String keyCode) {
        List<ParameterEntity> re = parameterRepository.findAll().stream().filter(i -> i.getKeyCode().equals(keyCode)).collect(Collectors.toList());
        return re;
    }
}
