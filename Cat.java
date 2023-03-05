package HW_6;


public class Cat {

    public String name;
    public int appetite;
    public volatile boolean satiety = false;

    public Cat(String name) {
        this(name, 10);
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                satiety = false;
                try {
                    Thread.sleep(5 * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        );
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (!satiety) {
            satiety = plate.decreaseFood(appetite);
        }
    }

    public void makeHungry() {
        satiety = false;
    }

    @Override
    public String toString() {
        return name + " {appetite = " + appetite + ", satiety = " + satiety + "}";
    }
}