int h1=51;
int h2=185;
int h3=255;
int z=0;
int h=1;
boolean b = true;

void setup(){
    size(800,800, P3D);
    background(0);
    smooth(5);
}

void draw(){
    background(0);
    noFill();

    //createArc(width/2, 2*height/3, color(199, 130, 220));
   
    createArc(width/2, height, color(199, 130, 220)); 

}

void createArc(float x, float y, color c){
    

    for(int i=0; i<900; i+=20){
        background(0);
        
        stroke(255,120,120, 130);


        pushMatrix();
            translate(x, y-z);
            
            rotateY(z);
            //rotateX(a/2);
            sphere(10+i/3);
            stroke(255, 100, 210, 130);
            //rotateY(a);
            //rotateY(-2*a);
            //sphere(150);
        popMatrix();

        stroke(h1 + (int)random(-50, 50), h2 + (int)random(-50, 50), h3 + (int)random(-50, 50));
        strokeWeight(9);
        arc(x, y-h*i,  9+i , 10+i/3, -PI+i+z, -HALF_PI+i+z);        
    }
    //println("h: "+ h);
    delay(50);
    z+=20;
    if(h==10||h==0){
        b = !b;
    }
    if(b){
        h+=0.1;
    } else{ h-=0.1; }

}