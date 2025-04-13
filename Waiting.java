public class Waiting extends Thread
{
Employee e;
public Waiting(Employee e1)
{
e=e1;
}
public void run()
{
try
{
Thread.sleep(3000);
e.pros.setVisible(false);
e.setVisible(false);
Info in=new Info();
}
catch(Exception e)
{
System.out.println(e);
}
}
}