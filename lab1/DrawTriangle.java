public class DrawTriangle{
   /**
    int[] numbers =new int[3];
    numbers[1]=4;
    numbers[2]=4;
    numbers[3]=4;
*/
    public static void DrawTriangle(int n){
    for(int j=1;j<=n;j++) {
            for (int i = 1; i <= j-1; i++) {
                System.out.print("*");
            }
            System.out.println("*");
            }
    }
    public static int Max(int n, int m){
        if(n>m) {  return n;}
        else { return m; }
    }
    public static int MaxNumbers(int[] m){
        int tmp=m[0], length = m.length;
        for(int i=0;i< length ;i++) {
            if (tmp <= m[i]) {
                tmp = m[i];
            }
        }
        return tmp;
    }

    //将每个元素的值替换为本身加上其后的n位元素之和，a[i]=a[i]+a[i+1]+...+a[n+i], n+i>a.length时，就加到边界为止
    public static void windowPosSum(int[] a, int n){
        int[] b=new int[a.length];
        for(int j=0;j<a.length;j++) {
            for (int i = j+1; i <(n >=a.length - j? a.length: n+j); i++) {
                a[j] += a[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers2 =new int[]{1,2,3,0,12,3};
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
        DrawTriangle(9);
        System.out.println(Max(3,66));
        //System.out.println(numbers);
        System.out.println(numbers2.length);
        System.out.println(MaxNumbers(numbers2));
       windowPosSum(numbers2,3);
        System.out.println(java.util.Arrays.toString(numbers2));
        for(int i=0;i<a.length;i++){
            if(a[i].contains("horse")){
                continue;
            }
            for(int j=0;j<3;j++)
                System.out.println(a[i]);
        }

        for(int i=0;i<a.length;i++){
            for(int j=0;j<3;j++) {
                System.out.println(a[i]);
            }
            if(a[i].contains("horse")){
                break;
            }

        }
        for(String s:a){
            for(int j=0;j<3;j++) {
                System.out.println(s);
            }
            if(s.contains("horse")){
                break;
            }

        }


    }
}

