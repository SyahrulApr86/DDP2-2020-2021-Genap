public abstract class Monster extends GameCharacter {
    public Monster(int lifePoint, int attackPoint) {
        super(lifePoint, attackPoint);
    }

    public abstract void dropItem(Player player);
}