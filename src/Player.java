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

    public void setLevel(int level) {
        this.level = level;
    }
}
