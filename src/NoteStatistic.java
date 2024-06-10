import java.text.SimpleDateFormat;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;

public class NoteStatistic {
    public static void printStatistic(List<Note> notes){
        int totalNotes = notes.size();
        int totalChar = 0;
        Map<String, Integer> countDate = new HashMap<>();


        for (Note note : notes){
            totalChar += note.getNote().length();

            String date = new SimpleDateFormat("yyyy-MM-dd").format(note.getCreateDate());
            countDate.put(date, countDate.getOrDefault(date, 0) + 1);
        }

        String mostActiveDay = null;
        int maxNotes = 0;

        for (Map.Entry<String, Integer> entry : countDate.entrySet()) {
            if (entry.getValue() > maxNotes) {
                maxNotes = entry.getValue();
                mostActiveDay = entry.getKey();
            }
        }

        System.out.println("Кол-во записей: " + totalNotes);
        System.out.println("Кол-во символов: " + totalChar);
        System.out.println("Самый активный день: " + mostActiveDay + " = " + maxNotes);
    }
}
