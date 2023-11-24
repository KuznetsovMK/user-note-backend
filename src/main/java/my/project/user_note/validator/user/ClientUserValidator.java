package my.project.user_note.validator.user;

import com.model.CreateClientUserRequest;
import lombok.RequiredArgsConstructor;
import my.project.user_note.exception.handler.AlreadyExistsException;
import my.project.user_note.repository.user.ClientUserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientUserValidator {
    private final ClientUserRepository clientUserRepository;

    public void validate(CreateClientUserRequest request) {
        if (clientUserRepository.existsByLogin(request.getLogin())) {
            throw new AlreadyExistsException("Entity with login: %s already exists".formatted(request.getLogin()));
        }
    }
}
