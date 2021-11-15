package ivisible;

import java.awt.Graphics;

public interface IVisible{
  public void paint(Graphics g, boolean selected);
  public boolean clicked(int x, int y);
}
