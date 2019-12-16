public class NBody {

    /**读取半径值*/
    public static double readRadius(String File)
    {
        In in = new In(File);  //In stream
        in.readInt();
        double Radius=in.readDouble();

        return Radius;
    }

    //planets.txt中的数据依次为 星球个数，半径值，然后是5x6的数据，每行代表一个planet数据，列依次为 x位置，y位置，x速度，y速度，星球质量，星球图片。
    public static Planet[] readPlanets(String File)
    {
        In in = new In(File);  //In stream
        int Planets_num= in.readInt();
        in.readDouble();
        Planet[] Planets = new Planet[Planets_num];

        int i=0;
        while(i<Planets_num)
        {
            double xp=in.readDouble();
            double yp=in.readDouble();
            double xv=in.readDouble();
            double yv=in.readDouble();
            double mass = in.readDouble();
            String img= in.readString();
            Planets[i++]=new Planet(xp,yp,xv,yv,mass,img);
        }
        return Planets;
    }

    public static  void main(String[] args)
    {
        //Get data
        double T= Double.parseDouble(args[0]);  //第一个参数
        double dt= Double.parseDouble(args[1]); //第二个参数
        String filesName =args[2];
        double uniRadius = NBody.readRadius(filesName);
        Planet[] Planets  = NBody.readPlanets(filesName);


        //draw background
        /*set the scale of the universe*/
        StdDraw.setScale(-uniRadius, uniRadius);
        /* Clears the drawing window. */
        StdDraw.clear();
        /* starfiled */
        StdDraw.picture(0, 0, "images/starfield.jpg");

        //draw planets
        for(Planet planet:Planets)
            planet.draw();  //非静态函数需要实例才能调用

        //start animation
        StdDraw.enableDoubleBuffering();

        //直到t到达T时间
        for(double t=0;t<=T;t+=dt)
        {
            //计算X,Y方向上的合力
            double[] xForces=new double[Planets.length];
            double[] yForces=new double[Planets.length];
            for(int i=0;i<Planets.length;i++)
            {
                xForces[i]=Planets[i].calcNetForceExertedByX(Planets);
                yForces[i]=Planets[i].calcNetForceExertedByY(Planets);
            }

            //更新位置和速度
            for(int i=0;i<Planets.length;i++)
            {
                Planets[i].update(dt,xForces[i],yForces[i]);
            }

            //draw background
            StdDraw.picture(0, 0, "images/starfield.jpg");

            //draw all planets
            for(Planet planet:Planets)
            {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
        }
        /**
         * Print out the final state of the universe when time reaches T
         */
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }

    }

}
