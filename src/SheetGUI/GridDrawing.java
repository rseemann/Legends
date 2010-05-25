package SheetGUI;

import java.awt.Graphics;

public class GridDrawing{

	  public void paint (Graphics g) 
	  {
	    // Draw the vertical lines:
	    for (int x=0; x<=240; x+=30) {
	      g.drawLine (x,0, x,240);
	    }

	    // Draw the horizontal lines:
	    for (int y=0; y<=240; y+=30) {
	      g.drawLine (0,y, 240,y);
	    }
	  }
	}