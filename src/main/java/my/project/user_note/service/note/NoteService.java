package my.project.user_note.service.note;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import my.project.user_note.mapper.note.NoteMapper;
import my.project.user_note.repository.note.NoteRepository;
import my.project.user_note.request.note.CreateNoteRequest;
import my.project.user_note.validator.note.NoteValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteValidator noteValidator;
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @SneakyThrows
    public void createNote(CreateNoteRequest request) {
        noteValidator.validate(request.getText());
        noteRepository.save(noteMapper.toEntity(request));
    }
}

