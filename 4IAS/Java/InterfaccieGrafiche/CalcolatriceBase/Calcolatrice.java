import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class Calcolatrice extends JFrame
{   private Container mainFrame;
    private Container textContainer, resultFrame, buttonFrame;
    private JTextField a,b, result;
    private JLabel aLabel, bLabel;
    private JButton button;
    private final int width = 400;
    private final int height = 400;
    
    public Calcolatrice()
    {
        super("Calcolatrice");
        setSize(width,height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mainFrame = getContentPane();
        mainFrame.setLayout(new BorderLayout());
        
        textContainer = new Container();
        textContainer.setLayout(new FlowLayout());
        
        mainFrame.add(textContainer, BorderLayout.NORTH);
        
        aLabel = new JLabel("A", JLabel.CENTER);
        bLabel = new JLabel("B", JLabel.CENTER);
        
        a = new JTextField(10);
        b = new JTextField(10);
        result = new JTextField(100);

        textContainer.add(aLabel);
        textContainer.add(a);
        textContainer.add(Box.createHorizontalGlue());
        textContainer.add(bLabel);
        textContainer.add(b);
        
        button = new JButton("Calculate");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    int valueA = Integer.parseInt(a.getText());
                    int valueB = Integer.parseInt(b.getText());
                    result.setText("" + (valueA + valueB));
                }catch(Exception e)
                {
                    result.setText("Please, insert valid arguments");
                }   
            }
        });
        
        //result.setBounds((width-100)/2, (height-200)/2, 100, 200);
        //button.setBounds((width-100)/2, 0, 100, 25);
        
        resultFrame = new Container();
        buttonFrame = new Container();
        
        mainFrame.add(Box.createRigidArea(new Dimension(50,50)), BorderLayout.WEST);
        mainFrame.add(Box.createRigidArea(new Dimension(50,50)), BorderLayout.EAST);
        //resultFrame.add(result);
        
        //buttonFrame.add(button);
        
        mainFrame.add(result, BorderLayout.CENTER);
        mainFrame.add(button, BorderLayout.SOUTH);

        
        show();
    }
}
