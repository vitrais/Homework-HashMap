import java.util.ArrayList;
import java.util.List;

// Класс, представляющий студента
public class Student {
    private String name;     // Имя студента
    private List<Book> books;  // Список книг

    // Конструктор студента
    public Student(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Метод добавления книги
    public void addBook(Book book) {
        books.add(book);  // Добавляем книгу в список
    }

    // Геттер для списка книг
    public List<Book> getBooks() {
        return books;
    }

    // Метод строкового представления
    @Override
    public String toString() {
        return "Студент: " + name;
    }
}
