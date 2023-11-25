package my.project.user_note.service.client_user_note;

import com.model.CreateClientUserNoteRequest;
import lombok.RequiredArgsConstructor;
import my.project.user_note.mapper.client_user_note.ClientUserNoteMapper;
import my.project.user_note.repository.client_user_note.ClientUserNoteRepository;
import my.project.user_note.request.client_user_note.CreateClientUserNoteRequestV2;
import my.project.user_note.request.note.CreateNoteRequest;
import my.project.user_note.service.note.NoteService;
import my.project.user_note.validator.client_user_note.ClientUserNoteValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientUserNoteService {
    private final ClientUserNoteValidator clientUserNoteValidator;
    private final NoteService noteService;
    private final ClientUserNoteRepository clientUserNoteRepository;
    private final ClientUserNoteMapper clientUserNoteMapper;

    @Transactional
    public void createNote(CreateClientUserNoteRequest request) {
        clientUserNoteValidator.validate(request);

        var noteId = UUID.randomUUID();

        noteService.createNote(CreateNoteRequest.builder()
                .id(noteId)
                .text(request.getText())
                .build());

        clientUserNoteRepository.save(clientUserNoteMapper.toEntity(CreateClientUserNoteRequestV2.builder()
                .id(UUID.randomUUID())
                .clientUserId(request.getClientUserId())
                .noteId(noteId)
                .build()));

    }
}
