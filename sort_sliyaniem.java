//Реализовать алгоритм сортировки слиянием

//Cуть алгоритма:Cравнение наименьших элементов каждого подмассива. 
//Первые элементы каждого подмассива сравниваются первыми. 
//Наименьший элемент перемещается в результирующий массив. 
//Счётчики результирующего массива и подмассива, откуда был взят элемент, увеличиваются на один.

package DZ3;

import java.util.Arrays;

public class sort_sliyaniem {
    public static void main(String args[]) {
        int[] sortArray = {3, 6, 25, 12, 4, 10, 76, 1};
        int[] result = mergeSort(sortArray);
        System.out.println(Arrays.toString(result));
    }
    public static int[] mergeSort(int[] sortArr) {
        int[] subArray1 = Arrays.copyOf(sortArr, sortArr.length); //В метод Arrays.copyOf() мы передаем наш оригинальный массив (из которого надо скопировать значения) и длину нового массива, в который мы копируем данные. 
        int[] subArray2 = new int[sortArr.length];
        int[] result = mergeSortInner(subArray1, subArray2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] subArray1, int[] subArray2, int startIndex, int endIndex) { 
        if (startIndex >= endIndex - 1) {
            return subArray1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(subArray1, subArray2, startIndex, middle);
        int[] sorted2 = mergeSortInner(subArray1, subArray2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == subArray1 ? subArray2 : subArray1; // условие, за которым следует знак вопроса (?), затем выражение, которое выполняется, если условие истинно, сопровождается двоеточием (:), и, наконец, выражение, которое выполняется, если условие ложно.
        while (index1 < middle && index2 < endIndex) { // && возвращает true, если слева и справа от него стоят значения true, а иначе — false. 
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++]; 
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}

