public class DogLoop
{
    public static void main(String[] args)
    {
        Dog smallDog = new Dog(5);
        Dog mediumDog = new Dog(20);
        Dog hugeDog = new Dog(150);
        // Dog.maxDog(smallDog,hugeDog).makeNoise();
        Dog[] manyDogs = new Dog[4];
        manyDogs[0] = smallDog;
        manyDogs[1] = mediumDog;
        manyDogs[2] = new Dog(120);
        manyDogs[3] = hugeDog;
        int i=0;
        while (i<manyDogs.length)
        {
            Dog.maxDog(manyDogs[i],mediumDog).makeNoise();
            i++;
        }
        /*smallDog.makeNoise();
        hugeDog.makeNoise();*/
        // Dog.makeNoise();

    }
}