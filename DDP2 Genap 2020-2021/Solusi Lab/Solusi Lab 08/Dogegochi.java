public class Dogegochi {
  int energy;

  int activityRepeat;
  String lastActivity;

  public Dogegochi() {
    this.energy = 50;
    lastActivity = "";
  }

  public void reduceEnergy() throws HungerException {
    if (this.energy == 0) {
      throw new HungerException("Dogenya lemes butuh makan :(");
    } else {
      this.energy -= 20;
      if (this.energy < 0) this.energy = 0;
    }
  }

  public void addEnergy(int quantity) throws FullException {
    if (this.energy == 100) {
      throw new FullException("Dogenya sudah buncit tidak kuat makan lagi :(");
    } else {
      this.energy += quantity * 2;
      if (this.energy > 100) {
        this.energy = 100;
      }
    }
  }

  public void addActivity(String activity, boolean repeat) {
    if (!repeat) {
      this.activityRepeat = 1;
    } else {
      this.activityRepeat++;
    }
    lastActivity = activity;
  }

  public boolean checkActivity(String activity) throws BoredException {
    if (!lastActivity.isEmpty()) {
      return checkActivityRepeat(activity);
    }
    return false;
  }

  public boolean checkActivityRepeat(String activity) throws BoredException {
    if (lastActivity.equals(activity)) {
      return checkBored(activity);
    }
    return false;
  }

  public boolean checkBored(String activity) throws BoredException {
    if (this.activityRepeat == 2) {
      throw new BoredException("Dogenya bosan nih, gak mau melakukan hal lain saja?");
    }
    return true;
  }


  public void eat(String food, int quantity) {
    try {
      boolean check = checkActivity("eat");
      addEnergy(quantity);
      addActivity("eat", check);
      System.out.printf("[SUCCESS : Dogenya makan %s sebanyak %d dengan gembira]\n", food, quantity);
    } catch (BoredException | FullException exception) {
      printFailure(exception.getMessage());
    }
  }

  public void play() {
    try {
      boolean check = checkActivity("play");
      reduceEnergy();
      addActivity("play", check);
      System.out.println("[SUCCESS : Dogenya bermain dengan senang hati]");
    } catch (BoredException | HungerException exception) {
      printFailure(exception.getMessage());
    }
  }

  public void printFailure(String message) {
    System.out.println("[FAILED : " + message + "]");
  }

  public void getStatus() {
    System.out.println("Status Doge:");
    System.out.println("Energy = " + this.energy);
  }
}
