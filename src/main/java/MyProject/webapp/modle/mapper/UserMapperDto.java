package MyProject.webapp.modle.mapper;

import MyProject.webapp.modle.dto.UserDto;
import MyProject.webapp.modle.entity.AuthLoginEntity;
import org.springframework.stereotype.Component;


@Component
public class UserMapperDto implements UserMapper {
    @Override
    public UserDto mapDtoToEntity(AuthLoginEntity authLoginEntity) {
        if (authLoginEntity == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(authLoginEntity.getId());
        userDto.setUserName(authLoginEntity.getUserName());
        userDto.setPassword(authLoginEntity.getPassword());
        return userDto;
    }
}
