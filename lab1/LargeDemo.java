

public class LargeDemo {
    /* Returns the larger of x and y */
    public static  int larger(int x,int y)
    {
        if(x>y)
        {
            return x;
        }
        else
            return y;
    }

    public static void main(String[] args)
    {
        System.out.println(larger(-5,10));
    }
}

/***
 * 1. Functions inj java must be declared as part of a class, called method.
 * 2. To define a function in java, we use " public static", alternative ways of defining functions seen later.
 * 3. All parameters of a functions must have a declared type, and the return value of the function must have a declared type,
 *    and function in java return only one value.
 * 4. Readable, self-document.
 */
