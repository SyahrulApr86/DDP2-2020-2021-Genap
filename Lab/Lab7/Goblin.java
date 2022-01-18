
import java.util.Random;

public class Goblin extends Monster {
    public Goblin(int lifePoint, int attackPoint) {
        super(lifePoint, attackPoint);
    }

    @Override
    public void dropItem(Player player) {
        Random random = new Random();
        int lifeEffectPoint = random.nextInt(21) - 10; // (-10) s/d 10
        player.setAttackPoint(player.getAttackPoint() + lifeEffectPoint);

        System.out.println("Goblin has been defeated. It dropped a attack potion.");
        System.out.printf("The potion added %d point(s) to your attackPoint.\n", lifeEffectPoint);
    }

    @Override
    public void attack(GameCharacter player) {
        Random random = new Random();
        int newAttackPoint = this.getAttackPoint() + random.nextInt(5);
        player.setLifePoint(player.getLifePoint() - newAttackPoint);
        System.out.printf("%s received %d point(s) damage from Kobold \n", ((Player) player).getName(), newAttackPoint);
    }

    @Override
    public String toString() {
        return String.format("Goblin | lifePoint: %d, attackPoint: %d", this.getLifePoint(), this.getAttackPoint());
    }

}