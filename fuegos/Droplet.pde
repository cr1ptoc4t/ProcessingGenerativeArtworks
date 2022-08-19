class Droplet{
    //partícula del fuego que sube y, posteriormente baja
  PVector pos; // Keep track droplet position
  PVector vel; // droplet velocity
  boolean off; // hit the ground, and die
  float size; 
  float len; // length 
  
  Droplet(float x, float y, float z){
    pos = new PVector(x,y,z);
    vel = new PVector();
    this.len = random(10);
  }
  
  void show(){
    strokeWeight(1.5);
    stroke(random(0,255),random(0,255), random(0,255));  
    line(pos.x, pos.y, pos.z, pos.x, pos.y - len, pos.z);
  }
  
  void update(){
    vel.add(gravity);
    pos.add(vel);
    // Hit the ground and splashed
    if(pos.y < 300) {
      ss.init(pos.x, height, pos.z, vel.mag());
      off = true;

    }
  }
}
