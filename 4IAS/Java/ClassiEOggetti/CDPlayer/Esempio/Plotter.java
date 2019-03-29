import javax.swing.JFrame;

public class Plotter
{
  int[] arrayInt;
  
  Plotter(int[] arrayInt) {
    this.arrayInt = arrayInt;
  }
  
















  public void showWave()
  {
    JFrame frame = new JFrame();
    javax.swing.JPanel panel = new javax.swing.JPanel();
    javax.swing.JScrollPane jscrollpane = new javax.swing.JScrollPane(new Plotter.MyGraphics(this));
    frame.add(jscrollpane);
    frame.setSize(new java.awt.Dimension(2000, 600));
    frame.setVisible(true);
    frame.setDefaultCloseOperation(2);
  }
}
