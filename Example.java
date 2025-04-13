import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
class Example extends JFrame implements ActionListener
{
JTable tb1;
int l;
JTextArea ta1;
String ds1,ds2,type;
int x=400,y=150,w=80,h=20,a,b,st1,en1,st2,en2;
JLabel l1,l2,l3;
JButton b1,b2;
JScrollPane sr1;
//String data[][]={{"1","2","3","4","5"},{"1","2","3","4","5"},{"1","2","3","4","5"},{"1","2","3","4","5"}};
String title[]={"Account No","Holder Name","Date","Time","Transfer"};
JComboBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
String s[]={"All","Account","Deposit","Withdraw","Loan","Insurance"};
String s1[]={"DD","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
String s2[]={"MM","01","02","03","04","05","06","07","08","09","10","11","12"};
String s3[]={"YYYY","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024"};
Connection con;
Statement st;
ResultSet rs;
Example() throws Exception
{
setIconImage(new ImageIcon("post-office.png").getImage());
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("JDBC:ODBC:info","","");
st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
setTitle("History");
setVisible(true);
setLayout(null);
setSize(400,400);
setIconImage(new ImageIcon("E:/post-office.png").getImage());
setExtendedState(JFrame.MAXIMIZED_BOTH);
b1=new JButton("Ok");
cb1=new JComboBox(s);
cb2=new JComboBox(s1);
cb3=new JComboBox(s2);
cb4=new JComboBox(s3);
cb5=new JComboBox(s1);
cb6=new JComboBox(s2);
cb7=new JComboBox(s3);
l1=new JLabel("From:");
l2=new JLabel("To:");
l3=new JLabel("Type");
add(cb1);
add(cb2);
add(cb3);
add(cb4);
add(cb5);
add(cb6);
add(cb7);
add(b1);
add(l1);
add(l2);
add(l3);
b1.addActionListener(this);
cb1.addActionListener(this);
cb2.addActionListener(this);
cb3.addActionListener(this);
cb4.addActionListener(this);
cb5.addActionListener(this);
cb6.addActionListener(this);
cb7.addActionListener(this);
a=getContentPane().getWidth();
b=getContentPane().getHeight();
l1.setBounds(x,y,w,h);
cb4.setBounds(x+=35,y,60,h);
cb3.setBounds(x+=60,y,50,h);
cb2.setBounds(x+=50,y,50,h);
l2.setBounds(x+=65,y,w,h);
cb7.setBounds(x+=20,y,60,h);
cb6.setBounds(x+=60,y,50,h);
cb5.setBounds(x+=50,y,50,h);
l3.setBounds(x+=65,y,w,h);
cb1.setBounds(x+=35,y,85,h);
b1.setBounds(600,200,80,25);
cb2.setEnabled(false);
cb3.setEnabled(false);
cb5.setEnabled(false);
cb6.setEnabled(false);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
try
{
if(!((""+cb4.getSelectedItem()).equals("YYYY"))&&!((""+cb3.getSelectedItem()).equals("MM"))&&!((""+cb2.getSelectedItem()).equals("DD"))&&!((""+cb7.getSelectedItem()).equals("YYYY"))&&!((""+cb6.getSelectedItem()).equals("MM"))&&!((""+cb5.getSelectedItem()).equals("DD")))
{
ds1=""+cb4.getSelectedItem()+"/"+cb3.getSelectedItem()+"/"+cb2.getSelectedItem();
ds2=""+cb7.getSelectedItem()+"/"+cb6.getSelectedItem()+"/"+cb5.getSelectedItem();
type=String.valueOf(cb1.getSelectedItem());
//rs=st.executeQuery("select * from b_s where date >= #2024-04-03# and date <= #2024-04-04#;");
if(type.equals("All"))
{
rs=st.executeQuery("select * from b_s where date >= cdate('"+ds1+"') and date <= cdate('"+ds2+"');");
}
else if(type.equals("Deposit"))
{
rs=st.executeQuery("select * from b_s where amount>0 and date >= cdate('"+ds1+"') and date <= cdate('"+ds2+"');");
}
else if(type.equals("Withdraw"))
{
rs=st.executeQuery("select * from b_s where amount<0 and date >= cdate('"+ds1+"') and date <= cdate('"+ds2+"');");
}
rs.last();
l=rs.getRow();
String data[][];
if(l!=0)
{
data=new String[l][5];
}
else
{
data=new String[1][5];
}
rs.beforeFirst();
int x=0;
while(rs.next())
{
data[x][0]=rs.getString(1);
data[x][1]=rs.getString(2);
String sut1[]=rs.getString(3).split(" ");
data[x][2]=sut1[0];
String sut2[]=rs.getString(4).split(" ");
data[x][3]=sut2[1];
data[x][4]=rs.getString(5);
x++;
}
if(l==0)
{
data[0][0]="";
data[0][1]="";
data[0][2]="No Such Record";
data[0][3]="";
data[0][4]="";
}
tb1=new JTable(data,title);
tb1.setShowGrid(false);
if(l!=0)
{
tb1.setRowHeight(20);
}
else
{
tb1.setRowHeight(350);
}
tb1.getTableHeader().setBorder(null);
tb1.getTableHeader().setBackground(Color.black);
tb1.getTableHeader().setForeground(Color.white);
DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
dtcr.setHorizontalAlignment(JLabel.CENTER);
for(int i=0;i<title.length;i++)
{
tb1.getColumnModel().getColumn(i).setCellRenderer(dtcr);
}
sr1=new JScrollPane(tb1);
add(sr1);
sr1.setBorder(null);
sr1.setBounds(125,300,1100,400);
sr1.getViewport().setBackground(Color.white);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(ae.getSource()==cb4)
{
if(!((String.valueOf(cb4.getSelectedItem())).equals("YYYY")))
{
st1=Integer.parseInt(s3[1]);
en1=Integer.parseInt(String.valueOf(cb4.getSelectedItem()));
cb3.setEnabled(true);
if(cb3.getSelectedItem()!="MM")
{
String si=""+cb2.getItemAt(cb2.getItemCount()-1);
int mm=Integer.parseInt(String.valueOf(cb3.getSelectedItem()));
switch(mm)
{
case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12:
if(si.equals("28"))
{
cb2.addItem("29");
cb2.addItem("30");
cb2.addItem("31");
}
else if(si.equals("29"))
{
cb2.addItem("30");
cb2.addItem("31");
}
else if(si.equals("30"))
{
cb2.addItem("31");
}
break;
case 4:
case 6:
case 9:
case 11:
if(si.equals("31"))
{
cb2.removeItem("31");
}
else if(si.equals("28"))
{
cb2.addItem("29");
cb2.addItem("30");
}
else if(si.equals("29"))
{
cb2.addItem("30");
}
break;
case 2:
if((en1-st1)%4==0)
{
if(si.equals("28"))
{
cb2.addItem("29");
}
cb2.removeItem("31");
cb2.removeItem("30");
}
else
{
cb2.removeItem("31");
cb2.removeItem("30");
cb2.removeItem("29");
}
break;
}
cb2.setEnabled(true);
}
}
else
{
cb3.setSelectedItem("MM");
cb3.setEnabled(false);
cb2.setSelectedItem("DD");
cb2.setEnabled(false);
}
}
else if(ae.getSource()==cb3)
{
if(cb3.getSelectedItem()!="MM")
{
String si=""+cb2.getItemAt(cb2.getItemCount()-1);
int mm=Integer.parseInt(String.valueOf(cb3.getSelectedItem()));

switch(mm)
{
case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12:
if(si.equals("28"))
{
cb2.addItem("29");
cb2.addItem("30");
cb2.addItem("31");
}
else if(si.equals("29"))
{
cb2.addItem("30");
cb2.addItem("31");
}
else if(si.equals("30"))
{
cb2.addItem("31");
}
break;
case 4:
case 6:
case 9:
case 11:
if(si.equals("31"))
{
cb2.removeItem("31");
}
else if(si.equals("28"))
{
cb2.addItem("29");
cb2.addItem("30");
}
else if(si.equals("29"))
{
cb2.addItem("30");
}
break;
case 2:
if((en1-st1)%4==0)
{
if(si.equals("28"))
{
cb2.addItem("29");
}
cb2.removeItem("31");
cb2.removeItem("30");
}
else
{
cb2.removeItem("31");
cb2.removeItem("30");
cb2.removeItem("29");
}
break;
}
cb2.setEnabled(true);
}
else
{
cb2.setSelectedItem("DD");
cb2.setEnabled(false);
}
}
else if(ae.getSource()==cb7)
{
if(!((String.valueOf(cb7.getSelectedItem())).equals("YYYY")))
{
st1=Integer.parseInt(s3[1]);
en1=Integer.parseInt(String.valueOf(cb7.getSelectedItem()));
cb6.setEnabled(true);
if(cb6.getSelectedItem()!="MM")
{
String si=""+cb5.getItemAt(cb5.getItemCount()-1);
int mm=Integer.parseInt(String.valueOf(cb6.getSelectedItem()));
switch(mm)
{
case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12:
if(si.equals("28"))
{
cb5.addItem("29");
cb5.addItem("30");
cb5.addItem("31");
System.out.println("Hi1");
}
else if(si.equals("29"))
{
cb5.addItem("30");
cb5.addItem("31");
System.out.println("Hi2");
}
else if(si.equals("30"))
{
cb5.addItem("31");
System.out.println("Hi3");
}
break;
case 4:
case 6:
case 9:
case 11:
if(si.equals("31"))
{
cb5.removeItem("31");
}
else if(si.equals("28"))
{
cb5.addItem("29");
cb5.addItem("30");
}
else if(si.equals("29"))
{
cb5.addItem("30");
}
break;
case 2:
if((en1-st1)%4==0)
{
if(si.equals("28"))
{
cb5.addItem("29");
}
cb5.removeItem("31");
cb5.removeItem("30");
}
else
{
cb5.removeItem("31");
cb5.removeItem("30");
cb5.removeItem("29");
}
break;
}
cb5.setEnabled(true);
}
}
else
{
cb6.setSelectedItem("MM");
cb6.setEnabled(false);
cb5.setSelectedItem("DD");
cb5.setEnabled(false);
}
}
else if(ae.getSource()==cb6)
{
if(cb6.getSelectedItem()!="MM")
{
String si=""+cb5.getItemAt(cb5.getItemCount()-1);
int mm=Integer.parseInt(String.valueOf(cb6.getSelectedItem()));
switch(mm)
{
case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12:
if(si.equals("28"))
{
cb5.addItem("29");
cb5.addItem("30");
cb5.addItem("31");
}
else if(si.equals("29"))
{
cb5.addItem("30");
cb5.addItem("31");
}
else if(si.equals("30"))
{
cb5.addItem("31");
}
break;
case 4:
case 6:
case 9:
case 11:
if(si.equals("31"))
{
cb5.removeItem("31");
}
else if(si.equals("28"))
{
cb5.addItem("29");
cb5.addItem("30");
}
else if(si.equals("29"))
{
cb5.addItem("30");
}
break;
case 2:
if((en1-st1)%4==0)
{
if(si.equals("28"))
{
cb5.addItem("29");
}
cb5.removeItem("31");
cb5.removeItem("30");
}
else
{
cb5.removeItem("31");
cb5.removeItem("30");
cb5.removeItem("29");
}
break;
}
cb5.setEnabled(true);
}
else
{
cb5.setSelectedItem("DD");
cb5.setEnabled(false);
}
}
}
public static void main(String str[]) throws Exception
{
new Example();
}
}