void setup(){
    size(800,800);
    background(120);
    color c= color(120, 120, 250);
    edificio(width/2, height/2, width/1.5, width/10, 200, 1, c);
}
void draw(){

}

void edificio(float x, float y, float w, float h, float h2, int n, color c){
  fill(c);

    //noStroke();
    beginShape();
        vertex(x - w/2, y - h2 );
        vertex(x,       y - 2*h2  );
        vertex(x + w/2, y - h2);
        vertex(x,       y       );
        vertex(x - w/2, y - h2);
    endShape();
  


  for(int i=0;i<n; i++){
    //c1-=15; c2-=15; c3-=15;
    //color c= color(c1, c2, c3);
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

    //ventana derecha
    int s = int(h/10);
    int t = int(w/10);
    //strokeWeight(5);
    //color interior
    fill(255);
    beginShape();
        vertex(x + t,       y + s) ;                // esq adalt
        vertex(x + t,       y + h2*i + h2 - 10*s);     // esq abaix
        vertex(x + w/2 - t, y + h2*i - s);          // dreta  abaix
        vertex(x + w/2 - t, y + h2*i - h2 + 10*s);     // dreta adalt
        vertex(x + t,       y + s);                 // esq adalt
    endShape();

    //noStroke();

    //color toldo
    fill(20, 20, 255);
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

  }

}

 void keyPressed() {
   if(key=='1'){
     noLoop();
   }
  
}