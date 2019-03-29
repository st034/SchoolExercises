import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
	private JButton p1,p2;
	private JTextArea clock, ore, minuti, mode;

	public MyFrame(){
		super("Orologio");
		Container frame=this.getContentPane();
		clock=new JTextArea();
		ore=new JTextArea();
		minuti=new JTextArea();
		mode=new JTextArea();
		p1=new JButton("Set sveglia");
		
		p1.addActionListener(this);
		frame.setLayout(new GridLayout);
		frame.add(clock);
		frame.add(ore);
		frame.add(minuti);
		frame.add(mode);
		frame.add(p1);
		
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		Object s = e.getSource();
		if(s.equals(p1)){
			System.out.println("hola");
		}
	}
	public void print(String s){
		clock.setText(s);
	}
	public static void main(String[] args){
		new MyFrame();
	}
}