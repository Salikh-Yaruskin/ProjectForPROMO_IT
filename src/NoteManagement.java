import java.util.List;
import java.util.ArrayList;

public class NoteManagement {
    public List<Note> notes;
    public NoteWriter noteWriter;
    public NoteReader noteReader;

    public NoteManagement(String filePath){
        this.notes = new ArrayList<>();
        this.noteWriter = new NoteWriter(filePath);
        this.noteReader = new NoteReader(filePath);
        this.notes = noteReader.readNote();
    }

    public void addNote(Note note) {
        notes.add(note);
        noteWriter.writeNote(notes);
    }

    public List<Note> getNotes() {
        return notes;
    }
}

