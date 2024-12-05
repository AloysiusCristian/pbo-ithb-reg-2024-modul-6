package Classes.Model;

import javax.swing.JLabel;

public class Label extends JLabel{
    public Label(String text){
        initComponent(text);
    }

    private void initComponent(String text){
        this.setText(text);
    }
}
