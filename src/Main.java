import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int sizeList = scanner.nextInt();
        if (sizeList <= 0) {
            logger.log("Введено некорректное число");
        }
        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue = scanner.nextInt();
        if (maxValue <= 0) {
            logger.log("Введено некорректное число");
        }

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(sizeList);
        Random random = new Random();
        for (int i = 0; i < sizeList; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список: " + list.toString().replaceAll("^\\[|]$", "").replace(",", ""));

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int treshold = scanner.nextInt();
        if (treshold <= 0 || treshold > maxValue) {
            logger.log("Введено некорректное число");
        }
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result.toString().replaceAll("^\\[|]$", "").replace(",", ""));
        logger.log("Завершаем программу");
    }
}