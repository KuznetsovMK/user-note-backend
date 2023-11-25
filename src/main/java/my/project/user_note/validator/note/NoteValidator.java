package my.project.user_note.validator.note;

import lombok.RequiredArgsConstructor;
import my.project.user_note.entity.note.Note;
import my.project.user_note.exception.BadFieldValueException;
import my.project.user_note.exception.NotFoundException;
import my.project.user_note.repository.note.NoteRepository;
import my.project.user_note.request.note.UpdateNoteRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoteValidator {
    private final NoteRepository noteRepository;

    public void validate(String text) {
        if (text.length() > 5000) {
            throw new BadFieldValueException("Exceeded 5000 character limit");
        }
    }

    public void validate(UpdateNoteRequest request) {
        if (noteRepository.findById(request.getId()).isEmpty()) {
            throw new NotFoundException("Entity %s with id: %s not found".formatted(
                    Note.class.getSimpleName(), request.getId()));
        }

        validate(request.getText());
    }
}
