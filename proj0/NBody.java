public class NBody{

  public static double readRadius(String path){
    In in = new In(path);
    int number = in.readInt();
    double radius =  in.readDouble();
    return radius;
  }
  public static Planet[] readPlanets(String path){
    In in = new In(path);
    int number = in.readInt();
    double radius =  in.readDouble();
    Planet[] allPlanets = new Planet[number];
    for (int i=0;i<number;i++){
      double xxPos = in.readDouble();
      double yyPos = in.readDouble();
      double xxVel = in.readDouble();
      double yyVel = in.readDouble();
      double mass = in.readDouble();
      String imgFileName = in.readString();
      allPlanets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
    }
    return allPlanets;
  }
  public static void main(String[] arg){
    double T = Double.parseDouble(arg[0]);
    double dt = Double.parseDouble(arg[1]);
    String filename = arg[2];
    double radius = readRadius(filename);
    Planet[] allPlanets = readPlanets(filename);
    StdDraw.enableDoubleBuffering();
    for (double time = 0;time < T; time += dt){
      double[] xForces = new double[allPlanets.length];
      double[] yForces = new double[allPlanets.length];
      for (int i=0;i<allPlanets.length;i++){
        xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
        yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
      }
      for (int j=0;j<allPlanets.length;j++){
        allPlanets[j].update(dt,xForces[j],yForces[j]);
      }
      StdDraw.setScale(-radius, radius);
      StdDraw.clear();
      StdDraw.picture(0,0,"images/starfield.jpg");
      for (int i = 0;i<allPlanets.length;i++){
        allPlanets[i].draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
    }
    StdOut.printf("%d\n", allPlanets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < allPlanets.length; i++) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
      allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
      allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
    }
  }
}
