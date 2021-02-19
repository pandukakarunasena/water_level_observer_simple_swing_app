package structures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static structures.ControlRoom.maxWaterLevel;

public class Alarm implements Observable {

    private int alarmNo;
    private boolean state = false;
    private boolean rung = false;


    private JPanel alarmForm;
    private JLabel stateValueLabel;
    private JLabel alarmNoLabel;
    private JButton stateButton;

    Alarm(int alarmNo) {
        //super("Alarm " + alarmNo);
        //setContentPane(alarmForm);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setVisible(true);
        //pack();


        this.alarmNo = alarmNo;
        alarmNoLabel.setText("Alarm "+alarmNo);
        stateValueLabel.setText("Alarm OFF");
        stateValueLabel.setForeground(new Color(255,0,0));
        stateButton.setText("ON");

        stateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!state){
                    on();
                }else{
                    off();
                }
            }
        });

    }

    public JPanel getAlarmForm() {
        return alarmForm;
    }


    @Override
    public void update(int waterLevel) {
        if(waterLevel > maxWaterLevel ){
           on();
        }

        if(waterLevel < maxWaterLevel ){
            off();
        }

    }



    public void on() {
        state = true;
        buttonOnStyle();
    }

    public void off() {
        state = false;
        buttonOffStyle();
    }

    private void buttonOnStyle(){
        stateValueLabel.setText("Alarm ON");
        stateValueLabel.setForeground(new Color(127,255,0));
        stateButton.setText("OFF");
    }

    private void buttonOffStyle(){
        stateValueLabel.setText("Alarm OFF");
        stateValueLabel.setForeground(new Color(255,0,0));
        stateButton.setText("ON");
    }

    public boolean isOn() {
        return state;
    }

}