public class Planet
{
    public double xxPos;    // Its x position
    public double yyPos;    // Its y position
    public double xxVel;    // Its x velocity
    public double yyVel;    // Its y velocity
    public double mass;     // Its mass
    public String imgFileName;
    // The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)
    public Planet(double xP, double yP, double xV, double yV, double m, String img)
    {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b)
    {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /**
     * Calculate the distance between two  Planets
     */
    public double calcDistance(Planet b)
    {
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        double r = Math.hypot(dx, dy);  //求解直角边对应的斜边
        return r;
    }

    /**
     * Calculate the force exerted on this body by the given Planets
     */
    public double calcForceExertedBy(Planet b)
    {
        double G = 6.67e-11;
        double F = (G * this.mass * b.mass) / Math.pow(this.calcDistance(b), 2);
        return F;
    }

    /**
     * Calculate the force in x direction and y direction
     */
    public double calcForceExertedByX(Planet b)
    {
        double Fx = this.calcForceExertedBy(b) * (b.xxPos - this.xxPos) / this.calcDistance(b);
        return Fx;
    }

    public double calcForceExertedByY(Planet b)
    {
        double Fy = this.calcForceExertedBy(b) * (b.yyPos - this.yyPos) / this.calcDistance(b);
        return Fy;
    }

    /**
     * Calcualte the net force in x direction and y direction
     */
    public double calcNetForceExertedByX(Planet[] bs) {
        double FxNet = 0;
        for (Planet b : bs) {
            if (!this.equals(b)) {
                FxNet += this.calcForceExertedByX(b);
            }
        }
        return FxNet;
    }

    public double calcNetForceExertedByY(Planet[] bs) {
        double FyNet = 0;
        for (Planet b : bs) {
            if (!this.equals(b)) {
                FyNet += this.calcForceExertedByY(b);
            }
        }
        return FyNet;
    }


}