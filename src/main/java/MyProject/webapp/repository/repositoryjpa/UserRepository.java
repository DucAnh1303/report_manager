package MyProject.webapp.repository.repositoryjpa;

import MyProject.webapp.modle.entity.AuthLoginEntity;
import MyProject.webapp.repository.AuthJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepository {
    private final AuthJPARepository authJPARepository;

    public AuthLoginEntity save(AuthLoginEntity AuthLoginEntity) {
        return authJPARepository.save(AuthLoginEntity);
    }

    public AuthLoginEntity findByUserName(String userName) {
        return authJPARepository.findByUserName(userName).get();
    }
}
