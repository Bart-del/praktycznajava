public interface DataBase {
    <T> void put(Class<T> type, T instance);
    <T> T get(Class<T> type);
}
