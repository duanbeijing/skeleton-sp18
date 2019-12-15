public class DogLauncher {
    public static void main(String[] args){
        Dog smallDog;
        new Dog(20);
        smallDog =new Dog(5);
        Dog hugeDog = new Dog(150);
        Dog.maxDog(smallDog,hugeDog).makeNoise();

        smallDog.makeNoise();
        hugeDog.makeNoise();
       // Dog.makeNoise();
        }
}