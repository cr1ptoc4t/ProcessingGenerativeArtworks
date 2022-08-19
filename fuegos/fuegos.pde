//este es un sistema reciclado el cual se ha usó para la simulación de lluvia
//se pretende transformar el sistema para la simulación de fuegos artificiales

RainSystem rs; // Downpour
SplashSystem ss; // Droplet hits the ground, and splashed 
PVector gravity = new PVector(0, -0.59, 0);
PVector sgravity = new PVector(0, 0.59, 0);

void setup() {
  fullScreen(P3D);
  stroke(255);
  rs = new RainSystem(1); // 20 drops per frame
  ss = new SplashSystem();
}

void draw() {
  background(0);
  //rotateX(5.436); // Nice view from this angle
  rs.run(); // Pouring
  ss.run(); // Splashing
  if(mousePressed){
    println("x: "+ mouseX+"\ty: "+ mouseY);
    //noLoop();
    delay(150);
  }
}