import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
class HS extends JFrame implements ActionListener
{
JButton b1,b2,b3,b4;
HS()
{
setIconImage(new ImageIcon("post-office.png").getImage());
setExtendedState(JFrame.MAXIMIZED_BOTH);
setLayout(null);
setTitle("Help & Support");
setSize(400,400);
setVisible(true);
b1=new JButton("Account Termination");
b2=new JButton("Change Pin");
b3=new JButton("Apply Insurance");
b4=new JButton("Apply Loan");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
add(b1);
add(b2);
add(b3);
add(b4);
b1.setBackground(Color.white);
b2.setBackground(Color.white);
b3.setBackground(Color.white);
b4.setBackground(Color.white);
b1.setBorder(null);
b2.setBorder(null);
b3.setBorder(null);
b4.setBorder(null);
b1.setBounds((getWidth()/2)-100,(getHeight()/2)-150,200,30);
b2.setBounds((getWidth()/2)-100,(getHeight()/2)-100,200,30);
b3.setBounds((getWidth()/2)-100,(getHeight()/2)-50,200,30);
b4.setBounds((getWidth()/2)-100,(getHeight()/2),200,30);
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
Desktop d1=Desktop.getDesktop();
String msg="mailto:santhoshmpr11@gmail.com?subject=Account%20Termination&body=I%20want%20to%20close%20the%20account%20permanently%20Thank%20You%20bye!!";
URI uri=URI.create(msg);
d1.mail(uri);
}
}
catch(Exception e)
{
}
}
public static void main(String str[])
{
new HS();
}
}