package evgeniy.ryzhikov;

import java.util.*;

public class S {

    //допустимая длина имени
    public static final int LENGTH_NAME = 20;

    //Игрок
    public static final int PLAYER_HEALTH = 100;
    public static final int PLAYER_FORCE = 10;
    public static final int PLAYER_GOLD = 0;
    public static final int PLAYER_EXPERIENCE = 0;
    public static final int PLAYER_DEXTERITY = 80;
    public static final int PLAYER_CRITICAL = 10;

    //Монстры
    //Скелет
    public static final int SKELETON_HEALTH = 30;
    public static final int SKELETON_FORCE = 5;
    public static final int SKELETON_GOLD = 12;
    public static final int SKELETON_EXPERIENCE = 7;
    public static final int SKELETON_DEXTERITY = 65;
    public static final int SKELETON_CRITICAL = 1;

    //Гоблин
    public static final int GOBLIN_HEALTH = 40;
    public static final int GOBLIN_FORCE = 10;
    public static final int GOBLIN_GOLD = 17;
    public static final int GOBLIN_EXPERIENCE = 10;
    public static final int GOBLIN_DEXTERITY = 60;
    public static final int GOBLIN_CRITICAL = 1;

    //уровни. Опыт - уровень
    public static final List<int[]> levels = Arrays.asList(
            new int[] {1, 0},
            new int[] {2, 10},
            new int[] {3, 20},
            new int[] {4, 50},
            new int[] {5, 100},
            new int[] {6, 200},
            new int[] {7, 400},
            new int[] {8, 1000}
    );

    //увеличение навыков в процентах
    public static final float INCREASE_AT_LEVEL_UP = 20f;

    public static final List<Medicament> MEDICAMENTS = Arrays.asList(
            new Medicament("флакончик лебного элексира",30,30),
            new Medicament("фляга лебного элексира",60,50),
            new Medicament("бутылка лебного элексира",100,75),
            new Medicament("канистра лебного элексира",200,120));

    //Текст
    public static final String MSG_MAIN_MENU = "Главное меню:\n" +
            "1 - Статистика игрока\n" +
            "2 - Пойти в лес на битву\n" +
            "3 - Зайти к торговцу\n" +
            "4 - Выход из игры";

    public static final String MSG_STAT = "Твои показатели: \n" +
            "Уровень: %d\n" +
            "Опыт: %d\n" +
            "Здоровье: %d\n" +
            "Золото: %d\n" +
            "Военные характеристики: Сила: %d Ловкость %d%% Шанс критического удара: %d%%\n";

    public static final String MSG_TRADE_MAIN = "%s, приветствую тебя в моей лавке. Сегодня в продаже: \n" +
            "1 - флакончик лебного элексира (+30 здоровья) за 30 золота\n" +
            "2 - фляга лечебного элексира (+60 здоровья) за 50 золота\n" +
            "3 - бутылка лечебного элексира (+100 здоровья) за 75 золота\n" +
            "4 - канистра лебеного элексира (+200 здоровья) за 120 золота\n" +
            "5 - вернуться в главное меню\n";
}
