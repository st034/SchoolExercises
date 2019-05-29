import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calcolatrice extends JFrame implements ActionListener
{
    private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bAdd,bSub,bMul,bDiv,bEq,bCanc;
    private Container mainC;
    public Calcolatrice()
    {
        super("Calcolatrice");
        setSize(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainC = getContentPane();
        mainC.setLayout(new BorderLayout());
        show(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setState(Frame.ICONIFIED);
    }
}

