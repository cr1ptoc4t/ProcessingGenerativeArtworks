int h1=51;
int h2=185;
int h3=255;
int z=0;


void setup(){
    size(800,800);
    background(0);
    smooth(5);
}

void draw(){
    background(0);
    noFill();
    createArc(width/2, height/2, color(199, 130, 220));    
}

void createArc(float x, float y, color c){
    
    for(int i=0; i<900; i+=20){
        
        stroke(h1 + (int)random(-50, 50), h2 + (int)random(-50, 50), h3 + (int)random(-50, 50));
        strokeWeight(9);
        arc(x, y,  9+i , 10+i/3, -PI+i+z, -HALF_PI+i+z);        
    }
    delay(100);
    z+=20;

}