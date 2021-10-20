/*
Adjetivo 1:
"Iluminável"

Métodos:
Aquecer, brilhar.

Java:
*/
interface illuminable{
  int warm(void);
  void shine(int);
}

class sun implements illuminable{
  int warm(void){
    return temperature;
  }

  void shine(int intensity){
  }
}

class lamp implements illuminable{
  int warm(void){
    return temperature;
  }

  void shine(int intensity){
  }
}

class firePit implements illuminable{
  int warm(void){
    return temperature;
  }

  void shine(int intensity){
  }
}


/*
Adjetivo 2:
"Conduzivel"

Métodos:
Direção, velocidade, aceleração.

Java:
*/
interface drivable{
  void direct(int);
  int speed(int);
  int acceleration(int, int);
}

class car implements drivable{
  void direct(int keyPressed){
  }

  int speed(int ac){
    return finalSpeed;
  }

  int acceleration(int force, int way){
    return finalAc
  }
}

class helicapter implements drivable{
  void direct(int keyPressed){
  }

  int speed(int ac){
    return finalSpeed;
  }

  int acceleration(int force, int way){
    return finalAc
  }
}

class ship implements drivable{
  void direct(int keyPressed){
  }

  int speed(int ac){
    return finalSpeed;
  }

  int acceleration(int force, int way){
    return finalAc
  }
}
