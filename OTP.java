import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class OTP extends JFrame implements ActionListener
{
int i=0;
BalanceStatement bs;
JLabel l1,l2;
JTextField t1;
JButton b1;
Authentication obj;
String otp,accno,classname;
OTP(String s1,String s2,String s3,Authentication obj1)
{
otp=s1;
accno=s2;
classname=s3;
obj=obj1;
setIconImage(new ImageIcon("post-office.png").getImage());
setLocationRelativeTo(null);
setResizable(false);
setLayout(new FlowLayout());
l1=new JLabel("Enter the OTP : ");
t1=new JTextField(20);
b1=new JButton("Enter");
b1.addActionListener(this);
add(l1);
add(t1);
add(b1);
setTitle("OTP");
setSize(400,200);
setVisible(true);
while(true)
{
i++;
try
{
Thread.sleep(1000);
}
catch(Exception e)
{
System.out.println(e);
}
}
}
public void actionPerformed(ActionEvent ae)
{
if(t1.getText().equals(otp))
{
if(i<=300)
{
if(classname.equals("Balance"))
{
bs=new BalanceStatement(accno);
setVisible(false);
obj.setVisible(false);
}
else if(classname.equals("Deposite"))
{
Deposite dp=new Deposite(accno);
setVisible(false);
obj.setVisible(false);
}
else if(classname.equals("Withdraw"))
{
Withdraw wd=new Withdraw(accno);
setVisible(false);
obj.setVisible(false);
}
}
else
{
if(l2!=null)
{
l2.hide();
}
l2=new JLabel("Time Out!!");
add(l2);
}
}
else
{
if(l2!=null)
{
l2.hide();
}
l2=new JLabel("Invalid OTP");
add(l2);
}
}
public static void main(String str[])
{
//new OTP();
}
}