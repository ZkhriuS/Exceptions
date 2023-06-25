import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println(inputFloat());
    }
    public static float inputFloat(){
        float result;
        BufferedReader input = null;
        while(true) {
                System.out.print("Введите вещественное число> ");
            try {
                input = new BufferedReader(new InputStreamReader(System.in));
                String data = input.readLine();
                if (data.isEmpty())
                    throw new Exception("empty input string");
                result = Float.parseFloat(data);
                return result;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Неверный формат вещественного числа");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Пустые строки вводить нельзя");

            }
        }
    }

    /*
                Задание 2

        ...
            int d = 0;
            int index = 8;
            if(index<intArray.length && d!=0){
                double catchedRes1 = intArray[8] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            }
        ...

                Задание 3

        ...
        public static void main(String[] args){
            try {
                int a = 90;
                int b = 3;
                if(b==0)
                    System.out.println("На 0 делить нельзя");
                else
                    System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так...");
            }
        }
        public static void printSum(Integer a, Integer b) throws NullPointerException{
            if(a==null)
                throw new NullPointerException("Число а не задано");
            else if(b==null)
                throw new NullPointerException("Число b не задано");
            else
                System.out.println(a + b);
        }
        ...
    */
}
