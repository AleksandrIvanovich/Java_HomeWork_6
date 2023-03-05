package HW_6;

public class Plate {

    public int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean increaseFood(int x){
        food = food + x; 
        return true;
    }

    public boolean decreaseFood(int foodToDecrease) {
        if (food >= foodToDecrease) {
            food = food - (foodToDecrease);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }
}