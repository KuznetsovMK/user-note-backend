package my.project.user_note.controller.note;

import com.api.NoteApi;
import com.model.NoteDto;
import lombok.RequiredArgsConstructor;
import my.project.user_note.service.note.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class NoteController implements NoteApi {
    private final NoteService noteService;

    @Override
    public ResponseEntity<NoteDto> findById(UUID id) {
        var result = noteService.findById(id);
        return ResponseEntity.ok(result);
    }
}
