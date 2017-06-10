/**
 * Created by amitp on 10/06/2017
 */
public class IceCreamTruckImpl implements IceCreamTruck {

    private static int chaseSuccessCounter;
    private static int chaseCount;
    private ShiftState state;
    private Boolean lights;
    private Boolean sounds;
    private Boolean hasFixed = true;
    private Boolean hasKidsFound = false;

    public IceCreamTruckImpl() {
        state = new OutShiftState();
    }

    public static void increaseChaseSuccessCounter() {
        chaseSuccessCounter++;
    }

    public static void increaseChaseCount() {
        chaseCount++;
    }

    public State getState() {
        return state;
    }

    public void setState(ShiftState state) {
        this.state = state;
    }

    @Override
    public void startShift() {
        state.startShift(this);
    }

    @Override
    public String getMode() {
        return state.getMode();
    }

    @Override
    public void driverSeeKidsGroup() {
        state.startChase(this);
    }

    @Override
    public void kidsGroupAlertFromCenter() {
        state.startChase(this);
    }

    @Override
    public void kidsFound() {
        state.kidsFound(this);
    }

    @Override
    public void carBroken() {
        state.carBroken(this);
    }

    @Override
    public void carFixed() {
        state.carFixed(this);
    }

    @Override
    public void endShift() {
        state.endShift(this);
    }

    @Override
    public int getNumberOfChases() {
        return chaseCount;
    }

    @Override
    public int getNumberOfSuccessfulChases() {
        return chaseSuccessCounter;
    }

    public void setLights(Boolean lights) {
        this.lights = lights;
    }

    public void setSounds(Boolean sounds) {
        this.sounds = sounds;
    }

    public Boolean getHasFixed() {
        return hasFixed;
    }

    public void setHasFixed(Boolean hasFixed) {
        this.hasFixed = hasFixed;
    }

    public Boolean getHasKidsFound() {
        return hasKidsFound;
    }

    public void setHasKidsFound(Boolean hasKidsFound) {
        this.hasKidsFound = hasKidsFound;
    }

    public void initCounter() {
        chaseCount = 0;
        chaseSuccessCounter = 0;
    }
}
