public class Planet{
      public double xxPos;
      public double yyPos;
      public double xxVel;
      public double yyVel;
      public double mass;
      public String imgFileName;
      private static double gravity = 6.67e-11;
      public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
                    this.xxPos = xP;
                    this.yyPos = yP;
                    this.xxVel = xV;
                    this.yyVel = yV;
                    this.mass = m;
                    this.imgFileName = img;
              }
      public Planet(Planet p){
              this.xxPos = p.xxPos;
              this.yyPos = p.yyPos;
              this.xxVel = p.xxVel;
              this.yyVel = p.yyVel;
              this.mass = p.mass;
              this.imgFileName = p.imgFileName;
      }
      public double calcDistance(Planet d){
        double xxDis = d.xxPos - this.xxPos;
        double yyDis = d.yyPos - this.yyPos;
        double distance = Math.sqrt(xxDis*xxDis + yyDis*yyDis);
        return distance;
      }
      public double calcForceExertedBy(Planet p){
        double distance = this.calcDistance(p);
        double force = (this.mass*p.mass*gravity)/(distance*distance);
        return force;
      }
      public double calcForceExertedByX(Planet p){
        double force = this.calcForceExertedBy(p);
        double distance = this.calcDistance(p);
        double force_x = (force * (p.xxPos - this.xxPos))/distance;
        return force_x;
      }
      public double calcForceExertedByY(Planet p){
        double force = this.calcForceExertedBy(p);
        double distance = this.calcDistance(p);
        double force_y = (force * (p.yyPos - this.yyPos))/distance;
        return force_y;
      }
      public double calcNetForceExertedByX(Planet[] allPlanets){
        double netforce_x = 0;
        for (int i = 0;i<allPlanets.length;i++){
          if (this.equals(allPlanets[i])){
            continue;
          }
          netforce_x += this.calcForceExertedByX(allPlanets[i]);
        }
        return netforce_x;
      }
      public double calcNetForceExertedByY(Planet[] allPlanets){

        double netforce_y = 0;
        for (int i = 0;i<allPlanets.length;i++){
          if (this.equals(allPlanets[i])){
            continue;
          }
          netforce_y += this.calcForceExertedByY(allPlanets[i]);
        }
        return netforce_y;
      }
      public void update(double dt,double fX,double fY){
        double aX = fX/this.mass;
        double aY = fY/this.mass;
        this.xxVel = this.xxVel + aX*dt;
        this.yyVel = this.yyVel + aY*dt;
        this.xxPos = this.xxPos + dt*this.xxVel;
        this.yyPos = this.yyPos + dt*this.yyVel;
      }
      public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/" + this.imgFileName);
      }
}
