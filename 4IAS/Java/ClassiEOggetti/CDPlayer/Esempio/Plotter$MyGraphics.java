import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;







public class Plotter$MyGraphics
  extends JComponent
{
  Plotter$MyGraphics(Plotter this$0)
  {
    setPreferredSize(new Dimension(2000, 600));
  }
  
  public void paint(Graphics g)
  {
    for (int i = 44; i < this$0.arrayInt.length - 1; i++) {
      g.drawLine(i, this$0.arrayInt[i] + 200, i + 1, this$0.arrayInt[(i + 1)] + 200);
    }
  }
}
