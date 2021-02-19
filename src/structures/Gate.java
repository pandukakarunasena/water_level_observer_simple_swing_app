package structures;

import javax.swing.*;

public class Gate implements Observable{
    private boolean state = false;
    private int gateNo;
    private JPanel gatePanel;
    private JLabel gatePanelLabel;
    private JLabel gateStateLabel;

    public Gate(int gateNo) {
        this.gateNo = gateNo;
        gatePanelLabel.setText(String.valueOf(gateNo));
    }

    public int getGateNo() {
        return gateNo;
    }

    public boolean isOn() {
        return state;
    }

    @Override
    public void update(int waterLevel) {
        ControlRoom.currentWaterLevel = waterLevel;
        if( ControlRoom.currentWaterLevel > ControlRoom.maxWaterLevel){
            on();
        }else{
            off();
        }
    }

    public JPanel getGatePanel() {
        return gatePanel;
    }

    public void off(){
        state = false;
        gateStateLabel.setText("Closed");
    }

    public void on(){
        if(ControlRoom.currentWaterLevel < ControlRoom.minWaterLevel){
            gateStateLabel.setText("Low water level");
        }else{
            state = true;
            gateStateLabel.setText("Open");
        }
    }
}
