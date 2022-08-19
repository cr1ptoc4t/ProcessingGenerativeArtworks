
float altura;
int f;
boolean executar = true;

PFont fuente;

void setup() {
  size(1000,1000, P3D);
  background(10, 10, 30);
  fill(0,0,0,0);
  noStroke();
  f = 10;
  altura = 0;
  //fuente = loadFont("DMSans-Bold.ttf");

}

void draw() {
  //recursivo(width/2, height/2, 200, 0);
  //edificio(width/2, height/5, 100, 50, 20, 100, 220, 255, 200);
  float dif=100;
  float desv =35;
  
  //background((int)random(200,255), (int)random(200,255), (int)random(200,255));
  if(executar){
    background(255);

    for(float j= 30; j< height; j+=dif){
      for(float i=30; i< width; i+=dif){
        edificio(random(i, i+ dif/2), random(j, j+dif/2) + 30*sin(altura), random(100, 150), random(20, 30), random(20,30), (int)random(10,100), (int)random(66- desv,66+ desv), (int)random(202 -desv,202+ desv), (int)random(253 - desv,253+desv)); //66, 202, 253
      }
    }
    delay(500);
    altura++;
  }

  //textFont(fuente, 60);
  textSize(60);
  textAlign(CENTER);
  fill(255);
  text("Plaved", width/2, height/2);
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
    if(i%2==0){
      fill(c1, c2, c3);
    }

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
  if(key==ENTER){
    executar= !executar;
  }
}