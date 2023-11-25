package my.project.user_note.mapper.note;

import com.model.NoteDto;
import com.model.ShortNoteDto;
import my.project.user_note.entity.note.Note;
import my.project.user_note.request.note.CreateNoteRequest;
import my.project.user_note.request.note.UpdateNoteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note toEntity(CreateNoteRequest request);

    Note toEntity(UpdateNoteRequest request);

    ShortNoteDto toDto(String text);

    NoteDto toDto(Note note);
}
