/*
Adjetivo 1:
"Iluminável"

Métodos:
Aquecer, esfriar, brilhar.

Java:
*/
interface illuminable{
  int warm(void);
  void shine(int);
}

class sun implements illuminable{
  int lumen = 50;
  int temp = 25;

  int warm(void){
    int temtemperature = temp + 1;
    return temperature;
  }

  int cool(void){
    int temperature = temp - 1;
    return temperature;
  }

  void shine(int intensity){
    lumen += intensity;
  }
}

class lamp implements illuminable{
  int lumen = 50;
  int temp = 4000;

  int warm(void){
    int temtemperature = temp + 500;
    return temperature;
  }

  int cool(void){
    int temperature = temp - 500;
    return temperature;
  }

  void shine(int intensity){
    if(intensity + lumen < 100 && intensity + lumen > 0){
      lumen += intensity;
    }
  }
}

class firePit implements illuminable{
  int lumen = 50;
  int temp = 897;

  int warm(void){
    int temtemperature = temp + 5;
    return temperature;
  }

  int cool(void){
    int temperature = temp - 5;
    return temperature;
  }

  void shine(int intensity){
    if(lumen + intensity > 0){
      lumen += intensity;
    }
  }
}


/*
Adjetivo 2:
"Conduzivel"

Métodos:
Direção, velocidade.

Java:
*/
interface drivable{
  void direct(int);
  int speed(int, int);
  int acceleration(int, int);
}

class car implements drivable{
  int bSpeed = 0;
  void direct(int keyPressed){
    if(keyPressed == 28){
      rot += 90;
    }else if(keyPressed == 29){
      rot -= 90;
    }
  }

  int speed(int ac, int distance){
    int finalSpeed;
    finalSpeed = bSpeed + ac * distance;
    return finalSpeed;
  }
}

class helicapter implements drivable{
  int bSpeed = 0;
  void direct(int keyPressed){
    if(keyPressed == 28){
      rot += 10;
    }else if(keyPressed == 29){
      rot -= 10;
    }
  }

  int speed(int ac, int distance){
    int finalSpeed;
    finalSpeed = bSpeed + ac * distance;
    return finalSpeed;
  }
}

class ship implements drivable{
  int bSpeed = 0;
  void direct(int keyPressed){
    if(keyPressed == 28){
      rot += 10;
    }else if(keyPressed == 29){
      rot -= 10;
    }
  }

  int speed(int ac, int distance){
    int finalSpeed;
    finalSpeed = bSpeed + ac * distance;
    return finalSpeed;
  }
}
