import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Withdraw extends JFrame implements ActionListener
{
int a,b,c;
Processing pros;
JButton b1,b2,b3,b4,b5;
JLabel ttl,logo,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l22;
JTextField  t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
JPanel pan;
String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,wit,s1,s2;
Connection con;
Statement st;
ResultSet rs,rs1;
Color clr;
int x=0,y=0,w=0,h=0;
public Withdraw(String wit)
{
setIconImage(new ImageIcon("post-office.png").getImage());
this.wit=wit;
Toolkit tk=Toolkit.getDefaultToolkit();
Dimension dim=tk.getScreenSize();
setLayout(new FlowLayout());
setExtendedState(JFrame.MAXIMIZED_BOTH);
setSize(dim.width,dim.height);
setTitle("Withdraw");
int fw=getWidth();
int fh=getHeight();
pan=new JPanel();
pan.setLayout(null);
pan.setPreferredSize(new Dimension(fw+0,fh+0));
clr=new Color(207,207,207);
//clr=new Color(135,95,1);
pan.setBackground(clr);
ttl=new JLabel("<html><h1 style="+"'text-align:center; font-family:Franklin Gothic Demi;'"+">MONEY WITHDRAW FORM</h1></html>");
logo=new JLabel("<html><img src="+"'D:/santhosh/project/logo.jpg'"+"></html>");
//<div style="+"'display:flex; width:100%; height:100%;'"+"></div>
l1=new JLabel("Account type :-");
l2=new JLabel("Post Office");
l3=new JLabel("Transaction ID :");
l4=new JLabel("Account Number");
l5=new JLabel("Name of the Account Holder :");
l6=new JLabel("Pay into the credit of Mr. / Mrs. /Ms. ");
l7=new JLabel("Rupees (in words)");
l8=new JLabel("Rupees (in Numbers)");
l9=new JLabel("<html><i>SB - Savings Account</i></html>");
l10=new JLabel("<html><i>RD - Recurring Deposit</i></html>");
l11=new JLabel("<html><i style="+"' letter-spacing:1.5px;'"+">MIS - Monthly Income Scheme </i></html>");
l12=new JLabel("<html><i>SCSS - Senior Citizen Saving Scheme</i></html>");
l13=new JLabel("<html><i>PPF - Public Provident Fund</i></html>");
l14=new JLabel("<html><i>SSA - SukanyaSamriddhiAccount</i></html>");
l15=new JLabel("<html><i>TD - Time Deposit (1/2/3/5 year)</i></html>");
l16=new JLabel("<html><i>KVP - KisanVikasPatra</i></html>");
l17=new JLabel("<html><i>NSC - National Savings Certificates VIIIth Issue</i></html>");

t1=new JTextField();
t2=new JTextField("nill");
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();
t6=new JTextField();
t7=new JTextField();
t8=new JTextField();
t9=new JTextField();

b1=new JButton("<html><p style=Color:white;>check</p></html>");
b2=new JButton("submit");

pan.add(logo);
logo.setBounds(x=100,y=30,w=100,h=100);
pan.add(ttl);
ttl.setBounds(x=480,y=50,w=900,h=25);
pan.add(t1);
t1.setBounds(x=200,y+=50,w=200,h=20);
pan.add(l2);
l2.setBounds(x=x+220,y,w=120,h=20);
pan.add(l3);
l3.setBounds(x=x+420,y,w=120,h=20);
pan.add(t2);
t2.setBounds(x=x+130,y,w=200,h=20);
pan.add(l4);
l4.setBounds(x=200,y+=50,w=120,h=20);
pan.add(t3);
t3.setBounds(x=x+130,y,w=150,h=20);
pan.add(l5);
l5.setBounds(x=x+430,y,w=240,h=20);
pan.add(t4);
t4.setBounds(x=x+200,y,w=210,h=20);
pan.add(l6);
l6.setBounds(x=200,y+=50,w=250,h=20);
pan.add(t5);
t5.setBounds(x=x+235,y,w=210,h=20);
pan.add(l7);
l7.setBounds(x=x+230,y,w=150,h=20);
pan.add(t6);
t6.setBounds(x=x+120,y,w=385,h=20);
pan.add(l8);
l8.setBounds(x=200,y+=50,w=150,h=20);
pan.add(t7);
t7.setBounds(x=x+150,y,w=80,h=20);
pan.add(b1);
b1.setBounds(x=x+230,y+=50,w=80,h=25);
b1.addActionListener(this);
b1.setBackground(Color.red);
pan.add(b2);
b2.setBounds(x,y+=50,w=80,h=25);
b2.addActionListener(this);
b2.setEnabled(false);
pan.add(l9);
l9.setBounds(x=200,y+=100,w=300,h=20);
pan.add(l10);
l10.setBounds(x+=250,y,w=300,h=20);
pan.add(l11);
l11.setBounds(x+=250,y,w=400,h=20);
pan.add(l12);
l12.setBounds(x+=250,y,w=400,h=20);
pan.add(l13);
l13.setBounds(x=200,y+=30,w=400,h=20);
pan.add(l14);
l14.setBounds(x+=250,y,w=400,h=20);
pan.add(l15);
l15.setBounds(x+=250,y,w=400,h=20);
pan.add(l16);
l16.setBounds(x+=250,y,w=400,h=20);


l2.setFont(new Font("sans",Font.BOLD,13));
l3.setFont(new Font("sans",Font.BOLD,13));
l4.setFont(new Font("sans",Font.BOLD,13));
l5.setFont(new Font("sans",Font.BOLD,13));
l6.setFont(new Font("sans",Font.BOLD,13));
l7.setFont(new Font("sans",Font.BOLD,13));
l8.setFont(new Font("sans",Font.BOLD,13));
l9.setFont(new Font("sans",Font.BOLD,11));
l10.setFont(new Font("sans",Font.BOLD,11));
l11.setFont(new Font("sans",Font.BOLD,11));
l12.setFont(new Font("sans",Font.BOLD,11));
l13.setFont(new Font("sans",Font.BOLD,11));
l14.setFont(new Font("sans",Font.BOLD,11));
l15.setFont(new Font("sans",Font.BOLD,11));
l16.setFont(new Font("sans",Font.BOLD,11));
l17.setFont(new Font("sans",Font.BOLD,11));
add(pan);
setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String s1="";
String  s2;
s2=t1.getText();
if(s1.equals(s2)==true)
{
t1.setBorder(BorderFactory.createLineBorder(Color.red));
b2.setEnabled(false);
}
else
{
t1.setBorder(BorderFactory.createLineBorder(Color.green));
b2.setEnabled(true);
b2.setBackground(Color.green);
t2.setBorder(BorderFactory.createLineBorder(Color.black));
}

s2=t2.getText();
if(s1.equals(s2)==true)
{
t2.setBorder(BorderFactory.createLineBorder(Color.red));
b2.setEnabled(false);
}
else
{
t2.setBorder(BorderFactory.createLineBorder(Color.green));
b2.setEnabled(true);
b2.setBackground(Color.green);
t2.setBorder(BorderFactory.createLineBorder(Color.black));
}

s2=t3.getText();
if(s1.equals(s2)==true)
{
t3.setBorder(BorderFactory.createLineBorder(Color.red));
b2.setEnabled(false);
}
else
{
t3.setBorder(BorderFactory.createLineBorder(Color.green));
b2.setEnabled(true);
b2.setBackground(Color.green);
t2.setBorder(BorderFactory.createLineBorder(Color.black));
}

s2=t4.getText();
if(s1.equals(s2)==true)
{
t4.setBorder(BorderFactory.createLineBorder(Color.red));
b2.setEnabled(false);
}
else
{
t4.setBorder(BorderFactory.createLineBorder(Color.green));
b2.setEnabled(true);
b2.setBackground(Color.green);
t2.setBorder(BorderFactory.createLineBorder(Color.black));
}

s2=t5.getText();
if(s1.equals(s2)==true)
{
t5.setBorder(BorderFactory.createLineBorder(Color.red));
b2.setEnabled(false);
}
else
{
t5.setBorder(BorderFactory.createLineBorder(Color.green));
b2.setEnabled(true);
b2.setBackground(Color.green);
t2.setBorder(BorderFactory.createLineBorder(Color.black));
}

s2=t6.getText();
if(s1.equals(s2)==true)
{
t6.setBorder(BorderFactory.createLineBorder(Color.red));
b2.setEnabled(false);
}
else
{
t6.setBorder(BorderFactory.createLineBorder(Color.green));
b2.setEnabled(true);
b2.setBackground(Color.green);
t2.setBorder(BorderFactory.createLineBorder(Color.black));
}

s2=t7.getText();
if(s1.equals(s2)==true)
{
t7.setBorder(BorderFactory.createLineBorder(Color.red));
b2.setEnabled(false);
}
else
{
t7.setBorder(BorderFactory.createLineBorder(Color.green));
b2.setEnabled(true);
b2.setBackground(Color.green);
t2.setBorder(BorderFactory.createLineBorder(Color.black));
}
}
if(ae.getSource()==b2)
{
str1=t1.getText();//postOffice
str2=t2.getText();//TransID
str3=t3.getText();//Ac No
str4=t4.getText();
str5=t5.getText();//Holder Name
str6=t6.getText();//amount words
str7=t7.getText();
//int a=Integer.parseInt(str7);//amount number
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("JDBC:ODBC:info","","");
st=con.createStatement();

rs=st.executeQuery("select * from info where acc_no='"+wit+"';");
s1=str7;
rs.next();
s2=rs.getString(3);
if(!(s1.equals("")))
{
a=Integer.parseInt(s1);
if(a>=100)
{
b=Integer.parseInt(s2);
if(a<=b)
{
if(l22!=null)
{
remove(l22);
}
c=b-a;
Date d1=new Date();
String date=(""+(1+d1.getMonth()))+"/"+(""+d1.getDate())+"/"+(""+(1900+d1.getYear()));
String time=""+d1.getHours();
if(Integer.parseInt(time)>=12)
{
time+="pm";
}
else
{
time+="am";
}
w=-a;
st.executeUpdate("update info set balance='"+c+"'where acc_no='"+wit+"';");
st.executeUpdate("insert into Transaction values('"+str3+"','"+str4+"',"+'-'+a+",'"+str6+"','Nill','"+str2+"','"+str1+"');");
st.executeUpdate("insert into b_s values('"+wit+"','"+str4+"','"+date+"','"+time+"',"+w+");");
rs1=st.executeQuery("select * from User_Details where Account_Number='"+wit+"';");
rs1.next();
String emailid=rs1.getString(19);
b1.setEnabled(false);
b2.setEnabled(false);
setDefaultCloseOperation(0);
pros=new Processing();
WithdrawMessage wm=new WithdrawMessage(emailid,wit,str4,a,c,this);
wm.start();
}
else
{
l22.setText("Insufficient Balance!");
add(l22);
}
}
else
{
l22.setText("Please enter the amount above 100");
add(l22);
}
}
else
{
l22.setText("Please enter the amount above 100");
add(l22);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}
public static void main(String str[])
{
new Withdraw("0000005");
}
}