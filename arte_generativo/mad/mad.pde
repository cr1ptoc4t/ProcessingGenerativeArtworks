int cols, rows;
int scl = 20;
int w = 2000;
int h = 1600;
float rot = 0;
float rot2 =PI/3;
float rot3 = PI/3;
float c;
float flying = 0;

float[][] terrain;

void setup() {
  size(600, 600, P3D);
  fullScreen();
  cols = w / scl;
  rows = h/ scl;
  terrain = new float[cols][rows];
}


void draw() {

  flying -= 0.1;

  float yoff = flying;
  for (int y = 0; y < rows; y++) {
    float xoff = 0;
    for (int x = 0; x < cols; x++) {
      terrain[x][y] = map(noise(xoff, yoff), 0, 1, -100, 100);
      xoff += 0.2;
    }
    yoff += 0.2;
  }


  background(2);
  
  noFill();

  translate(width/2, height/2+50);
  rotateX(rot2);
  rotateY(rot);
  rotateZ(rot3);
  translate(-w/2, -h/2);
  for (int y = 0; y < rows-1; y++) {
    beginShape(TRIANGLE_STRIP);
    for (int x = 0; x < cols; x++) {
      c = random(100,170);
      stroke(terrain[x][y]*5, terrain[x][y]*5, (frameCount/10), frameCount/3);
      vertex(x*scl, (y)*scl, terrain[x][y]);
      vertex(x*scl, (y+1)*scl, terrain[x][y+1]);
    }
    endShape();
  }
  //rot+=PI/1000;
  //rot2+=PI/1400;
  //rot3+=PI/1300;
}

void keyPressed() {
   if(key=='1'){
     noLoop();
   } 
}