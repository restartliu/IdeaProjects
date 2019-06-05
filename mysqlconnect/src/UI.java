import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class UI {

    public static void main(String[] args) {
        Frame UIload = new Frame();
        Label nametag = new Label("Username:");
        TextField username = new TextField(10);
        Panel infoload1 = new Panel();
        infoload1.add(nametag);
        infoload1.add(username);

        Label pwdtag = new Label("Password: ");
        TextField password = new TextField(10);
        password.setEchoChar('*');
        Panel infoload2 = new Panel();
        infoload2.add(pwdtag);
        infoload2.add(password);

        Button Connect = new Button("Connect");
        Connect.addActionListener(e -> {
            Statement handle = new Process().connect(username.getText(), password.getText(), UIload);
            if(handle != null) {
                UIload.setVisible(false);
            }
        });
        Button Cancel = new Button("Cancel");Hello Jsp Hello world...
        Cancel.addActionListener(new cancelActionListened());
        Panel buttonload = new Panel(new FlowLayout(FlowLayout.CENTER,50,10));
        buttonload.add(Connect);
        buttonload.add(Cancel);

        UIload.setLayout(new BoxLayout(UIload, BoxLayout.Y_AXIS));
        UIload.add(infoload1);
        UIload.add(infoload2);
        UIload.add(buttonload);
        UIload.pack();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension framesize = UIload.getSize();
        UIload.setLocation( ((int)screensize.getWidth()/2 - (int)framesize.getWidth()/2), ((int)screensize.getHeight()/2 - (int)framesize.getHeight()/2) );
        UIload.setVisible(true);
    }

    /*-------------------------------功能函数-----------------------------------*/
    public void notice(String sentence, Frame ui){
        Dialog tip = new Dialog(ui, "", true);
        tip.setLayout(new BoxLayout(tip, BoxLayout.Y_AXIS));
        Label centenceload = new Label(sentence);
        Button ok = new Button("OK");
        ok.addActionListener(e -> {
            tip.setVisible(false);
        });
        Button cancel = new Button("Cancel");
        cancel.addActionListener(new cancelActionListened());
        Panel buttonload = new Panel();
        buttonload.add(ok);
        buttonload.add(cancel);
        tip.add(centenceload);
        tip.add(buttonload);
        tip.pack();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension framesize = tip.getSize();
        tip.setLocation( ((int)screensize.getWidth()/2 - (int)framesize.getWidth()/2), ((int)screensize.getHeight()/2 - (int)framesize.getHeight()/2) );
        tip.setVisible(true);
    }
}

/*--------------------------------事件拓展类-----------------------------------*/
class cancelActionListened implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }
}