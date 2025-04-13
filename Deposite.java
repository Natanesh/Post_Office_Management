import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Deposite extends JFrame implements ActionListener//,ItemListener
{
JButton b1,b2;
Processing pros;
JLabel ttl,logo,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField  t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10;
String sr1,str1,str2,str3,str4,str5,str6,str7,str8,dep,s1;
Connection con;
Statement st;
ResultSet rs,rs1;
ButtonGroup bg;
JPanel pan;
Color clr;
int x=0,y=0,w=0,h=0;
public Deposite(String dep)
{
setIconImage(new ImageIcon("post-office.png").getImage());
this.dep=dep;
Toolkit tk=Toolkit.getDefaultToolkit();
Dimension dim=tk.getScreenSize();
setLayout(new FlowLayout());
setExtendedState(JFrame.MAXIMIZED_BOTH);
setSize(dim.width,dim.height);
setTitle("Deposit");
bg=new ButtonGroup();
int fw=getWidth();
int fh=getHeight();
pan=new JPanel();
pan.setLayout(null);
pan.setPreferredSize(new Dimension(fw+0,fh+0)); 	
clr=new Color(207,207,207);
pan.setBackground(clr);
ttl=new JLabel("<html><h1 style="+"'text-align:center; font-family:Franklin Gothic Demi;'"+">POST OFFICE SAVING BANK</h1></html>");
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
t2=new JTextField("Nill");
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();
t6=new JTextField();
t7=new JTextField();
t8=new JTextField();
t9=new JTextField();

b1=new JButton("check");
b2=new JButton("submit");
cb1=new JCheckBox("SB");
cb2=new JCheckBox("RD");
cb3=new JCheckBox("TD");
cb4=new JCheckBox("MIS");
cb5=new JCheckBox("SCSS");
cb6=new JCheckBox("PPF");
cb7=new JCheckBox("SSA");
cb8=new JCheckBox("KVP");
cb9=new JCheckBox("NSC");
cb10=new JCheckBox("Others");

bg.add(cb1);
bg.add(cb2);
bg.add(cb3);
bg.add(cb4);
bg.add(cb5);
bg.add(cb6);
bg.add(cb7);
bg.add(cb8);
bg.add(cb9);
bg.add(cb10);

pan.add(logo);
logo.setBounds(x=100,y=30,w=100,h=100);
pan.add(ttl);
ttl.setBounds(x=480,y=50,w=900,h=25);
pan.add(cb1);
cb1.setBounds(x=200,y+=100,w=100,h=20);
pan.add(cb2);
cb2.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb3);
cb3.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb4);
cb4.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb5);
cb5.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb6);
cb6.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb7);
cb7.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb8);
cb8.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb9);
cb9.setBounds(x=x+100,y,w=100,h=20);
pan.add(cb10);
cb10.setBounds(x=x+100,y,w=70,h=20);
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
t7.setBounds(x=x+140,y,w=80,h=20);

pan.add(b1);
b1.setBounds(x=x+310,y+=50,w=80,h=25);
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

if(cb1.isSelected())
{
cb2.setEnabled(false);
}

cb1.setFont(new Font("sans",Font.BOLD,13));
cb2.setFont(new Font("sans",Font.BOLD,13));
cb3.setFont(new Font("sans",Font.BOLD,13));
cb4.setFont(new Font("sans",Font.BOLD,13));
cb5.setFont(new Font("sans",Font.BOLD,13));
cb6.setFont(new Font("sans",Font.BOLD,13));
cb7.setFont(new Font("sans",Font.BOLD,13));
cb8.setFont(new Font("sans",Font.BOLD,13));
cb9.setFont(new Font("sans",Font.BOLD,13));
cb10.setFont(new Font("sans",Font.BOLD,13));
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
//System.out.println("Hello");
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
}
}
if(ae.getSource()==b2)
{
if(cb1.isSelected())
{
sr1=cb1.getLabel();
}
if(cb2.isSelected())
{
sr1=cb2.getLabel();
}
if(cb3.isSelected())
{
sr1=cb3.getLabel();
}
if(cb4.isSelected())
{
sr1=cb4.getLabel();
}
if(cb5.isSelected())
{
sr1=cb5.getLabel();
}
if(cb6.isSelected())
{
sr1=cb6.getLabel();
}
if(cb7.isSelected())
{
sr1=cb7.getLabel();
}
if(cb8.isSelected())
{
sr1=cb8.getLabel();
}
if(cb9.isSelected())
{
sr1=cb9.getLabel();
}
if(cb10.isSelected())
{
sr1=cb10.getLabel();//ac type
}
str1=t1.getText();//postOffice
str2=t2.getText();//TransID
str3=t3.getText();//Ac No
str4=t4.getText();
str5=t5.getText();//Holder Name
str6=t6.getText();//amount words
str7=t7.getText();
int a=Integer.parseInt(str7);//amount number
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("JDBC:ODBC:info","","");
st=con.createStatement();
rs=st.executeQuery("select * from info where acc_no='"+dep+"';");
while(rs.next())
{
s1=rs.getString(3);
}
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
s1=""+(Integer.parseInt(s1)+a);
st.executeUpdate("update info set balance='"+s1+"' where acc_no='"+dep+"';");
st.executeUpdate("insert into Transaction values('"+str3+"','"+str4+"',"+a+",'"+str6+"','"+sr1+"','"+str2+"','"+str1+"');");
st.executeUpdate("insert into b_s values('"+dep+"','"+str4+"','"+date+"','"+time+"',"+a+");");
rs1=st.executeQuery("select * from User_Details where Account_Number='"+dep+"';");
rs1.next();
String emailid=rs1.getString(19);
b1.setEnabled(false);
b2.setEnabled(false);
setDefaultCloseOperation(0);
pros=new Processing();
DepositeMessage dm=new DepositeMessage(emailid,dep,str4,a,Integer.parseInt(s1),this);
dm.start();
}
catch(Exception e)
{
System.out.println(e);
}
}
}
public static void main(String str[])
{
new Deposite("0000005");
}
}	