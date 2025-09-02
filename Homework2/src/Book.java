// Класс, представляющий книгу
public class Book implements Comparable<Book> {
    private String title;  // Название книги
    private int year;      // Год издания
    private int pages;     // Количество страниц

    // Конструктор книги
    public Book(String title, int year, int pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    // Геттер для года издания
    public int getYear() {
        return year;
    }

    // Реализация сравнения по количеству страниц
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pages, other.pages);
    }

    // Метод строкового представления
    @Override
    public String toString() {
        return title + " (" + year + "), страниц: " + pages;
    }
}
