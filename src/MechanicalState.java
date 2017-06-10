/**
 * Created by amitp on 10/06/2017
 */
public abstract class MechanicalState {

    protected ActivityState activityState;
    protected ActivityState historyActivity;

    public abstract void startChase(IceCreamTruckImpl iceCreamTruck);

    public void setState(ActivityState state) {
        activityState = state;
    }

    public abstract String getMode();

    public abstract void kidsFound(IceCreamTruckImpl iceCreamTruck);

    public abstract void carBroken(IceCreamTruckImpl iceCreamTruck,
                                   ShiftState shiftState);

    public abstract void carFixed(IceCreamTruckImpl iceCreamTruck,
                                  ShiftState shiftState);
}
