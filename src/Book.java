import java.time.Year;
import java.util.Locale;

public class Book {
    private static int bookID = 0;
    private int ID;
    private String bookTitle;
    private String bookAuthor;

    private String bookSummary;

    private Year birthYear, deathYear;
    private boolean copyRight;
    private Locale bookLanguage;

    //Constructors
    public Book(){
        this.ID = bookID++;
        this.bookTitle = "";
        this.bookAuthor = "";
        this.copyRight = true;
        this.bookSummary = "";
        this.birthYear = null;
        this.deathYear = null;
        this.bookLanguage = Locale.ENGLISH;
    }

    public Book(String inputBookTitle, String inputBookAuthor){
        this.bookTitle = inputBookTitle;
        this.bookAuthor = inputBookAuthor;
    }

    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBookID(){
        this.ID = bookID++;
    }

    public void setTitle(String inputBookTitle){
        this.bookTitle = inputBookTitle;
    }

    public void setAuthor(String inputBookAuthor){
        this.bookAuthor = inputBookAuthor;
    }

    public void setBookSummary(String inputBookSummary){
        this.bookSummary = inputBookSummary;
    }

    public void setBirthYear(Year inputBirthYear){
        this.birthYear = inputBirthYear;
    }

    public void setBirthYear(String inputBirthYear){
        if (inputBirthYear != null && !inputBirthYear.isEmpty()){
            this.birthYear = Year.parse(inputBirthYear);
        }
    }

    public void setBirthYear(java.time.LocalDateTime inputBirthYear){
        if (inputBirthYear != null){
            this.birthYear = Year.from(inputBirthYear);
        }
    }

    public void setDeathYear(Year inputDeathYear){
        this.deathYear = inputDeathYear;
    }
    public void setDeathYear(String inputDeathYear){
        if (inputDeathYear != null && !inputDeathYear.isEmpty()){
            this.deathYear = Year.parse(inputDeathYear);
        }
    }

    public void setDeathYear(java.time.LocalDateTime inputDeathYear){
        if (inputDeathYear != null){
            this.deathYear = Year.from(inputDeathYear);
        }
    }

    public void setCopyRight(boolean inputCopyRight){
        this.copyRight = inputCopyRight;
    }

    public void setBookLanguage(Locale inputBookLanguage){
        this.bookLanguage = inputBookLanguage;
    }

    public void setBookLanguage(String inputBookLanguage){
        if (inputBookLanguage != null && !inputBookLanguage.isEmpty()){
            this.bookLanguage = Locale.forLanguageTag(inputBookLanguage);
        }
    }

    //Getters
    public int getID() {
        return ID;
    }

    public int getBookID(){
        return bookID;
    }

    public String getBookTitle(){
        return bookTitle;
    }

    public String getbookAuthor(){
        return bookAuthor;
    }

    public String getBookSummary(){
        return bookSummary;
    }

    public Year getBirthYear(){
        return birthYear;
    }

    public Year getDeathYear(){
        return deathYear;
    }

    public boolean isCopyRight(){
        return copyRight;
    }

    public Locale getBookLanguage(){
        return bookLanguage;
    }

    public String languageAsString(){
        return getBookLanguage().getDisplayLanguage();
    }

    public int authorAge(){

        if (birthYear == null || deathYear == null){
            return -1;
        }
        return birthYear.getValue() - deathYear.getValue();
    }

    public String toString() {
        return "Book{" +
                "id=" + bookID+
                ", title='" + bookTitle + '\'' +
                ", author='" + bookAuthor + ' ' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear + '\'' +
                ", copyright=" + isCopyRight() + '\'' +
                ", language=" + languageAsString() + '\'' +
                ", bookSummary=" + bookSummary +
                '}';
    }
}

