import java.util.*;

public class Pokemon {
    private String name;
    private Trainer trainer;
    private int level;
    private int defaultPower;

    public Pokemon (String name, Trainer trainer, int level, int defaultPower) {
        this.name = name;
        this.trainer = trainer;
        this.level = level;
        this.defaultPower = defaultPower;
    }

    public int getBattlePower() {
        return level * defaultPower;
    }

    public String getName() {
        return this.name;
    }
    
    /**
     * @return string representation of the Pokemon
     */
    public String toString() {
        return String.format("%s saat ini berada di level %d memiliki battle power sebanyak %d dan dimiliki oleh %s", name, level, getBattlePower(), trainer.getName());
    }

}