package evgeniy.ryzhikov;

public class Medicament {

    private final int price;
    private final int health;
    private final String name;

    public Medicament(String name, int health, int price) {
        this.name = name;
        this.health = health;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getHealth() {
        return health;
    }

}
