public abstract class Characters {

    private final String name;
    private int health;
    private int force;
    private int gold;
    private int experience;
    private int dexterity;
    private int critical;

    public Characters(String name, int health, int force, int gold, int experience, int dexterity, int critical) {
        this.name = name;
        this.health = health;
        this.force = force;
        this.gold = gold;
        this.experience = experience;
        this.dexterity = dexterity;
        this.critical = critical;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

}
