package my.project.user_note.controller.note;

import com.api.NoteApi;
import com.model.NoteDto;
import lombok.RequiredArgsConstructor;
import my.project.user_note.service.note.NoteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

        var responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");


        return ResponseEntity.ok().headers(responseHeaders).body(result);
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        noteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
