import java.util.HashMap;
import java.util.Map;

// Реализация собственного HashSet на основе HashMap
public class MyHashSet<T> {
    private Map<T, Boolean> map;  // Внутренняя карта для хранения элементов

    // Конструктор по умолчанию
    public MyHashSet() {
        map = new HashMap<>();  // Инициализация карты
    }

    // Метод добавления элемента
    public void add(T element) {
        map.put(element, true);  // Добавляем элемент в карту
    }

    // Метод удаления элемента
    public void remove(T element) {
        map.remove(element);  // Удаляем элемент из карты
    }
}