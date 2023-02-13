package evgeniy.ryzhikov;

import java.util.Random;

public class Figth extends Thread {

    private final Player player;
    private final Characters monster;

    public Figth (Player player) {
        this.player = player;
        monster = getMonster();
    }

    @Override
    public void run() {
        boolean isPlayerFirst = new Random().nextBoolean();
        prepareFigth(isPlayerFirst);
        while (true) {

            if (isPlayerFirst) {
                attack(player, monster);
            } else {
                attack(monster, player);
            }
            isPlayerFirst = !isPlayerFirst;

            if (checkEndFigth()) {
                if (player.getHealth() <= 0) {
                    System.out.printf("К сожаление %s погиб в бою! \nИгра окончена!\n", player.getName());
                    System.exit(0);
                } else {
                    player.setGold(player.getGold() + monster.getGold());
                    player.setExperience(player.getExperience() + monster.getExperience());
                    System.out.printf("%s сразил в бою %s! Опыт: +%d Золото: +%d\n", player.getName(), monster.getName(), monster.getExperience(), monster.getGold());
                }
                break;
            }

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) { e.printStackTrace();}
        }
    }

    private boolean checkEndFigth() {
        return player.getHealth() <= 0 || monster.getHealth() <= 0;
    }

    private void attack(Characters first, Characters second) {

        if (isMiss(first)) {
            System.out.printf("%s промахнулся!\n", first.getName());
            return;
        }

        int force = getForce(first);
        System.out.printf("%s(%d) нанес удар %s(%d) на %d\n", first.getName(), first.getHealth(), second.getName(), second.getHealth(), force);
        second.setHealth(second.getHealth() - force);
    }

    private boolean isMiss(Characters character) {
        int rand = new Random().nextInt(101);
        return rand >= character.getDexterity();
    }

    private int getForce(Characters character) {
        int rand = new Random().nextInt(101);

        if (rand <= character.getCritical()) {
            System.out.print("[КРИТИЧЕКИЙ УДАР] ");
            return character.getForce() * 2;
        }
        return character.getForce();
    }

    private void prepareFigth(boolean isPlayerFirst) {
        System.out.println("Ты отправился в лес... нужно быть осторожным!");
        if (isPlayerFirst) {
            System.out.printf("Отправившись в лес %s во время заметил врага и первым нанес удар!\n", player.getName());
        } else {
            System.out.printf("Отправившись в лес %s не много задумался и не заметил как со спины неожиданно напал %s!\n", player.getName(), monster.getName());
        }
    }

    private Characters getMonster() {
        if (new Random().nextBoolean()) {
            return new Skeleton();
        } else {
            return new Goblin();
        }
    }

}
