public class Player extends GameCharacter {
    private String name;

    public Player(String name) {
        super(100, 15);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void attack(GameCharacter monster) {
        System.out.println("Monster received "  + this.getAttackPoint() +
            " point(s) damage from " + this.name + ".");

        monster.setLifePoint(monster.getLifePoint() - this.getAttackPoint());
    }

    @Override
    public String toString() {
        return "Player | name: " + this.name + ", lifePoint: " +
            this.getLifePoint() + ", attackPoint: " + this.getAttackPoint();
    }
}