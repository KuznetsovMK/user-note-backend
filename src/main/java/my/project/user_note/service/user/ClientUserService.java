package my.project.user_note.service.user;

import com.model.CreateClientUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import my.project.user_note.mapper.user.ClientUserMapper;
import my.project.user_note.repository.user.ClientUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientUserService {
    private final ClientUserRepository clientUserRepository;
    private final ClientUserMapper clientUserMapper;

    @SneakyThrows
    public void createUser(CreateClientUserRequest request) {
        clientUserRepository.save(clientUserMapper.toEntity(request));
    }
}

