import java.util.ArrayList;
import java.util.List;
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
        boolean whoIsFirst = new Random().nextBoolean();
        prepareFigth(whoIsFirst);
        while (true) {

            if (whoIsFirst) {
                attack(player, monster);
            } else {
                attack(monster, player);
            }
            whoIsFirst = !whoIsFirst;

            if(checkEndFigth()) {
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

    private void attack(Characters one, Characters two) {

        if(isMiss(one)) {
            System.out.printf("%s промахнулся!\n", one.getName());
            return;
        }

        int force = getForce(one);
        System.out.printf("%s(%d) нанес удар %s(%d) на %d\n", one.getName(), one.getHealth(), two.getName(), two.getHealth(), force);
        two.setHealth(two.getHealth() - force);
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

    private void prepareFigth(boolean whoIsFirst) {
        System.out.println("Ты отправился в лес... нужно быть осторожным!");
        if (whoIsFirst) {
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
