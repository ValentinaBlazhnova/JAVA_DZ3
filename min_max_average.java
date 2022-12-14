// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package DZ3;
import java.util.ArrayList;
import java.util.Random;

// import static java.util.Collections.max;     Для нахождения min/max через встроенные методы
// import static java.util.Collections.min;


public class min_max_average {
    public static void main(String[] args) {
        int size = 7; // 7 элементов в списке
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = size; i > 0; i--) {
            list.add(new Random().nextInt(100));
        }
        System.out.printf("Исходный список %s\n", list); //Список заполнен рандомом

        int maxElem = list.get(0); //метод get возвращает объект из списка по индексу
        int minElem = list.get(0);
        int sumElem = 0;
        for (int item : list) {
            if (item > maxElem) {
                maxElem = item;
            }
            if (item < minElem) {
                minElem = item;
            }
            sumElem += item;
        }
        float average = (float)sumElem/list.size(); // число с плавающей точкой, весит меньше чем double
        // Другой способ нахождения min/max, через встроенные методы:
        // int max = max(list);
        // int min = min(list);
        System.out.printf("Максимальный элемент %s\n", maxElem);
        System.out.printf("Минимальный элемент %s\n", minElem);
        System.out.printf("Среднее арифметическое %s\n", average);
    }
}

