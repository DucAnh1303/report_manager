package MyProject.webapp.repository.repositoryjpa;

import MyProject.webapp.modle.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterEntity,Integer> {

    List<ParameterEntity> findByKeyCode(String keyCode);
}
