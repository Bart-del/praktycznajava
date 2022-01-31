import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final String TABLE_NAME = "books";
    private final Session session;

    public BookRepository(Session session){
        this.session = session;
    }

    public void createTable() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(TABLE_NAME).append("(")
                .append("id uuid PRIMARY KEY, ")
                .append("title text);");
        String query = sb.toString();
        session.execute(query);
    }

    public void alterTablebooks(String columnName, String columnType) {
        StringBuilder sb = new StringBuilder("ALTER TABLE ")
                .append(TABLE_NAME).append(" ADD ")
                .append(columnName).append(" ")
                .append(columnType).append(";");

        String query = sb.toString();
        session.execute(query);
    }

    public void insertbookByTitle(Book book) {
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append("library").append("(id, title) ")
                .append("VALUES (").append(book.getId())
                .append(", '").append(book.getTitle()).append("');");

        String query = sb.toString();
        session.execute(query);
    }

    public void createTableBooksByTitle() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("booksByTitle").append("(")
                .append("id uuid, ")
                .append("title text,")
                .append("PRIMARY KEY (title, id));");

        String query = sb.toString();
        session.execute(query);
    }

    public List<Book> selectAll() {
        StringBuilder sb =
                new StringBuilder("SELECT * FROM ").append(TABLE_NAME);

        String query = sb.toString();
        ResultSet rs = session.execute(query);

        List<Book> books = new ArrayList<Book>();

        rs.forEach(r -> {
            books.add(new Book(
                    r.getString("title"),
                    r.getUUID("id")));
        });
        return books;
    }

    public Book selectByTitle(String title) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("booksByTitle").append("(")
                .append("id uuid, ")
                .append("title text,")
                .append("PRIMARY KEY (title, id));");
        String query = sb.toString();
        ResultSet rs = session.execute(query);

        List<Book> books = new ArrayList<Book>();

        rs.forEach(r -> {
            books.add(new Book(
                    r.getString("title"),
                    r.getUUID("id")));
        });
        return books.get(0);
    }
}
