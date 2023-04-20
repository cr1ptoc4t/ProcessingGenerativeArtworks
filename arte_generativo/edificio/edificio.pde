  int altura=height/2;


void setup(){
    size(800,800);
    background(120);
    color c= color(255, 239, 204);
    
}
void draw(){
  background(120);
  for(int i=0; i<width/2;i+=width/10){
      edificio(i, altura, 120, 130, 25, 70, i*230/width, 0, 153);
      altura-=30;
    }
    altura=height/2;

    for(int i=width; i>width/2;i-=width/10){
      edificio(i, altura, 120, 130, 25, 70, i*230/width, 0, 153);
      altura-=30;

    }
    
    edificio(width/2, altura, 120, 130, 25, 70, 170, 0, 153);

}

void edificio(float x, float y, float w, float h, float h2, int n, int c1, int c2, int c3){
  color c = color(c1, c2, c3);
  int b1 = 179;
  int b2 = 217;
  int b3 = 255;
  color b = color(b1, b2, b3);
  fill(c);

  noStroke();

  beginShape();
        vertex(x - w/2, y - h2 );
        vertex(x,       y - 2*h2);
        vertex(x + w/2, y - h2);
        vertex(x,       y       );
        vertex(x - w/2, y - h2);
  endShape();
  
  for(int i=0;i<n; i++){
    c= color(c1, c2, c3);
    c1-=15; c2-=15; c3-=15;
    fill(c);

  //orden antihorario
    beginShape();
      vertex(x,       y + h2*i);
      vertex(x - w/2, y + h2*i - h2);
      vertex(x - w/2, y + h2*i);
      vertex(x,       y + h2*i + h2);
      vertex(x + w/2, y + h2*i);
      vertex(x + w/2, y + h2*i - h2);
      vertex(x,       y + h2*i);
      vertex(x,       y + h2*i+h2);

    endShape();

    //ventana derecha
    /*
    int t = 20;
    int s = t;
    //strokeWeight(5);
    //color interior
    
    b= color(b1, b2, b3);
    b1-=15; b2-=15; b3-=15;
    fill(b);
    quad( x +s, y + h2*i+ s, x +s, y+ h2*i + h2 - s - 35, x+ w/2-s, y+h2*i-s, x+w/2- s, y + h2*i - h2+ s + 35);


    
    beginShape();
      vertex(x + t,       y + h2*i + h2 - s);
      vertex(x + w/2 -t , y + h2*i - s);
      vertex(x + w/2 -t   , y + h2*i - h2+ s);
      vertex(x+ t,       y + h2*i+ s);
      vertex(x + t,       y + h2*i + h2 - s);
    endShape();

    //noStroke();
    
    //color toldo
    fill(120, 172, 255);
    beginShape();
        vertex(x + t,       y + s) ;                // esq adalt
        vertex(x + w/2 - t, y + h2*i - h2 + 10*s);     // dreta adalt
        vertex(x + w/2 - t + 50, y + h2*i - h2 + 10*s+ 50);     // dreta abaix
        vertex(x + t+ 50,       y + s+50);                 // esq abaix
        vertex(x + t,       y + s);                 // esq adalt
    endShape();


    //balcon
    fill(0);
    beginShape();
        vertex(x + t+50,       y + h2*i + h2 - 10*s);      // esq abaix
        vertex(x + t,       y + h2*i + h2 - 10*s);      // esq abaix
        vertex(x + w/2 - t, y + h2*i - s);              // dreta  abaix
        vertex(x + w/2 - t +50, y + h2*i - s);              // dreta  abaix
        vertex(x + t+50,       y + h2*i + h2 - 10*s);      // esq abaix
    endShape();
    //faltan barritas
    */

  }

}

 void keyPressed() {
   if(key=='1'){
     noLoop();
   }
  
}