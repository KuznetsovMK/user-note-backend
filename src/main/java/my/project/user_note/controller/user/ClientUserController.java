package my.project.user_note.controller.user;

import com.api.ClientUserApi;
import com.model.CreateClientUserRequest;
import lombok.RequiredArgsConstructor;
import my.project.user_note.service.user.ClientUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClientUserController implements ClientUserApi {
    private final ClientUserService clientUserService;

    @Override
    public ResponseEntity<Void> createUser(CreateClientUserRequest request) {
        clientUserService.createUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
