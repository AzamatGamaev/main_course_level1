public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        if (appetite < 0) {
            throw new IllegalArgumentException("The appetite value must be greater than 0");
        }
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    } //Default Getters and Setters

    public void eat(Plate catAppetite) {
        catAppetite.decreaseFood(appetite);
    }

    public void isHungry(int availableFood) {
        if (availableFood < appetite) {
            satiety = false;
            System.out.println("Cat " + name + " is hungry.");
        } else {
            satiety = true;
            System.out.println("Cat  " + name + " is well fed.");
        }
    }
}
