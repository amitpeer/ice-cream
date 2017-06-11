/**
 * Created by amitp on 10/06/2017
 */
public abstract class ActivityState {


    public abstract void startChase(IceCreamTruckImpl iceCreamTruck,
                                    MechanicalState mechanicalState);

    public abstract String getMode();

    public abstract void kidsFound(IceCreamTruckImpl iceCreamTruck,
                                   MechanicalState mechanicalState);

    public void carBroken(IceCreamTruckImpl iceCreamTruck) {
        ActivityState currentState = this;
    }
}
