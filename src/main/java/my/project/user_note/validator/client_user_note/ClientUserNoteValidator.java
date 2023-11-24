package my.project.user_note.validator.client_user_note;

import com.model.CreateClientUserNoteRequest;
import lombok.RequiredArgsConstructor;
import my.project.user_note.validator.user.ClientUserValidator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientUserNoteValidator {
    private final ClientUserValidator clientUserValidator;

    public void validate(CreateClientUserNoteRequest request) {
        clientUserValidator.validateClientUserId(request.getClientUserId());
    }
}
