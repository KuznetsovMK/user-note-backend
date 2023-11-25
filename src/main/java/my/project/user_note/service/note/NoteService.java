package my.project.user_note.service.note;

import com.model.NoteDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import my.project.user_note.mapper.note.NoteMapper;
import my.project.user_note.repository.note.NoteRepository;
import my.project.user_note.request.note.CreateNoteRequest;
import my.project.user_note.request.note.UpdateNoteRequest;
import my.project.user_note.validator.note.NoteValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteValidator noteValidator;
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @SneakyThrows
    public void createNote(CreateNoteRequest request) {
        noteValidator.validateText(request.getText());
        noteRepository.save(noteMapper.toEntity(request));
    }

    public void updateNote(UpdateNoteRequest request) {
        noteValidator.validateText(request);
        noteRepository.save(noteMapper.toEntity(request));
    }

    public NoteDto findById(UUID id) {
        noteValidator.validateId(id);

        var note = noteRepository.findById(id).orElse(null);
        return noteMapper.toDto(note);
    }
}

