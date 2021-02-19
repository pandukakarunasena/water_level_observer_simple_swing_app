package structures;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlRoom extends JFrame {
    public ArrayList<Observable> equipment = new ArrayList<>();
    public static int currentWaterLevel;
    public static int maxWaterLevel = 80;
    public static int minWaterLevel = 20;

    private JPanel controlRoomMain;
    private JPanel controlRoomMenu;
    private JPanel controlRoomIndicators;
    private JSlider slider1;
    private JPanel displayPain;
    private JPanel alarmPain;
    private JPanel gatesPain;
    private JPanel othersPain;
    private JButton addAlarmButton;
    private JButton button2;
    private JButton addDisplayButton;

    public ControlRoom(int maxWaterLevel, int minWaterLevel) {
        super("Control Room");
        setContentPane(controlRoomMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        this.maxWaterLevel = maxWaterLevel;
        this.minWaterLevel = minWaterLevel;

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider waterLevelSlider = (JSlider) e.getSource();
                int waterLevel = (int) waterLevelSlider.getValue();
                currentWaterLevel = waterLevel;
                System.out.println(currentWaterLevel);
                updateStatus(currentWaterLevel);
            }
        });

        addAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alarm alarm = new Alarm(100);
                equipment.add(alarm);
                alarmPain.add(alarm.getAlarmForm());
                alarmPain.validate();
                alarmPain.repaint();

                System.out.println("alarm added");
            }
        });

        addDisplayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display display = new Display(100);
                equipment.add(display);
                displayPain.add(display.getDisplayPanel());
                displayPain.validate();
                displayPain.repaint();

                System.out.println("display added");
            }
        });

        Gate gate1 = new Gate(101);
        Gate gate2 = new Gate(102);

        equipment.add(gate1);
        equipment.add(gate2);

        gatesPain.add(gate1.getGatePanel());
        gatesPain.add(gate2.getGatePanel());
    }

    public int getWaterLevel() {
        return currentWaterLevel;
    }

    private void updateStatus(int waterLevel) {
        for (Observable equipment : equipment) {
            equipment.update(currentWaterLevel);
        }
    }

    public void setData(Display data) {
    }

    public void getData(Display data) {
    }

    public boolean isModified(Display data) {
        return false;
    }
}
