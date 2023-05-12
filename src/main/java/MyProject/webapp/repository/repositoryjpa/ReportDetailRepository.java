package MyProject.webapp.repository.repositoryjpa;

import MyProject.webapp.modle.entity.ReportDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDetailRepository extends JpaRepository<ReportDetailEntity, Integer> {

}
