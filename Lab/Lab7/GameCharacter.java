
public abstract class GameCharacter {
    private int lifePoint;
    private int attackPoint;
    private boolean isAlive;

    public GameCharacter(int lifePoint, int attackPoint) {
        this.lifePoint = lifePoint;
        this.attackPoint = attackPoint;
        this.isAlive = true;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
        if (this.lifePoint <= 0){
            this.lifePoint = 0;
            this.isAlive = false;
        }
        if (this.lifePoint > 100) {
            this.lifePoint = 100;
        }
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public abstract void attack(GameCharacter gameCharacter);
}