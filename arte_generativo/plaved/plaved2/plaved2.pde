void setup(){
    size(1920, 1080, P3D);
}
void draw(){
    background(255);
    fill(48, 166, 251);
    noStroke();
    float wave = sin(radians(frameCount));

    
    line(x1, y1, x2, y2);
    ellipse(width/2 + wave *300, height/2, 100, 100);

}