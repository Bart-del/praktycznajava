import java.util.HashMap;
import java.util.Map;

public class DataBaseImpl implements DataBase {
    private final Map<Class<?>, Object> records = new HashMap<>();

    @Override
    public <T> void put(Class<T> type, T instance) {
        records.put(type, instance);
    }

    @Override
    public <T> T get(Class<T> type) {
        return type.cast(records.get(type));
    }
}

