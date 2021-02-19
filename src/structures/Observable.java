package structures;

public interface Observable {
    public void update(int waterLevel);
    public void on();
    public void off();
    public boolean isOn();
}
