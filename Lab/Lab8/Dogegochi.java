import java.util.Objects;

public class Dogegochi {
  int energy;

  String[] list_activity = new String[3];

  String lastActivity;

  public Dogegochi() {
    this.energy = 50;
    lastActivity = "";
  }

  public void reduceEnergy() {
    this.energy -= 20;
    if (this.energy < 0){
      this.energy = 0;
    }
  }

  public void addEnergy(int quantity) {
    this.energy += 2*quantity;
    if (this.energy > 100){
      this.energy = 100;
    }
  }

  public boolean checkActivity(String activity) {
      if (!Objects.equals(activity, list_activity[0])){
        list_activity[0] = activity;
        list_activity[1] = null;
        list_activity[2] = null;
        return true;
      } else {
        if (list_activity[1] == null){
          list_activity[1] = activity;
          return true;
        } else {
          return false;
        }
      }

  }

  public void eat(String food, int quantity) {
    if (this.energy == 100) {
      try {
        throw new FullException("doge kenyang");
      } catch (FullException e) {
        System.out.println("[FAILED: Dogenya sudah buncit tidak kuat makan lagi :(]");
      }
    } else if (0 <= this.energy && this.energy < 100) {
      if (checkActivity("eat")) {
        addEnergy(quantity);
        System.out.printf("[SUCCESS : Dogenya makan %s sebanyak %d dengan gembira]\n", food, quantity);
        this.lastActivity = "eat";
      } else {
        try {
          throw new BoredException("doge bosen");
        } catch (BoredException e) {
          System.out.println("[FAILED: Dogenya bosan nih, gak mau melakukan hal lain saja?]");
        }
    }
    }
  }


  public void play() {
      if (this.energy == 0) {
        try {
          throw new HungerException("doge lapar");
        } catch (HungerException e) {
          System.out.println("[FAILED: Dogenya lemes butuh makan :(]");
        }
      } else {
        if (checkActivity("play")) {
        reduceEnergy();
        System.out.println("[SUCCESS: Dogenya bermain dengan senang hati]");
        this.lastActivity = "play";
      } else {
          try {
            throw new BoredException("doge bosen");
          } catch (BoredException e){
            System.out.println("[FAILED: Dogenya bosan nih, gak mau melakukan hal lain saja?]");
          }
        }
    }
  }

  public void getStatus() {
    System.out.println("Status Doge:");
    System.out.println("Energy = " + this.energy);
  }
}

class FullException extends Exception {
  public FullException (String message){
    super(message);
  }
}

class HungerException extends Exception {
  public HungerException (String message){
    super(message);
  }
}

class BoredException extends Exception {
  public BoredException (String message){
    super(message);
  }
}
