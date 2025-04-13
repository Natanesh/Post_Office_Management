import java.awt.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class Employee extends JFrame implements ActionListener
{
Connection con;
Statement st;
ResultSet rs;
JLabel ttl,l1,l2,lb1;
JTextField t1,t2;
JCheckBox cb1,cb2;
JPasswordField pf;
Processing pros;
String s1,s2,s3,s4,s5,user_name,pin,Emp_ID,Userpin;
JLabel star1,star2,star3,star4,star5,star6,star7,star8,star9,star10;
JButton b1,b2;
int x=0,y=0,w=0,h=0;
public Employee()
{
setIconImage(new ImageIcon("post-office.png").getImage());
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
Toolkit tk=Toolkit.getDefaultToolkit();
Dimension dim=tk.getScreenSize();
setSize(dim.width,dim.height);
setExtendedState(JFrame.MAXIMIZED_BOTH);
setLayout(null);
setTitle("Employee Login");
pf=new JPasswordField();
b1=new JButton("Open");
//b2=new JButton("save >");
ttl=new JLabel("");
l1=new JLabel("Employee ID");
l2=new JLabel("password");
lb1=new JLabel("enter the Ac.No and Pin");
t1=new JTextField();
t2=new JTextField();
//add(ttl);
add(l1);
l1.setBounds(x=50,y=60,w=200,h=20);
add(t1);
t1.setBounds(x+=100,y,w,h);
add(l2);
l2.setBounds(x=50,y+=40,w,h);
add(pf);
pf.setBounds(x+=100,y,w,h);
add(lb1);
lb1.setBounds(x+=100,y+=50,w=220,h);
add(b1);
b1.setBounds(x+=100,y+=50,w=80,h);
b1.addActionListener(this);
pf.setLayout(new BorderLayout());
pf.setEchoChar((char)183);
pf.setFont(new Font("sans",Font.BOLD,30));
star1=new JLabel();
star2=new JLabel();
star3=new JLabel();
star4=new JLabel();
star5=new JLabel();
star6=new JLabel();
star7=new JLabel();
star8=new JLabel();
star9=new JLabel();
star10=new JLabel();
add(star1);
star1.setBounds(x+=8,y=y+68,w=10,h=10);
add(star2);
star2.setBounds(x+=8,y=y+2,w=10,h=10);
add(star3);
star3.setBounds(x+=6,y=y+6,w=10,h=10);
add(star4);
star4.setBounds(x,y=y+8,w=10,h=10);
add(star5);
star5.setBounds(x-=4,y=y+8,w=10,h=10);
add(star6);
star6.setBounds(x-=8,y+=2,w=10,h=10);
add(star7);
star7.setBounds(x-=8,y-=2,w=10,h=10);
add(star8);
star8.setBounds(x-=6,y-=6,w=10,h=10);
add(star9);
star9.setBounds(x,y-=8,w=10,h=10);
add(star10);
star10.setBounds(x+=4,y-=8,w=10,h=10);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("JDBC:ODBC:info","","");
st=con.createStatement();
rs=st.executeQuery("select * from Employee;"); 
user_name=t1.getText();
pin=pf.getText();
rs=st.executeQuery("select Emp_ID from Employee;");
while(rs.next())
{
s1=rs.getString(1);
if(s1.equals(user_name))
{
rs=st.executeQuery("select Emp_Pin from Employee where Emp_ID='"+s1+"'");
rs.next();
Userpin=rs.getString(1);
break;
}
}
}
catch(Exception e)
{
System.out.println(e);
System.out.println("try again and don't give up");
}
if((user_name.equals(s1))&&(pin.equals(Userpin)))
{
try{
t1.setBorder(BorderFactory.createLineBorder(Color.green));
pf.setBorder(BorderFactory.createLineBorder(Color.green));
lb1.setText("Thank you");
pros=new Processing();
Waiting wt=new Waiting(this);
wt.start();
}
catch(Exception e)
{
System.out.println(e);
}
}
else
{
t1.setText("");
pf.setText("");
t1.setBorder(BorderFactory.createLineBorder(Color.red));
pf.setBorder(BorderFactory.createLineBorder(Color.red));
lb1.setText("Enter Correctly");
}
}
}
public static void main(String str[])
{
new Employee();
}
}