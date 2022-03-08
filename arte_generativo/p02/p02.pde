float i;

void setup(){
    size(1000,1000);
    
}

void draw(){
    background(230, 230, 255);
    fill(220, 230,200, 230);
    
}

void cuadrado(){
    pushMatrix();
        rotate(i*PI/16);
        fill(0);
        translate(width/2, height/2, 0);
        box(100);
        fill(255);
        rotate(-i*PI/16);
        box(100);
        delay(100);
    popMatrix();
    i+=0.3;
}

void recursive(float x, float y, float r){
    translate(x/2, y/2, 0);
    sphere(100);

    if(r<10){
        sphere(100);
    } else{
        recursive(x, y, r- 30);
    }

}