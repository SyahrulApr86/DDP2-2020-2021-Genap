public class Player extends GameCharacter {
    private final String name;

    public Player(String name) {
        super(100, 15);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack(GameCharacter monster){
        monster.setLifePoint(monster.getLifePoint() - this.getAttackPoint());
        System.out.printf("Monster received 15 point(s) damage from %s \n", getName());
    }

    @Override
    public String toString() {
        return String.format("Player | name: %s, lifePoint: %d, attackPoint: %d", this.getName(), this.getLifePoint(), this.getAttackPoint());
    }
}