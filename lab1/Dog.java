public class Dog{
    public int weightInPounds;  //instance variable
    public static  String binomen ="Canis familiaris";

    public Dog(int startingWeight)
    {
        weightInPounds = startingWeight;
    }
    public static Dog maxDog(Dog d1, Dog d2)  /**静态方法只能被类名调用，不能被实例调用*/
    {
        if(d1.weightInPounds>d2.weightInPounds)
            return d1;
        else
            return d2;
    }
    public  Dog maxDog(Dog d2)  /**this指针代表本身自己，，，非静态方法只能被实例调用，不能被类名调用*/
    {
        if(this.weightInPounds>d2.weightInPounds)
            return this;
        else
            return d2;
    }
    public  void makeNoise()
    {
        if(weightInPounds <10)
        System.out.printf("yipyipyip!\n");
        else if(weightInPounds<30)
            System.out.printf("bark.bark.\n");
        else
            System.out.printf("woof!\n");
    }

}