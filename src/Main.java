import java.time.Year;
import java.time.LocalDateTime;
import java.util.Locale;


public class Main{
    public static void main(String[] args){
        Book book = new Book();
        book.setTitle("Frankenstein; Or, The Modern Prometheus");
        book.setAuthor("Shelley, Mary Wollstonecraft");
        book.setBirthYear(Year.of(1797));
        book.setDeathYear(Year.of(1851));
        book.setCopyRight(false);
        book.setBookLanguage(Locale.ENGLISH);
        book.setBookSummary("Frankenstein; Or, The Modern Prometheus by Mary Wollstonecraft Shelley is a gothic novel published in 1818.");

        System.out.println("Testing Getters:");
        System.out.println("ID: " + book.getID());
        System.out.println("Title: " + book.getBookTitle());
        System.out.println("Author: " + book.getbookAuthor());
        System.out.println("Birth Year: " + book.getBirthYear());
        System.out.println("Death Year: " + book.getDeathYear());
        System.out.println("Copyright: " + (book.isCopyRight() ? "Active" : "Expired"));
        System.out.println("Language (Locale): " + book.getBookLanguage());
        System.out.println("Language (String): " + book.languageAsString());
        System.out.println("Age:" + book.authorAge());

    }
}