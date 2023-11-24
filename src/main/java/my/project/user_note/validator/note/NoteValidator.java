package my.project.user_note.validator.note;

import lombok.RequiredArgsConstructor;
import my.project.user_note.exception.BadFieldValueException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoteValidator {

    public void validate(String text) {
        if (text.length() > 5000) {
            throw new BadFieldValueException("Exceeded 5000 character limit");
        }
    }
}
