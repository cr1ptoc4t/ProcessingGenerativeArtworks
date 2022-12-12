Arbol a; //declaras objeto arbol

void setup(){
    size(800, 800);
    a = new Arbol (); //construyes objeto arbol
    for(int i=0;i<10;i++){
        a.addElement((int)random(0,100)); //le añades elementos random al arbol
    }
    a.raiz.inOrdre();
}
void draw(){
    background(255, 210, 255);
    a.display(a.raiz, width/2, 100, 50,0);
}

void mousePressed(){
    a = new Arbol ();
    for(int i=0; i<10 ; i++){
        a.addElement((int)random(0,100));
    }
}