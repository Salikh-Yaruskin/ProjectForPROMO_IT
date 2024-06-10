import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        NoteManagement noteManagement = new NoteManagement("myNotes.txt");
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Введите команду:");
            String comm = scanner.nextLine();

            if (comm.equalsIgnoreCase("#read")){
                for (Note note : noteManagement.getNotes()){
                    System.out.println(note);
                }
            }
            else if (comm.equalsIgnoreCase("#write")){
                System.out.println("Введите ваши планы на сегодня");
                String newNote = scanner.nextLine();
                Note note = new Note(newNote, new Date());
                noteManagement.addNote(note);
            }
            else if (comm.equalsIgnoreCase("#statistics")) {
                System.out.println("Актуальная статистика:");
                NoteStatistic.printStatistic(noteManagement.getNotes());
            }
            else if (comm.equalsIgnoreCase("#search")) {
                System.out.println("Введите дату:");
                String date = scanner.nextLine();
                List<Note> notes = SearchForData.search(noteManagement.getNotes(), date);
                if (notes.isEmpty()) {
                    System.out.println("Заметок на эту дату не найдено или неправильный формат даты!");
                } else {
                    for (Note note : notes) {
                        System.out.println(note);
                    }
                }
            }
            else if (comm.equalsIgnoreCase("#exit")) {
                System.out.println("Завершение программы...");
                scanner.close();
                System.exit(0);
            }
            else{
                System.out.println("Команда не известна, введите #read, #write, #statistics, #search или #exit!");
            }
        }
    }
}
