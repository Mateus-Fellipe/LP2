/*
Classe abstrata(arCondicionado):
  a - Uma casa com muitos ares-condicionados onde a gestão deles é feita através de um app
  b - Os ares-condicionados mesmo sendo objetos distintos compartilham das mesmas funções
  então podem ser definidos no mesmo grupo.
  c - O código esta logo abaixo.
  d - class arSplitSala{}, class arParedeQuarto1{}, class arParedeQuarto2{}, class arSplitEscritorio{}
*/
public class arCondicionado{
  public int temp;

  public arCondicionado(int temp){
      // Código para definir o objeto.
  }

  public boolean auto(){}
  public boolean fan(){}
  public boolean cool(){}
  public boolean dry(){}
  public boolean heat(){}
}

/*
Interface (controláveis):
  a - Uma casa inteligente com um app para realizar as ações.
  b - Uma casa inteligente cota com diversos dispositivos com caracteristicas
  individuais mas com funções compartilhadas entre todos.
  c - O código esta logo abaixo.
  d - public abstract class smartPlug implements controllable{};
      public abstract class AC implements controllable{}
      public abstract class cam implements controllable{}
      public abstract class smartTv implements controllable{}
      public abstract class doorLock implements controllable{}
*/

public interface{
  public boolean toConnet(int id, string wifi);
  public void turnOn(int id);
  public void turnOff(int id)
}
