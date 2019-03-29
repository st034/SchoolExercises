import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
	private JButton p1,p2;

	public MyFrame(){
		super("TestFrame");
		Container frame=this.getContentPane();
		frame.setLayout(new FlowLayout());
		p1=new JButton("ahlo");
		p1.addActionListener(this);
		p2=new JButton("hlao");
		p2.addActionListener(this);
		frame.add(p1);
		frame.add(p2);
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		Object s = e.getSource();
		if(s.equals(p1)){
			System.out.println("hola");
		}
		if(s.equals(p2)){
			System.out.println("aloh");
		}
	}
	public static void main(String[] args){
		new MyFrame();
	}
}