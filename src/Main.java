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
            else if (comm.equalsIgnoreCase("#exit")) {
                System.out.println("Завершение программы...");
                scanner.close();
                System.exit(0);
            }
            else{
                System.out.println("Команда не известна, введите #read, #write или #exit!");
            }
        }
    }
}
