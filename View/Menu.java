package View;

import Classes.Model.Frame;
import Classes.Model.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Menu {
    public static void mainMenu(){
        Frame frame = new Frame("KTP");
        frame.setBounds(350, 200, 700, 240);
        Panel panel = new Panel();
        frame.add(panel);

        JButton input = new JButton("Input KTP Baru");
        input.setBounds(0, 0, 700, 100);
        panel.add(input);
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                InputData.inputDataKTP();
                frame.dispose();
            }
        });
        
        JButton show = new JButton("Show KTP");
        show.setBounds(0, 100, 700, 100);
        panel.add(show);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ShowKTP.searchKTP();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
