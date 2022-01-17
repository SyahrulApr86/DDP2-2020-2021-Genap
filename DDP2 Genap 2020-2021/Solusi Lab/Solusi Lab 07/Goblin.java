import java.util.Random;

public class Goblin extends Monster {
    public Goblin(int lifePoint, int attackPoint) {
        super(lifePoint, attackPoint);
    }

    @Override
    public void attack(GameCharacter player) {
        Random random = new Random();
        int newAttackPoint = this.getAttackPoint() + random.nextInt(5);
        System.out.println(((Player) player).getName() + " received " 
            + newAttackPoint + " point(s) damage from Goblin.");

        player.setLifePoint(player.getLifePoint() - newAttackPoint);
    }

    @Override
    public void dropItem(Player player) {
        Random random = new Random();
        int attackEffectPoint = random.nextInt(21) - 10; // (-10) s/d 10
        player.setAttackPoint(player.getAttackPoint() + attackEffectPoint);

        System.out.println("Goblin has been defeated. It dropped an attack potion.");
        System.out.println("The potion added " + attackEffectPoint +
            " point(s) to your attackPoint.");
        
    }

    @Override
    public String toString() {
        return "Goblin | lifePoint: " + this.getLifePoint() + 
            ", attackPoint: " + this.getAttackPoint();
    }
}