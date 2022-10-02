class SplashSystem {
  ArrayList<Splash> splashes;
  SplashSystem() {
    splashes = new ArrayList<Splash>();
  }

  void run() {
    for (int i = splashes.size() - 1; i >= 0; i--) {
      if (splashes.get(i).off) {
        splashes.remove(i);
      } else {
        splashes.get(i).update();
        splashes.get(i).show();
      }
    }
  }
  
  void init(float x, float y, float z, float size){
    for (int i = 0; i < size/3; i++) {
      splashes.add(new Splash(x, y, z, size));
    }
  }
}