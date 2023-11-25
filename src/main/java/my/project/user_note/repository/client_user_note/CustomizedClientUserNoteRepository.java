package my.project.user_note.repository.client_user_note;

import java.util.List;
import java.util.UUID;

public interface CustomizedClientUserNoteRepository {

    List<String> findAllMyNotes(UUID clientUserId, Integer limit, Integer offset);
}
