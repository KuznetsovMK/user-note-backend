package my.project.user_note.mapper.user;

import com.model.CreateClientUserRequestDto;
import my.project.user_note.entity.user.ClientUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientUserMapper {
    ClientUser toEntity(CreateClientUserRequestDto request);
}

