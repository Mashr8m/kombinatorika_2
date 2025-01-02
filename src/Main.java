public class Main {

    // Функция для восстановления свойств кучи
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;  // Инициализация наибольшего элемента как корня
        int left = 2 * i + 1;  // Левый дочерний узел
        int right = 2 * i + 2;  // Правый дочерний узел

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый дочерний элемент больше наибольшего
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если наибольший элемент не является корнем
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивный вызов для восстановления кучи
            heapify(arr, n, largest);
        }
    }

    // Основная функция для сортировки массива с использованием кучи
    public static void heapsort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец массива
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Восстанавливаем кучу для уменьшенного массива
            heapify(arr, i, 0);
        }
    }

    // Функция для печати массива
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Пример использования
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Исходный массив:");
        printArray(arr);

        heapsort(arr);

        System.out.println("Отсортированный массив:");
        printArray(arr);
    }
}
