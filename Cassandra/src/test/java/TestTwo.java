import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTwo {
    private BookRepository bookRepository;
    private Session session;
    private final String KEYSPACE_NAME = "library";

    @Before
    public void connect() {
        CassandraConnector client = new CassandraConnector();
        client.connect("127.0.0.1", 9142);
        this.session = client.getSession();
        bookRepository = new BookRepository(session);
    }

    @Test
    public void whenCreatingATable_thenCreatedCorrectly() {
        bookRepository.createTable();

        ResultSet result = session.execute(
                "SELECT * FROM " + KEYSPACE_NAME + ".books;");

        List<String> columnNames =
                result.getColumnDefinitions().asList().stream()
                        .map(ColumnDefinitions.Definition::getName)
                        .collect(Collectors.toList());

        assertEquals(columnNames.size(), 2);
        assertTrue(columnNames.contains("id"));
        assertTrue(columnNames.contains("title"));
    }

    @Test
    public void whenAlteringTable_thenAddedColumnExists() {
        bookRepository.createTable();

        bookRepository.alterTablebooks("publisher", "text");

        ResultSet result = session.execute(
                "SELECT * FROM " + KEYSPACE_NAME + "." + "books" + ";");

        boolean columnExists = result.getColumnDefinitions().asList().stream()
                .anyMatch(cl -> cl.getName().equals("publisher"));

        assertTrue(columnExists);
    }

    @Test
    public void whenAddingANewBook_thenBookExists() {
        bookRepository.createTableBooksByTitle();

        String title = "Effective Java";
        Book book = new Book(title, UUIDs.timeBased());
        bookRepository.insertbookByTitle(book);

        Book savedBook = bookRepository.selectByTitle(title);
        assertEquals(book.getTitle(), savedBook.getTitle());
    }
}

