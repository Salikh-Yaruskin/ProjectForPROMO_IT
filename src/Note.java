import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    String note;
    Date createDate;

    public Note(String note, Date createDate){
        this.note = note;
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return DATE_FORMAT.format(createDate) + " " + note;
    }

    public static Note fromString(String str) {
        int firstSpace = str.indexOf(' ');
        if (firstSpace != -1) {
            String dateString = str.substring(0, firstSpace);
            String noteText = str.substring(firstSpace + 1);
            try {
                Date createDate = DATE_FORMAT.parse(dateString);
                return new Note(noteText, createDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
