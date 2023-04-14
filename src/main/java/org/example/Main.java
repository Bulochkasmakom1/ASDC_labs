package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static List<Worker> workerList;

    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("src\\main\\resources\\employees.csv");

        workerList = CheckingWorker.toCheck(filePath);

        workerList.forEach(System.out::println);

        Worker[] workers = workerList.toArray(new Worker[0]);

        long nanos = System.nanoTime();
        System.out.print("Linear search: ");
        System.out.print("\tIndex of element: " + linearSearch(workers, 33));
        System.out.print("\tTime: " + (System.nanoTime() - nanos) + " nanos\t");
        System.out.println();

        nanos = System.nanoTime();
        System.out.print("Binary search (loop): ");
        System.out.print("\tIndex of element: " + binarySearch(workers, 33));
        System.out.print("\tTime: " + (System.nanoTime() - nanos) + " nanos\t");
        System.out.println();

        nanos = System.nanoTime();
        System.out.print("Recursive binary search: ");
        System.out.print("\tIndex of element: " + recursiveBinarySearch(workers, 0, workers.length, 33));
        System.out.print("\tTime: " + (System.nanoTime() - nanos) + " nanos\t");
        System.out.println();

        nanos = System.nanoTime();
        System.out.print("Interpolation search: ");
        System.out.print("\tIndex of element: " + interpolationSearch(workers, 33));
        System.out.print("\tTime: " + (System.nanoTime() - nanos) + " nanos\t");
        System.out.println();

        nanos = System.nanoTime();
        System.out.print("Fibonacci search: ");
        System.out.print("\tIndex of element: " + fibbonacciSearch(workers, 33));
        System.out.print("\tTime: " + (System.nanoTime() - nanos) + " nanos");
        System.out.println();


        Tree tree = new Tree(workers);

        nanos = System.nanoTime();
        System.out.print("Tree search: ");
        Worker worker = tree.findWorkerById(33);
        System.out.print("\tTime: " + (System.nanoTime() - nanos) + " nanos\t");
        System.out.println(worker);

    }

    // Returns index of found element
    public static int linearSearch(Worker[] array, long idnp) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getIdnp() == idnp) {
                return i;
            }
        }
        return -1;
    }

    // The array must be sorted after id
    public static int binarySearch(Worker[] array, long idnp) {

        int firstIndex = 0;
        int lastIndex = array.length - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (array[middleIndex].getIdnp() == idnp) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (array[middleIndex].getIdnp() < idnp) {
                firstIndex = middleIndex + 1;
            }

            // если средний элемент больше
            // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (array[middleIndex].getIdnp() > idnp) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    // The array must be sorted after id
    public static int recursiveBinarySearch(Worker[] array, int firstElement, int lastElement, long idnp) {

        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (array[mid].getIdnp() == idnp) {
                return mid;
            }

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (array[mid].getIdnp() > idnp) {
                return recursiveBinarySearch(array, firstElement, mid - 1, idnp);
            }

            // также, вызываем метод рекурсивно по суженным данным
            return recursiveBinarySearch(array, mid + 1, lastElement, idnp);
        }

        return -1;
    }

    // Array must be sorted after id
    public static int interpolationSearch(Worker[] array, long idnp) {

        int startIndex = 0;
        int lastIndex = (array.length - 1);

        while ((startIndex <= lastIndex) && (idnp >= array[startIndex].getIdnp()) &&
                (idnp <= array[lastIndex].getIdnp())) {
            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = (int) (startIndex + (((lastIndex - startIndex) /
                    (array[lastIndex].getIdnp() - array[startIndex].getIdnp())) *
                    (idnp - array[startIndex].getIdnp())));

            if (array[pos].getIdnp() == idnp) {
                return pos;
            }

            if (array[pos].getIdnp() < idnp) {
                startIndex = pos + 1;
            } else {
                lastIndex = pos - 1;
            }
        }
        return -1;
    }

    public static int fibbonacciSearch(Worker[] array, long idnp) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        double fibIndex = 1.618;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (int) ((firstIndex + lastIndex) / fibIndex);
            if (middleIndex >= lastIndex) {
                fibIndex = 2;
            }

            if (array[middleIndex].getIdnp() == idnp) {
                return middleIndex;
            } else if (array[middleIndex].getIdnp() < idnp) {
                firstIndex = middleIndex;
            } else if (array[middleIndex].getIdnp() > idnp) {
                lastIndex = middleIndex;
            }
        }
        return -1;
    }
}