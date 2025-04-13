import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Authentication extends JFrame implements ActionListener
{
int n=0;
EM e1;
String s1;
public static JLabel l1,l2,l3,l4,ll1,ll2,ll12,pro,acc,title;
Processing pros;
JTextField t1,t2;
public static JButton b1;
Connection con;
Statement st;
ResultSet rs;
JPanel p1,p2;
Authentication(String s1)
{
try
{
setIconImage(new ImageIcon("post-office.png").getImage());
this.s1=s1;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("JDBC:ODBC:info","","");
st=con.createStatement();
setLayout(null);
setTitle("User Login");
setExtendedState(JFrame.MAXIMIZED_BOTH);
setVisible(true);
p1=new JPanel();
p2=new JPanel();
ll1=new JLabel("Contact");
ll12=new JLabel("|");
ll2=new JLabel("Help & Support");
l1=new JLabel("Account No : ");
t1=new JTextField(20);
t2=new JTextField(20);
b1=new JButton("Get OTP");
pro=new JLabel(new ImageIcon(new ImageIcon("post-office.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT)));
acc=new JLabel(new ImageIcon(new ImageIcon("user (4).png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT)));
title=new JLabel("POST OFFICE");
title.setFont(new Font("",Font.BOLD,50));
b1.addActionListener(this);
b1.setBackground(Color.green);
add(l1);
add(t1);
add(b1);
l1.setBounds((getWidth()/2)-180,(getHeight()/2)-100,200,25);
t1.setBounds((getWidth()/2)-100,(getHeight()/2)-100,200,25);
b1.setBounds((getWidth()/2)-50,(getHeight()/2)-50,100,25);
p1.setBounds(0,(getHeight()-100),getWidth(),100);
p1.setLayout(null);
p1.add(ll1);
p1.add(ll12);
p1.add(ll2);
p2.setBounds(0,0,getWidth(),80);
p2.setLayout(null);
p2.add(pro);
p2.add(acc);
p2.add(title);
add(p1);
add(p2);
p2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
p1.setBackground(Color.BLACK);
pro.setBounds(10,(p2.getHeight()/2)-30,50,50);
acc.setBounds((p2.getWidth()-80),(p2.getHeight()/2)-30,50,50);
title.setBounds((p2.getWidth()/2)-200,(p2.getHeight()/2)-40,p2.getWidth(),p2.getHeight());
ll1.setBounds((p1.getWidth()-250),(p1.getHeight()/2)-30,50,20);
ll12.setBounds((p1.getWidth()-193),(p1.getHeight()/2)-30,50,20);
ll2.setBounds((p1.getWidth()-175),(p1.getHeight()/2)-30,100,20);
ll1.setForeground(Color.white);
ll12.setForeground(Color.white);
ll2.setForeground(Color.white);
}
catch(Exception e)
{
System.out.println(e);
}
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
if(l4!=null)
{
l4.hide();
}
rs=st.executeQuery("select * from User_Details where Account_Number='"+t1.getText()+"';");
rs.next();
String accno=rs.getString(4);
String emailid=rs.getString(19);
if(accno.equals(""+t1.getText()))
{
if(s1.equals("Balance"))
{
pros=new Processing();
setDefaultCloseOperation(0);
b1.setEnabled(false);
EM e1=new EM(emailid,this);
e1.start();
String otp=e1.getOtp();
//BalanceStatement o1=new BalanceStatement(t1.getText());
}
else if(s1.equals("Deposite"))
{
pros=new Processing();
setDefaultCloseOperation(0);
b1.setEnabled(false);
e1=new EM(emailid,this);
e1.start();
String otp=e1.getOtp();
//Deposite o2=new Deposite(t1.getText());
}
else if(s1.equals("Withdraw"))
{
pros=new Processing();
setDefaultCloseOperation(0);
b1.setEnabled(false);
EM e1=new EM(emailid,this);
e1.start();
String otp=e1.getOtp();
//Withdraw o3=new Withdraw(t1.getText());
}
}
}
}
catch(Exception e)
{
l4=new JLabel("Invalid Account Number");
add(l4).setBounds((getWidth()/2)-25,(getHeight()/2),200,25);
}
}
/*public static void dis()
{
pros.setVisible(false);
}*/
public static void main(String str[])
{
new Authentication("Balance");
}
}