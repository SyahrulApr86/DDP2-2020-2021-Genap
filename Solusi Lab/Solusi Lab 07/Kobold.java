import java.util.Random;

public class Kobold extends Monster {

    public Kobold(int lifePoint, int attackPoint) {
        super(lifePoint, attackPoint);
    }

    @Override
    public void attack(GameCharacter player) {
        System.out.println(((Player) player).getName() + " received " 
            + this.getAttackPoint() + " point(s) damage from Kobold.");

        player.setLifePoint(player.getLifePoint() - this.getAttackPoint());
    }

    @Override
    public void dropItem(Player player) {
        Random random = new Random();
        int lifeEffectPoint = random.nextInt(21) - 10; // (-10) s/d 10
        player.setLifePoint(player.getLifePoint() + lifeEffectPoint);

        System.out.println("Kobold has been defeated. It dropped a life potion.");
        System.out.println("The potion added " + lifeEffectPoint +
            " point(s) to your lifePoint.");
    }

    @Override
    public String toString() {
        return "Kobold | lifePoint: " + this.getLifePoint() + 
            ", attackPoint: " + this.getAttackPoint();
    }
}