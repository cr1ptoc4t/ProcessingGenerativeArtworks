float x1, y1, r;
float d = 10;
float m =5;
int c =0;
int w = (int)random(0, 255);
color a;

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
    /*
    if(c>230){
        if(c==231){
            background(0,0,0);
        }
        fill(255,0,0);
        //stroke();
    }
    */
    if(c%3!=0){
        a = color(w + random(-30, 30),w + random(-30, 30),w + random(-30, 30));
        fill(a);
        
    }
    line(x,y, x1, y1);
    strokeWeight(1);
    stroke(a);
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