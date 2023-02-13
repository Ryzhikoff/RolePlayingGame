package evgeniy.ryzhikov;

public class Player extends Characters {

    private int level;

    public Player (String name) {
        super(name,
                S.PLAYER_HEALTH,
                S.PLAYER_FORCE,
                S.PLAYER_GOLD,
                S.PLAYER_EXPERIENCE,
                S.PLAYER_DEXTERITY,
                S.PLAYER_CRITICAL);
        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    public boolean needLevelUp() {
        if (isMaxLevel()) return false;
        return getExperience() >= nextLevelExperience();
    }

    private int nextLevelExperience() {
        return S.levels.get(level)[1];
    }

    private boolean isMaxLevel() {
        return level >= S.levels.size();
    }

    public void levelUp() {
        setCritical(increase(getCritical()));
        //для ловкости понижающий коэфицент
        setDexterity(increase((int)(getDexterity()*0.87f)));
        setForce(increase(getForce()));
        level += 1;
        System.out.printf("Новый уровень!  >>> %d <<<\n", level);
        System.out.println("Характеристики улучшены: ");
        System.out.printf("Шанс критического удара: %d%%\n", getCritical());
        System.out.printf("Ловкость : %d%%\n", getDexterity());
        System.out.printf("Сила : %d\n", getForce());
    }

    private int increase(int skill) {
        return (int) (skill + skill / 100f * S.INCREASE_AT_LEVEL_UP);
    }
}
