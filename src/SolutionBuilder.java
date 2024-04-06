import oneTask.CreditCard;

import java.util.Random;

public class SolutionBuilder {

//Задача 1:
//        Создать класс CreditCard c полями номер счета, текущая сумма на счету. Добавьте
//        метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
//        который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
//        выводит текущую информацию о карточке. Напишите программу, которая создает три
//        объекта класса CreditCard у которых заданы номер счета и начальная сумма.
//        Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с
//        третьей. Выведите на экран текущее состояние всех трех карточек

    public static void task1() {
        Random random = new Random();

        CreditCard[] cards = new CreditCard[3];
        cards[0] = new CreditCard(random.nextInt(50_000));
        cards[1] = new CreditCard(random.nextInt(50_000));
        cards[2] = new CreditCard(random.nextInt(50_000));

        System.out.println("Первоночальное состояние:");
        cardDisplay(cards);

        System.out.println("\n");
        depositHandler(cards[0], random.nextInt(20_000));
        depositHandler(cards[1], random.nextInt(20_000));
        withdrawHandler(cards[2], random.nextInt(20_000));
        System.out.println("\n");

        System.out.println("Новое состояние:");
        cardDisplay(cards);


    }

    public static void cardDisplay(CreditCard[] cards) {
        System.out.println("***********************************************");
        System.out.println();
        int counter = 1;
        for (CreditCard card : cards) {
            if (card != null) {
                System.out.println("Карта " + counter + ":");
                card.displayInfo();
                System.out.println();
                counter++;
            }
        }
        System.out.println("***********************************************");
    }

    public static void withdrawHandler(CreditCard card, long amount) {
        if (card.withdraw(amount)) {
            System.out.println("Со счёта: " + card.getAccountCode() + " снято: " + amount + " у.е.");
            System.out.println("Текущий баланс:" + card.getAccountBalance() + "\n");
        } else {
            System.out.println("Со счёта: " + card.getAccountCode() + " не удалось снять: " + amount + " у.е.");
            System.out.println("Проверте баланс!!!" + "\n");

        }
    }

    public static void depositHandler(CreditCard card, long amount) {
        if (card.deposit(amount)) {
            System.out.println("На счёт: " + card.getAccountCode() + " зачислено: " + amount + " у.е.");
            System.out.println("Текущий баланс:" + card.getAccountBalance() + "\n");
        } else {
            System.out.println("На счёт: " + card.getAccountCode() + " не удалось зачислить средтва!!!" + "\n");
        }
    }

//Задача *:
//        Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
//        задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
//        метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
//        принимает сумму денег, а возвращает булевое значение - успешность выполнения
//        операции. При снятии денег, функция должна распечатывать каким количеством купюр
//        какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
//        количеством купюр каждого номинала.

    public static void taskStar() {
        //amount
    }

}




