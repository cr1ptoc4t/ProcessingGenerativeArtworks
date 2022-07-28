float x1, y1, r;
float d = 10;
float m =5;
int c =0;

void setup(){
    size(800,800);
    background(0);
}

void draw(){
    rectMode(CENTER);
    arbol((float)width/2, (float)height/2);

}

void arbol(float x, float y){
    fill(255); stroke(255);
    x1=random(80, width - 40);
    y1=random(80, height - 40);
    r = random(m-d, m+d);
    if(c>230){
        if(c==231){
            background(130, 130,130, 200);
        }
        fill(255,0,0);
        //stroke();
    }
    line(x,y, x1, y1);
    ellipse(x1, y1, r, r);
        
    c++;
    println("iteración: " + c);
    delay(10);
}


void keyPressed() {
   if(key=='1'){
     noLoop();
   }
  
}