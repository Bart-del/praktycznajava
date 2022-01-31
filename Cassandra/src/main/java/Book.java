import java.util.UUID;

public class Book {
    private final String title;
    private final UUID id;

    public Book(String title, UUID id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }
}
