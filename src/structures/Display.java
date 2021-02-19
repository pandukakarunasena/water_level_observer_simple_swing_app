package structures;

import javax.swing.*;

import static structures.ControlRoom.currentWaterLevel;

public class Display implements Observable{

    private boolean state;
    private int displayNo;
    private int displayWaterLevel;

    private JPanel displayMain;
    private JPanel displayPanel;
    private JLabel waterLevelLabel;
    private JLabel displayNoLabel;



    public Display(int displayNo) {
        //super("Display "+ displayNo);
        this.displayNo = displayNo;
        displayNoLabel.setText("Display "+ this.displayNo);
        //setContentPane();
        waterLevelLabel.setText(String.valueOf(currentWaterLevel));
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setVisible(true);
        //pack();


    }

    public JPanel getDisplayPanel() {
        return displayMain;
    }

    @Override
    public void update(int waterLevel) {
        waterLevelLabel.setText(String.valueOf(waterLevel));
    }

    public void off(){
        state = false;
    }

    public void on(){
        state = true;
    }

    public boolean isOn(){
        return state;
    }
}
