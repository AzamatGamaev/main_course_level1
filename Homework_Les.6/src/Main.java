public class Main {

    public static void main (String[] agrs) {

        Dog dogBobik = new Dog("Bobik");
        Cat catTom = new Cat("Tom");

        System.out.println(catTom.run(200));
        System.out.println(catTom.swim(10));

        System.out.println(dogBobik.run(500));
        System.out.println(dogBobik.swim(10));

        System.out.println("Количество созданных объектов класса Animal: " + Animal.animalCreated);
        System.out.println("Количество созданных объектов класса Cat: "+ Cat.catCreated);
        System.out.println("Количество созданных объектов класса Dog: " + Dog.dogCreated);
    }
}
