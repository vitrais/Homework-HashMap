import java.util.ArrayList;
import java.util.List;

// Реализация собственного ArrayList
public class MyArrayList<T> {
    private List<T> list;  // Внутренняя коллекция для хранения элементов

    // Конструктор по умолчанию
    public MyArrayList() {
        list = new ArrayList<>();  // Инициализация списка
    }

    // Добавление элемента в конец списка
    public void add(T element) {
        list.add(element);  // Добавляем элемент
    }

    // Получение элемента по индексу
    public T get(int index) {
        return list.get(index);  // Возвращаем элемент по индексу
    }

    // Удаление элемента по индексу
    public void remove(int index) {
        list.remove(index);  // Удаляем элемент
    }

    // Добавление всех элементов из коллекции
    public void addAll(List<T> elements) {
        list.addAll(elements);  // Добавляем все элементы
    }
}