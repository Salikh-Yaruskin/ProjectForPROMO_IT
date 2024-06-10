import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NoteReader {
    public String filePath;

    public NoteReader(String filePath){
        this.filePath = filePath;
    }

    public List<Note> readNote(){
        List<Note> notes = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Note note = Note.fromString(line);
                if (note != null) {
                    notes.add(note);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return notes;
    }
}
