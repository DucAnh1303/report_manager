package MyProject.webapp.repository.repositoryjpa;

import MyProject.webapp.modle.entity.ReportEntity;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {
}
