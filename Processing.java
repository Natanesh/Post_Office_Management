import java.awt.*;
import javax.swing.*;
class Processing extends JFrame
{
JLabel l1;
Processing()
{
/*Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width,dim.height/2-this.getSize().height);*/
setIconImage(new ImageIcon("post-office.png").getImage());
setLocationRelativeTo(null);
setDefaultCloseOperation(0);
setResizable(false);
setLayout(new BorderLayout());
l1=new JLabel("<html><h1>Processing...</h1></html>",JLabel.CENTER);
add(l1,BorderLayout.CENTER);
setTitle("Processing...");
setSize(400,200);
setVisible(true);
}
}