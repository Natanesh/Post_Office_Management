import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
class Info extends JFrame implements ActionListener
{
int x=530,y=230,w=150,h=25,h1,w1,count=0,gh,gw;
JButton b1,b2,b3,b4;
JLabel bg,l1,l2,l12,pro,acc,title,tt1;
JPanel jp1,p1,p2,p3;
Authentication at;
Info()
{
try
{
setIconImage(new ImageIcon("post-office.png").getImage());
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
setExtendedState(JFrame.MAXIMIZED_BOTH);
l1=new JLabel("Contact");
l12=new JLabel("|");
l2=new JLabel("Help & Support");
pro=new JLabel(new ImageIcon(new ImageIcon("post-office.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT)));
acc=new JLabel(new ImageIcon(new ImageIcon("user (4).png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT)));
title=new JLabel("POST OFFICE");
title.setFont(new Font("",Font.BOLD,50));
//tt1=new JLabel("POST OFFICE",Font.BOLD);
p1=new JPanel();
p2=new JPanel();
p3=new JPanel();
b1=new JButton("Check Balance");
b2=new JButton("Deposite");
b3=new JButton("WithDraw");
b4=new JButton("History");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b1.setBackground(Color.white);
b1.setBorderPainted(false);
b2.setBackground(Color.white);
b2.setBorderPainted(false);
b3.setBackground(Color.white);
b3.setBorderPainted(false);
b4.setBackground(Color.white);
b4.setBorderPainted(false);
add(b1);
add(b2);
add(b3);
add(b4);
add(p1);
add(p2);
add(p3);
setLayout(null);
setVisible(true);
setTitle("Information");
b1.setBounds(x,y,w,h);
b2.setBounds(x,y+=50,w,h);
b3.setBounds(x,y+=50,w,h);
b4.setBounds(x,y+=50,w,h);
p1.setBounds(0,(getHeight()-100),getWidth(),100);
p1.setLayout(null);
p1.add(l1);
p1.add(l12);
p1.add(l2);
p1.setBackground(Color.black);
p2.setBounds(0,0,getWidth(),80);
p2.setLayout(null);
p2.add(pro);
p2.add(acc);
p2.add(title);
p2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
p3.setBounds(getWidth()-237,p2.getHeight(),220,300);
p3.setBorder(BorderFactory.createMatteBorder(0,2,2,2,Color.black));
p3.setBackground(Color.white);
p3.setVisible(false);
l1.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
try
{
Desktop d1=Desktop.getDesktop();
String msg="mailto:lokeshanbuselvan@gmail.com";
URI uri=URI.create(msg);
d1.mail(uri);
}
catch(Exception e)
{
}
}
});
l2.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
HS hs=new HS();
}
});
acc.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
if(count%2==0)
{
p3.setVisible(true);
}
else
{
p3.setVisible(false);
}
count++;
}
});
pro.setBounds(10,(p2.getHeight()/2)-30,50,50);
acc.setBounds((p2.getWidth()-80),(p2.getHeight()/2)-30,50,50);
title.setBounds((p2.getWidth()/2)-200,(p2.getHeight()/2)-40,p2.getWidth(),p2.getHeight());
l1.setBounds((p1.getWidth()-250),(p1.getHeight()/2)-30,50,20);
l12.setBounds((p1.getWidth()-193),(p1.getHeight()/2)-30,50,20);
l2.setBounds((p1.getWidth()-175),(p1.getHeight()/2)-30,100,20);
l1.setForeground(Color.white);
l12.setForeground(Color.white);
l2.setForeground(Color.white);
}
catch(Exception e)
{
System.out.println(e);
}
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
Authentication at=new Authentication("Balance");
}
else if(ae.getSource()==b2)
{
Authentication at=new Authentication("Deposite");
}
else if(ae.getSource()==b3)
{
Authentication at=new Authentication("Withdraw");
}
else if(ae.getSource()==b4)
{
try
{
Example ex1=new Example();
}
catch(Exception e)
{
}
}
}
public static void main(String str[])
{
Info o1=new Info();
}
}