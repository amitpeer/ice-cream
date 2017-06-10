/**
 * Created by amitp on 10/06/2017
 */
public abstract class ShiftState implements State {

    protected MechanicalState mechanicalState;

    public void setState(MechanicalState state) {
        mechanicalState = state;
    }

    public abstract String getMode();
}
