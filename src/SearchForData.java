import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class SearchForData {
    private static final SimpleDateFormat DATE_FORMAT  = new SimpleDateFormat("yyyy-MM-dd");
    public static List<Note> search(List<Note> notes, String date){
        List<Note> resultSearch = new ArrayList<>();
        try {
            Date searchDate = DATE_FORMAT.parse(date);
            for (Note note : notes){
                if(DATE_FORMAT.format(note.getCreateDate()).equals(date)){
                    resultSearch.add(note);
                }
            }
        } catch (ParseException e) {
            System.out.println("Неправильный формат даты. Введите дату в формате yyyy-MM-dd!!!!");
        }
        return resultSearch;
    }
}
