/*
 * TO DO: 
 * Provide Constructor
 * Write setter and getter if needed
 * Complete all TO DOs
 */
public class Pokemon {
    // Membaut field yang dimiliki Pokemon class
    private final String name;
    private Trainer trainer;
    private int level;
    private final int defaultPower;

    // Constructor
    public Pokemon(String name, Trainer trainer, int level, int defaultPower) {
        this.name = name;
        this.trainer = trainer;
        this.level = level;
        this.defaultPower = defaultPower;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getTrainer() {
        return trainer.getName();
    }

    public int getLevel() {
        return level;
    }

    public int getBattlePower() {
        return level*defaultPower;
    }
    
    /**
     * @return string representation of the Pokemon
     */
    public String toString() {
        //TODO : Perbaiki agar program dapat berjalan sesuai contoh
        return String.format("%s saat ini berada di level %d memiliki battle power sebanyak %d dan dimiliki oleh %s", this.getName(), this.getLevel(), getBattlePower(), this.getTrainer());
    }

}