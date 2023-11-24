package my.project.user_note.mapper.note;

import my.project.user_note.entity.note.Note;
import my.project.user_note.request.note.CreateNoteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note toEntity(CreateNoteRequest request);
}
