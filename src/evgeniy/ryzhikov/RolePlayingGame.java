package evgeniy.ryzhikov;

import java.util.Scanner;

public class RolePlayingGame {

    private Player player;
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new RolePlayingGame().start();
    }

    private void start() {
        System.out.println("Привет, друг! \n" +
                "Отлично, что заглянул - нам срочно нужна помощь! \n" +
                "Повсюду полно нечести - помоги ее сразить! \n" +
                "Но для начала скажи, как тебя зовут?");

        String name = scanner.next();
        while (!checkName(name)) {
            System.out.printf("Имя может включать только буквы и цифры, а так же должно быть не более %d символов", S.LENGTH_NAME);
            name = scanner.next();
        }
        System.out.println("Привет " + name);
        player = new Player(name);
        mainLoop();
    }

    private void mainLoop() {
        while (true) {
            System.out.println(S.MSG_MAIN_MENU);
            switch (getNumber(1234)) {
                case 1:
                    stat();
                    break;
                case 2:
                    figth();
                    break;
                case 3:
                    trade();
                    break;
                case 4:
                    System.out.println("Удачи, возвращайся скорее!");
                    return;
            }
        }
    }

    private void stat() {
        System.out.printf(S.MSG_STAT,
                player.getLevel(),
                player.getExperience(),
                player.getHealth(),
                player.getGold(),
                player.getForce(),
                player.getDexterity(),
                player.getCritical());
        System.out.println("1 - выйти в главное меню");
        while (getNumber(1) != 1);

    }

    private void figth() {
        Thread figth = new Figth(player);
        figth.start();
        try {
            figth.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(player.needLevelUp()) player.levelUp();
    }

    private void trade() {
        System.out.printf(S.MSG_TRADE_MAIN, player.getName());
        while (true) {
            int number = getNumber(12345);
            if (number == 5) return;
            Medicament medicament = S.MEDICAMENTS.get(number - 1);
            if (buy(medicament))
                return;
        }
    }

    private boolean buy(Medicament medicament) {
        if (checkGold(medicament.getPrice())) {
            player.setGold(player.getGold() - medicament.getPrice());
            player.setHealth(player.getHealth() + medicament.getHealth());
            System.out.printf("Ты купил %s , теперь у тебя %d здоровья\n", medicament.getName(), player.getHealth());
            return true;
        } else {
            System.out.println("Похоже у тебя не хватает денег на этот товар... Выбери другой или зайди позже");
        }
        return false;
    }

    private boolean checkGold(int price) {
        return price <= player.getGold();
    }

    private int getNumber(int numbersRequest) {
        String pattern = "[" + numbersRequest + "]";
        String number;
        do {
            number = scanner.next();
        }
        while (!checkNumber(number, pattern));
        return Integer.parseInt(number);
    }

    private boolean checkName(String name) {
        if (name.length() > S.LENGTH_NAME) return false;
        return name.matches("[A-Za-zА-Яа-я\\d\\s]+");
    }

    private boolean checkNumber(String number, String pattern) {
        return number.matches(pattern);
    }
}
