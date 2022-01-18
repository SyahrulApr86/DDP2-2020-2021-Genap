// TODO: identifikasi apakah class merupakan abstract class 
// TODO: identifikasi apakah method merupakan abstract method


import java.util.Random;

public class Kobold extends Monster {

    // TODO: tambahkan data field JIKA diperlukan

	// TODO: lengkapi constructor sesuai konsep OOP
    public Kobold(int lifePoint, int attackPoint) {
        super(lifePoint, attackPoint);
    }

    @Override
    public void dropItem(Player player) {
        Random random = new Random();
        int lifeEffectPoint = random.nextInt(21) - 10; // (-10) s/d 10
        player.setLifePoint(player.getLifePoint() + lifeEffectPoint);

        System.out.println("Kobold has been defeated. It dropped a life potion.");
        System.out.printf("The potion added %d point(s) to your lifePoint.\n", lifeEffectPoint);

    }

    @Override
    public void attack(GameCharacter player) {
        player.setLifePoint(player.getLifePoint() - this.getAttackPoint());
        System.out.printf("%s received %d point(s) damage from Kobold \n", ((Player) player).getName(), getAttackPoint());
        //TODO: lengkapi implementasi dari Override
    }

    @Override
    public String toString() {
        return String.format("Kobold | lifePoint: %d, attackPoint: %d", this.getLifePoint(), this.getAttackPoint());
    }

    // TODO: tambahkan method-method lain seperti setter-getter dan Override method jika diperlukan
}