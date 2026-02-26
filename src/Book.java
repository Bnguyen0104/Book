import java.time.Year;
import java.util.Locale;

public class Book {
    private static int bookID;
    private String bookTitle;
    private String bookAuthor;

    private String bookSummary;

    private Year birthYear;
    private Year deathYear;
    private boolean copyRight;
    private Locale bookLanguage;

    /**
     * Constructors
     * Create a default value when code is ran
     * Empty values for text fields
     * Increment by 1 for book values
     * null for years
     * true for copyright
     * English as language unless told otherwise
     */
    public Book() {
        bookID++;
        this.bookTitle = "";
        this.bookAuthor = "";
        this.copyRight = true;
        this.bookSummary = "";
        this.birthYear = null;
        this.deathYear = null;
        this.bookLanguage = Locale.ENGLISH;
    }

    /**
     * Parameter Constructor
     *
     * @param inputBookTitle  Title of book
     * @param inputBookAuthor Author of book
     */
    public Book(String inputBookTitle, String inputBookAuthor) {
        this.bookTitle = inputBookTitle;
        this.bookAuthor = inputBookAuthor;
    }

    public Book(Book other) {
        this.bookID = other.bookID;
        this.bookTitle = other.bookTitle;
        this.bookAuthor = other.bookAuthor;
        this.copyRight = other.copyRight;
        this.bookSummary = other.bookSummary;
        this.birthYear = other.birthYear;
        this.deathYear = other.deathYear;
        this.bookLanguage = other.bookLanguage;
    }

    //Setters

    /**
     * @param bookID Book's ID number
     */
    public void setBookID(int bookID) {
        Book.bookID = bookID;
    }

    /**
     * @param inputBookTitle Book's Title
     */
    public void setTitle(String inputBookTitle) {
        this.bookTitle = inputBookTitle;
    }

    /**
     * @param inputBookAuthor Book's Author
     */
    public void setAuthor(String inputBookAuthor) {
        this.bookAuthor = inputBookAuthor;
    }

    /**
     * @param inputBookSummary Book's Summary
     */
    public void setBookSummary(String inputBookSummary) {
        this.bookSummary = inputBookSummary;
    }

    /**
     * @param inputBirthYear Stores BirthYear value as a Year object
     */
    public void setBirthYear(Year inputBirthYear) {
        this.birthYear = inputBirthYear;
    }

    /**
     * @param inputBirthYear Stores BirthYear value as a String object
     */
    public void setBirthYear(String inputBirthYear) {
        if (inputBirthYear != null && !inputBirthYear.isEmpty()) {
            this.birthYear = Year.parse(inputBirthYear);
        }
    }

    /**
     * @param inputBirthYear Stores BirthYear by extracting it from LocalDateTime
     */
    public void setBirthYear(java.time.LocalDateTime inputBirthYear) {
        if (inputBirthYear != null) {
            this.birthYear = Year.from(inputBirthYear);
        }
    }

    /**
     * @param inputDeathYear Stores BirthYear value as a Year object
     */
    public void setDeathYear(Year inputDeathYear) {
        this.deathYear = inputDeathYear;
    }

    /**
     * @param inputDeathYear Stores BirthYear value as a String object
     */
    public void setDeathYear(String inputDeathYear) {
        if (inputDeathYear != null && !inputDeathYear.isEmpty()) {
            this.deathYear = Year.parse(inputDeathYear);
        }
    }

    /**
     * @param inputDeathYear Stores BirthYear by extracting it from LocalDateTime
     */
    public void setDeathYear(java.time.LocalDateTime inputDeathYear) {
        if (inputDeathYear != null) {
            this.deathYear = Year.from(inputDeathYear);
        }
    }

    /**
     * @param inputCopyRight true if copyrighted, false if expired
     */
    public void setCopyRight(boolean inputCopyRight) {
        this.copyRight = inputCopyRight;
    }

    /**
     * @param inputBookLanguage Stores BookLanguage as Locale
     */
    public void setBookLanguage(Locale inputBookLanguage) {
        this.bookLanguage = inputBookLanguage;
    }

    /**
     * @param inputBookLanguage Stores language as shorthanded tag ex: English(en)
     */
    public void setBookLanguage(String inputBookLanguage) {
        if (inputBookLanguage != null && !inputBookLanguage.isEmpty()) {
            this.bookLanguage = Locale.forLanguageTag(inputBookLanguage);
        }
    }

    //Getters

    /**
     * @return Book's ID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * @return Book's Title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @return Book's Author
     */
    public String getbookAuthor() {
        return bookAuthor;
    }

    /**
     * @return Book's Summary
     */
    public String getBookSummary() {
        return bookSummary;
    }

    /**
     * @return Author's Birth Year
     */
    public Year getBirthYear() {
        return birthYear;
    }

    /**
     * @return Author's Death Year
     */
    public Year getDeathYear() {
        return deathYear;
    }

    /**
     * @return Book's Copyright Permit
     */
    public boolean isCopyRight() {
        return copyRight;
    }

    /**
     * @return Book's Language as Locale
     */
    public Locale getBookLanguage() {
        return bookLanguage;
    }

    public boolean equals(Book other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        boolean sameAuthor = (this.bookAuthor == null && other.bookAuthor == null) || (this.bookAuthor != null && this.bookAuthor.equals(other.bookAuthor));
        return sameAuthor;
    }

    /**
     * @return Book's Language in String human readable format
     */
    public String languageAsString() {
        return getBookLanguage().getDisplayLanguage();
    }

    /**
     * Create HTML page to store book's info
     *
     * @return A string containing markup for the Book's HTML page
     */
    public static String bookAsHTML(Book book) {
        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <title>").append(book.bookTitle).append("</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("    <h1>Title: ").append(book.bookTitle).append("</h1>\n");

        // Author line with birth/death years if available
        html.append("    <h2>Author: ").append(book.bookAuthor);
        if (book.birthYear != null && book.deathYear != null) {
            html.append(" [").append(book.birthYear).append(" - ").append(book.deathYear).append("]");
        }
        html.append("</h2>\n");

        // Copyright status
        html.append("    <p><strong>Copyright:</strong> ");
        html.append(book.isCopyRight() ? "Active" : "Expired");
        html.append("</p>\n");

        // Language
        html.append("    <p><strong>Language:</strong> ");
        html.append(book.languageAsString());
        html.append("</p>\n");

        // Summary if available
        if (book.bookSummary != null && !book.bookSummary.isEmpty()) {
            html.append("    <p><strong>Summary:</strong> ");
            html.append(book.bookSummary);
            html.append("</p>\n");
        }

        html.append("</body>\n");
        html.append("</html>");

        return html.toString();
    }

    // Additional method to calculate author's age if there are a value for birthYear && deathYear

    /**
     * @return Author's Age from Year of Death - Year of Birth
     */
    public int authorAgeAtDeath() {

        if (birthYear == null || deathYear == null) {
            return -1;
        }
        return deathYear.getValue() - birthYear.getValue();
    }

    /**
     * Return the formatting to match specific requirements to how the layout should look
     *
     * @return A formatted version with all of books info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Title: ").append(bookTitle).append("\n");

        // Author with birth/death years if available
        sb.append("Author: ").append(bookAuthor);
        if (birthYear != null && deathYear != null) {
            sb.append(" [").append(birthYear).append(" - ").append(deathYear).append("]");
        }
        sb.append("\n");

        // Copyright status
        sb.append("Copyright: ");
        sb.append(isCopyRight() ? "Active" : "Expired");
        sb.append("\n");

        // Language
        sb.append("Language: ").append(languageAsString()).append("\n");

        // Summary if available
        if (bookSummary != null && !bookSummary.isEmpty()) {
            sb.append("Summary: ").append(bookSummary);
        }

        return sb.toString();
    }

}

