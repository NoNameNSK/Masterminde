import java.util.Scanner;

public class Main {
    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        SecretNumber secretNumber = null;
        System.out.println("Добро пожаловать в игру \"Быки и коровы\"\n" +
                "Правила: я загадываю число, ты угадываешь его вводя свою догадку\n" +
                "В ответ я назову количество \"Быков\" - цифр, стоящих на своем месте\n" +
                "и количество \"Коров\" - цифр, не на своем месте.\n" +
                "Для старта введи команду start\n" +
                "Для попытки отгадать просто введи число\n" +
                "Для выхода введи команду exit\n");
        while (!exit) {
            String command = scanner.nextLine();
            switch (command) {
                case "start":
                    secretNumber = new SecretNumber();
                    System.out.println("Загадал новое слово!\n");
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    if (secretNumber == null) {
                        System.out.println("Число еще не загадано!\n");
                    } else {
                        try {
                            int[] asnwer = secretNumber.checkAnswer(Integer.parseInt(command));
                            if (asnwer[1] == 4)
                                System.out.println("Угадал!\n");
                            else
                                System.out.printf("Не угадал! Коровы %d, быки %d\n", asnwer[0], asnwer[1]);
                            if(DEBUG)
                                System.out.printf("Отладка, %d\n", secretNumber.getAnswer());
                        } catch (Exception e) {
                            System.out.println("Введено не число!\n");
                        }
                    }
                    break;
            }
        }
    }
}
