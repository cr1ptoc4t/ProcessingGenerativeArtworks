class RainSystem {
  ArrayList<Droplet> droplets;
  int f;
  
  RainSystem(int f) {
    this.f = f;
    droplets = new ArrayList<Droplet>();
  }

  void run() {
    for (int i = 0; i < f; i++) {
      droplets.add(new Droplet(random(-width, width*2), random(height-150,height), random(-2500, 500)));
    }
    for (int i = droplets.size() - 1; i >= 0; i--) {
      if (droplets.get(i).off) {
        droplets.remove(i);
      } else {
        droplets.get(i).update();
        droplets.get(i).show();
      }
    }
  }
}