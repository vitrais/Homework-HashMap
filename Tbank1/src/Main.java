import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // сканер вводенных значений
        int n = scanner.nextInt(); // первая строка - ввод размера массива
        int[] arr = new int[n]; //создание массива
        for (int i = 0; i < n; i++) { //цикл заполнения нашего массива
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int operations = 0; //количество итераций
        for (int i = 1; i < n; i++) {//цикл счетчик
            if (arr[i] < arr[i - 1]) {//если 1-й < 0-го
                int diff = arr[i - 1] - arr[i];//берем их разницу
                operations += diff;//запись в счетчик
                arr[i] += diff;//прибавить к 1-му разницу м/у 1-м и 0-м
            }
        }
        System.out.print(operations);
    }
}