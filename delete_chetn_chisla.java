//Пусть дан произвольный список целых чисел, удалить из него четные числа

package DZ3;
import java.util.ArrayList;
import java.util.Random;


public class delete_chetn_chisla {
    public static void main(String[] args) {
        int size = 7; // 7 элементов в списке
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = size; i > 0; i--) {
            arr.add(new Random().nextInt(100));
        }
        System.out.printf("Исходный список %s\n", arr); //Список заполнен рандомом
        
        int i = 0;
        while (i < arr.size()) {
            if (arr.get(i) % 2 == 0) {  // Проверка на чётность; метод get возвращает объект из списка по индексу index
                arr.remove(i); // удаление чётного элемента
            }
            else {
                i++;
            }
        }
        System.out.printf("Список с удаленными четными числами %s", arr);
    }
}
