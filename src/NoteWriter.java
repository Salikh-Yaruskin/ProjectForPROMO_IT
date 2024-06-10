import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NoteWriter {
    private String filePath;

    public NoteWriter(String filePath){
        this.filePath = filePath;
    }

    public void writeNote(List<Note> notes) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, false))) {
            for (Note note : notes) {
                bufferedWriter.write(note.toString());
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
