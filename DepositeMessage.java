import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.awt.*;
import javax.swing.*;
public class DepositeMessage extends Thread
{
static Deposite obj;
int a,c;
String s1,s2,s3,s4,emailid,dep,str4;
MimeMessage mm;
Properties  pro;
public DepositeMessage()
{
JFrame f1=new JFrame();
f1.setIconImage(new ImageIcon("post-office.png").getImage());
f1.setLayout(new BorderLayout());
f1.setTitle("Deposite Successfully!");
f1.setSize(400,200);
f1.setVisible(true);
f1.setLocationRelativeTo(null);
f1.setResizable(false);
JLabel l1=new JLabel("<html><h1>Deposite Successfully</h1></html>",JLabel.CENTER);
f1.add(l1,BorderLayout.CENTER);
}
public DepositeMessage(String em,String dep,String str4,int a,int c,Deposite obj1)
{
emailid=em;
this.dep=dep;
this.str4=str4;
this.a=a;
this.c=c;
obj=obj1;
}
public void run()
{
s1="nsnatanesh@gmail.com";//from mail
s2=emailid;//to mail
s3="nsol vxpw wndj bilx";//password
s4="Deposite Amount";//subject
pro=new Properties();
pro.put("mail.smtp.auth","true");
pro.put("mail.smtp.starttls.enable","true");
pro.put("mail.smtp.host","smtp.gmail.com");
pro.put("mail.smtp.port","587");
Session ss=Session.getDefaultInstance(pro,new Authenticator()
{
protected PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(s1,s3);
}
});
try
{
mm=new MimeMessage(ss);
mm.setFrom(new InternetAddress(s1));
mm.addRecipient(Message.RecipientType.TO,new InternetAddress(s2));
mm.setSubject(s4);
mm.setText("Account No:"+(dep.substring(0,3)+"XXXX")+"\nAccount Holder Name:"+(str4)+"\nDeposite Amount:"+(a)+"\nBalance:"+(c)+"\nFrom:Post Office\n\tThank You!");
Transport.send(mm);
obj.pros.setVisible(false);
obj.setVisible(false);
new DepositeMessage();
}
catch(Exception e)
{
System.out.println(e);
}
}
}