import java.math.BigInteger;//библиотека для больших чисел
import java.util.Scanner;

public class FactorialCalculator {
    public BigInteger calculateFactorial(int n){// Метод для подсчета факториала
        BigInteger factorial = BigInteger.ONE; //берем константу 1
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));//итерация умножения для получения факториала
        }
        return factorial;
    }

    public int countTrailingZeros (BigInteger number){// Метод для подсчета нулей в конце числа
        int count = 0;//инициализация счетчика
        while (number.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {//пока остаток от деления факториала на 10 равен 0
            count++;//счетчик
            number = number.divide(BigInteger.TEN);//делим факториал на 10, переприсваиваем
        }
        return count;
    }

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        // Получаем число для вычисления факториала
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        BigInteger factorial = calculator.calculateFactorial(number);
        int zeros = calculator.countTrailingZeros(factorial); // передаем факториал

        System.out.println(zeros);
    }
}