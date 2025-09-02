import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close(); // Закрываем сканер

        // Получаем результат
        String result = canFormPalindrome(s);
        System.out.println(result);
    }

    public static String canFormPalindrome(String s) {
        // Подсчитываем частоту каждого символа
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Проверяем количество символов с нечетной частотой
        int oddCount = 0;
        char middleChar = '\0';

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) {
                oddCount++;
                middleChar = entry.getKey();

                // Если нашли больше одного нечетного, можно сразу вернуть -1
                if (oddCount > 1) {
                    return "-1";
                }
            }
        }

        // Формируем половину палиндрома
        StringBuilder half = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            // Добавляем половину символов
            for (int i = 0; i < count / 2; i++) {
                half.append(c);
            }
        }

        // Формируем полный палиндром
        String firstHalf = half.toString();
        String secondHalf = half.reverse().toString();

        // Если есть символ с нечетной частотой, добавляем его в середину
        if (oddCount == 1) {
            return firstHalf + middleChar + secondHalf;
        } else {
            return firstHalf + secondHalf;
        }
    }
}