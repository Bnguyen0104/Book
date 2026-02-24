import java.time.LocalDateTime;
import java.time.Year;
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
        book.setBookSummary("Frankenstein; Or, The Modern Prometheus by Mary Wollstonecraft Shelley is a Gothic novel published in 1818.");

        //Testing Getters
        System.out.println("Testing Getters:");
        System.out.println("ID: " + book.getBookID());
        System.out.println("Title: " + book.getBookTitle());
        System.out.println("Author: " + book.getbookAuthor());
        System.out.println("Birth Year: " + book.getBirthYear());
        System.out.println("Death Year: " + book.getDeathYear());
        System.out.println("Copyright: " + (book.isCopyRight() ? "Active" : "Expired"));
        System.out.println("Language (Locale): " + book.getBookLanguage());
        System.out.println("Language (String): " + book.languageAsString());
        System.out.println("Age:" + book.authorAgeAtDeath());
        System.out.println();

        //Testing toString
        System.out.println("Testing toString");
        System.out.println(book.toString());
        System.out.println();


        //Testing book's ID increment
        Book book1 = new Book();
        book1.setTitle("Alice's Adventure in Wonderland");
        book1.setAuthor("Lewis Carroll");
        LocalDateTime birthDate = LocalDateTime.of(1832, 1, 1, 0, 0);
        book1.setBirthYear(birthDate);
        LocalDateTime deathDate = LocalDateTime.of(1898, 1, 1, 0, 0);
        book1.setDeathYear(deathDate);
        book1.setCopyRight(true);
        book1.setBookLanguage(Locale.ENGLISH);
        book1.setBookSummary("When a curious girl named Alice spots a White Rabbit with a pocket watch, she tumbles down a rabbit hole into an extraordinary fantasy world filled with peculiar anthropomorphic creatures.");

        System.out.println("Testing Getters:");
        System.out.println("ID: " + book1.getBookID());
        System.out.println("Title: " + book1.getBookTitle());
        System.out.println("Author: " + book1.getbookAuthor());
        System.out.println("Birth Year: " + book1.getBirthYear());
        System.out.println("Death Year: " + book1.getDeathYear());
        System.out.println("Copyright: " + (book1.isCopyRight() ? "Active" : "Expired"));
        System.out.println("Language (Locale): " + book1.getBookLanguage());
        System.out.println("Language (String): " + book1.languageAsString());
        System.out.println("Age: " + book1.authorAgeAtDeath());
        System.out.println();

        System.out.println("Testing toString");
        System.out.println(book1);
        System.out.println();

    }
}