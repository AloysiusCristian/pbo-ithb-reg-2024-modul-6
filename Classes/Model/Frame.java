package Classes.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(String name){
        initComponent(name);
    }

    private void initComponent(String name){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(400, 0, 640, (int)screenSize.height);
        this.setResizable(false);
        this.setBackground(Color.decode("#F3F3E0"));
        this.setTitle(name);
    }
}
