import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class EM extends Thread
{
static Authentication obj;
String s1,s2,s3,s4,emailid,otp="";
MimeMessage mm;
Properties  pro;
OTP o1;
public EM(String em,Authentication obj1)
{
emailid=em;
obj=obj1;
}
public void run()
{
s1="nsnatanesh@gmail.com";//from mail
s2=emailid;//to mail
s3="nsol vxpw wndj bilx";//password
s4="One Time Password";//subject
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
Random r1=new Random();
while(otp.length()<4)
{
otp+=""+(r1.nextInt(9));
}
mm.setText("OTP:"+otp+"\nDont's share your otp\nThe OTP is valid only 5 mins\n----------Thank You----------");
Transport.send(mm);
obj.pros.setVisible(false);
obj.setDefaultCloseOperation(1);
obj.b1.setEnabled(true);
o1=new OTP(otp,obj.t1.getText(),obj.s1,obj);
}
catch(Exception e)
{
System.out.println(e);
}
}
public String getOtp()
{
return otp;
}
}