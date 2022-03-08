class Linia {
  String nom;
  Punt p1, p2;

  Linia(String n, float x1, float y1, float x2, float y2) {
    this.nom = n;
    this.p1 = new Punt("P1", x1, y1);
    this.p2 = new Punt("P2", x2, y2);
  }

  Linia(String n, Punt p1, Punt p2) {
    this.nom = n;
    this.p1 = p1;
    this.p2 = p2;
  }

  void setNom(String n) {
    this.nom = n;
  }


  void setXY1(float x1, float y1) {
    this.p1.setXY(x1, y1);
  }

  void setXY2(float x2, float y2) {
    this.p2.setXY(x2, y2);
  }

  String getNom() {
    return this.nom;
  }

  float distancia() {
    return dist(this.p1.x, this.p1.y, this.p2.x, this.p2.y);
  }

  void display(color c) {
    fill(0);
    stroke(c);
    line(this.p1.x, this.p1.y, this.p2.x, this.p2.y);
    p1.display(c);
    p2.display(c);
    text(this.nom, (this.p1.x+this.p2.x)/2, (this.p1.y+ this.p2.y)/2- 25);
  }
}
