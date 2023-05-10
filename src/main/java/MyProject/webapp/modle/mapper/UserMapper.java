package MyProject.webapp.modle.mapper;

import MyProject.webapp.modle.dto.UserDto;
import MyProject.webapp.modle.entity.AuthLoginEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface UserMapper {

    @Mapping(source = "userEntity.id",target = "id")
    @Mapping(source = "userEntity.userName",target = "userName")
    @Mapping(source = "userEntity.password",target = "password")
    UserDto mapDtoToEntity(AuthLoginEntity authLoginEntity);
}
