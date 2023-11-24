package my.project.user_note.controller.client_user_note;

import com.api.ClientUserNoteApi;
import com.model.CreateClientUserNoteRequest;
import lombok.RequiredArgsConstructor;
import my.project.user_note.service.client_user_note.ClientUserNoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClientUserNoteController implements ClientUserNoteApi {
    private final ClientUserNoteService clientUserNoteService;

    @Override
    public ResponseEntity<Void> createNote(CreateClientUserNoteRequest request) {
        clientUserNoteService.createNote(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
