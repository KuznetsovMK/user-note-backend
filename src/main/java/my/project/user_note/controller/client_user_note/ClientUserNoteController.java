package my.project.user_note.controller.client_user_note;

import com.api.ClientUserNoteApi;
import com.model.CreateClientUserNoteRequest;
import com.model.ShortNote;
import lombok.RequiredArgsConstructor;
import my.project.user_note.service.client_user_note.ClientUserNoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ClientUserNoteController implements ClientUserNoteApi {
    private final ClientUserNoteService clientUserNoteService;

    @Override
    public ResponseEntity<Void> createNote(CreateClientUserNoteRequest request) {
        clientUserNoteService.createNote(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ShortNote>> findAllMyNotes(UUID clientUserId, Integer limit, Integer offset) {
        var result = clientUserNoteService.findAllMyNotes(clientUserId, limit, offset);
        return ResponseEntity.ok(result);
    }
}
