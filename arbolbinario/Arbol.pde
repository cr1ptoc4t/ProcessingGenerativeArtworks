class Arbol{
    Nodo raiz;

    Arbol(){
        this.raiz = null;
    }

    boolean isEmpty(){
        return this.raiz == null;
    }

    void addElement(int n){
        if(isEmpty()){
            this.raiz = new Nodo (n);
        } else{
            Node padre = this.raiz;
            while ((padre.izq != null&& n<padre.num) || (padre.der != null && n>padre.num) || (padre.num==n)){
                if(n<padre.num){
                    padre = padre.izq;
                } else if (n>padre.num){
                    padre = padre.der;
                }
            }
            if(n<padre.num){
                padre.izq = new Nodo (n);
            }else if (n>padre.num){
                padre.der= new Nodo (n);
            }
        }
    }

    void display(Node n, float x, float y,float r,int lvl){
        float dx = (width/3)/(lvl+2);
        n.display(x, y,r, lvl);
        if(n.izq != null){ display(n.izq,x-dx, y+100, r, lvl+1);}
        if(n.der != null){display(n.der,x+dx, y+100, r, lvl+1);}
    }

    int getMinimo(){
        Node padre = this.raiz;
        while(padre.izq!=null){
            padre = padre.izq;
        }
        return padre.num;
    }

    int getMaximo(){
        Node padre = this.raiz;
        while(padre.der!=null){
            padre = padre.izq;
        }
        return padre.num;
    }
    
}