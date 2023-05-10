package MyProject.webapp.repository;


import MyProject.webapp.modle.entity.AuthLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthJPARepository extends JpaRepository<AuthLoginEntity, Integer> , JpaSpecificationExecutor<AuthLoginEntity> {

    Optional<AuthLoginEntity> findByUserName(String userName);
}
