import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String args[]) {
        // Создаем студентов
        Student student1 = new Student("Иван");
        Student student2 = new Student("Мария");
        Student student3 = new Student("Петр");
        Student student4 = new Student("Анна");
        Student student5 = new Student("Сергей");

        // Заполняем книги для первого студента (5 книг)
        student1.addBook(new Book("Война и мир", 1869, 1225));
        student1.addBook(new Book("Гарри Поттер", 2000, 435));
        student1.addBook(new Book("1984", 1949, 328));
        student1.addBook(new Book("Маленький принц", 1943, 96));
        student1.addBook(new Book("Мастер и Маргарита", 1966, 465));

        // Заполняем книги для второго студента (5 книг)
        student2.addBook(new Book("Унесенные ветром", 1936, 1041));
        student2.addBook(new Book("Код да Винчи", 2003, 587));
        student2.addBook(new Book("Алиса в стране чудес", 1865, 278));
        student2.addBook(new Book("Сто лет одиночества", 1967, 418));
        student2.addBook(new Book("Над пропастью во ржи", 1951, 277));

        // Заполняем книги для третьего студента (5 книг)
        student3.addBook(new Book("Властелин колец", 1954, 1178));
        student3.addBook(new Book("Игра престолов", 1996, 704));
        student3.addBook(new Book("Великий Гэтсби", 1925, 218));
        student3.addBook(new Book("451 градус по Фаренгейту", 1953, 208));
        student3.addBook(new Book("Мартин Иден", 1909, 416));

        // Заполняем книги для четвертого студента (5 книг)
        student4.addBook(new Book("Три товарища", 1936, 416));
        student4.addBook(new Book("Цветы для Элджернона", 1966, 288));
        student4.addBook(new Book("Оно", 1986, 1184));
        student4.addBook(new Book("Бойцовский клуб", 1996, 208));
        student4.addBook(new Book("Убить пересмешника", 1960, 336));

        // Заполняем книги для пятого студента (5 книг)
        student5.addBook(new Book("Гарри Поттер и философский камень", 1997, 435));
        student5.addBook(new Book("Хроники Нарнии", 1950, 352));
        student5.addBook(new Book("Маленький принц", 1943, 96));
        student5.addBook(new Book("Божественная комедия", 1321, 672));
        student5.addBook(new Book("Моби Дик", 1851, 635));

        // Создаем список студентов
        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);

        // Выполняем все операции в одном стриме без промежуточных переменных
        Optional<Integer> result = students.stream()
                // Выводим информацию о каждом студенте
                .peek(System.out::println)
                // Получаем все книги всех студентов
                .flatMap(student -> student.getBooks().stream())
                // Сортируем книги по количеству страниц
                .sorted()
                // Оставляем только уникальные книги
                .distinct()
                // Фильтруем книги, выпущенные после 2000 года
                .filter(book -> book.getYear() > 2000)
                // Ограничиваем результат тремя элементами
                .limit(3)
                // Получаем годы выпуска книг
                .map(Book::getYear)
                // Находим первый подходящий год
                .findFirst();

        // Выводим результат
        System.out.println(result.isPresent()
                ? "Найден год: " + result.get()
                : "Книга не найдена");
    }
}
