

int f;
void setup() {
  size(1000,1000, P3D);
  background(10, 10, 30);
  fill(0,0,0,0);
  noStroke();
  f = 10;
}

void draw() {
  float dif=90;
  //background((int)random(200,255), (int)random(200,255), (int)random(200,255));
  
  background(f, f, f);

  for(float j= 30; j< height; j+=dif){
    for(float i=30; i< width; i+=dif){
      edificio(random(i, i+ dif/2), random(j, j+dif/2), random(100, 150), random(20, 60), random(20,30), (int)random(10,100), (int)random(0,255), (int)random(0,255), (int)random(0,255));
    }
  }
  delay(500);
  f+=5;
}


void edificio(float x, float y, float w, float h, float h2, int n, int c1, int c2, int c3){
  fill(c1, c2, c3);


  beginShape();
    vertex(x - w/2, y - h2 );
    vertex(x,       y - 2*h2  );
    vertex(x + w/2, y - h2);
    vertex(x,       y       );
    vertex(x - w/2, y - h2);
  endShape();

  for(int i=0;i<n; i++){
    c1-=15; c2-=15; c3-=15;
    color c= color(c1, c2, c3);
    fill(c);

    beginShape();
      vertex(x,       y + h2*i);
      vertex(x - w/2, y + h2*i - h2);
      vertex(x - w/2, y + h2*i);
      vertex(x,       y + h2*i + h2);
      vertex(x + w/2, y + h2*i);
      vertex(x + w/2, y + h2*i - h2);
      vertex(x,       y + h2*i);
    endShape();
  }

}

 void keyPressed() {
   if(key=='1'){
     noLoop();
   }
  
}