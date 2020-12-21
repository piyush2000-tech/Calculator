import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class calculator implements ActionListener 
{
	String str[]={"1","2","3","4","5","6","7","8","9","0","+","-","*","/",".","=","C","<-","ON"};
	JFrame fr;
	JButton but[];
	JTextField t1;
	Image img;
	int x=10,y=60,z=1,cnt=0,p=0,op=0;
	double a,b,c;
	
	public calculator()
	{
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame("Calculator");
		fr.setBounds((dim.width-320)/2,(dim.height-325)/2,320,325);
		fr.setLayout(null);
		fr.setContentPane(new JLabel(new ImageIcon("images/back1.png")));
		img=Toolkit.getDefaultToolkit().getImage("images/calc5.png");
		fr.setIconImage(img);
		
		t1 = new JTextField();
		t1.setBounds(10,10,285,35);
		t1.setFont(new Font("verdana",Font.BOLD|Font.ITALIC,25));
		t1.setForeground(Color.green);
		t1.setCaretColor(Color.green);
		t1.setEditable(false);
		fr.add(t1);
		
		but=new JButton[19];
		for(int i=0;i<but.length;i++)
		{
			but[i]=new JButton(str[i]);
			but[i].setForeground(Color.blue);
			but[i].setFont(new Font("plain",Font.BOLD,25));
			but[i].setBounds(x,y,85,30);
			but[i].addActionListener(this);
			but[i].setEnabled(false);
			fr.add(but[i]);
			if(z<4)
			{
				x=x+65;
				z++;
			}
			else
			{
				y=y+40;
				x=10;
				z=1;
			}
			
		}
		but[but.length-1].setEnabled(true);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String ss=ae.getActionCommand();
	
		if(!(ss.equals("+")||ss.equals("/")||ss.equals("*")||ss.equals("=")||ss.equals("C")||ss.equals("<-")||ss.equals("ON")||ss.equals("OFF")))
		{
			if(cnt<12)
			{
				if(ss.equals(".")&&p==0)
				{
					if(t1.getText().indexOf(".")==-1)
					{
						t1.setText(t1.getText()+ss);
						p=1;
						cnt++;
					}
				}
				else
				{
					if(!ss.equals("."))
					{	
						if(ss.equals("-")&&t1.getText().length()==0)
						{
							t1.setText("-");
						}
						else
						{
							if(!ss.equals("-"))
							{
								t1.setText(t1.getText()+ss);
								cnt++;
							}
						}
					}
				}
			}
		}
		if(ss.equals("+"))
		{	
			try
			{
				a=Double.parseDouble(t1.getText());	
				t1.setText("");
				op=1;
				cnt=0;
				p=0;	
			}
			catch(Exception e)
			{}	
		}
		if(ss.equals("-"))
		{	
			try
			{
				a=Double.parseDouble(t1.getText());	
				t1.setText("");
				op=2;
				cnt=0;
				p=0;	
			}
			catch(Exception e)
			{}	
		}
		if(ss.equals("*"))
		{	
			try
			{
				a=Double.parseDouble(t1.getText());	
				t1.setText("");
				op=3;
				cnt=0;
				p=0;	
			}
			catch(Exception e)
			{}	
		}
		if(ss.equals("/"))
		{	
			try
			{
				a=Double.parseDouble(t1.getText());	
				t1.setText("");
				op=4;
				cnt=0;
				p=0;	
			}
			catch(Exception e)
			{}	
		}
		if(ss.equals("="))
		{
			try
			{
				b=Double.parseDouble(t1.getText());
				if(op==1)
				{
					c=a+b;
				}
				else if(op==2)
				{
					c=a-b;
				}
				else if(op==3)
				{
					c=a*b;
				}
				if(op==4)
				{
					c=a/b;
				}
				t1.setText(""+c);
				
			}
			catch(Exception e)
			{}	
		}
		if(ss.equals("ON"))
		{
			for(int i=0;i<but.length-1;i++)
			{
				but[i].setEnabled(true);
			}
			but[but.length-1].setLabel("OFF");	
		}
		else if(ss.equals("OFF"))
		{
			for(int i=0;i<but.length-1;i++)
			{
				but[i].setEnabled(false);
			}
			but[but.length-1].setLabel("ON");
			a=0;
			b=0;
			c=0;
			cnt=0;
			p=0;
			op=0;
			t1.setText("");	
		}
	
		if(ss.equals("C"))
		{
			try
			{
				a=0;
				b=0;
				c=0;
				cnt=0;
				p=0;
				op=0;
				t1.setText("");
			}
			catch(Exception e)
			{}
		}
		if(ss.equals("<-"))
		{
			try
			{
				String s=t1.getText();
				s=s.substring(0,s.length()-1);
				t1.setText(s);
				cnt--;
				if(s.indexOf(".")==-1)
				{
					p=0;
				}
			}
			catch(Exception e)
			{}
		}
	}
	
	public static void main(String args[])
	{
		new calculator();
	}
}