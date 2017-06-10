/**
 * Created by amitp on 10/06/2017
 */
public class BrokenState extends MechanicalState {

    public BrokenState(ActivityState historyActivity) {
        System.out.println("enter Broken State");
        this.historyActivity = historyActivity;
    }

    @Override
    public void startChase(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("Can't chase while truck is broken");
    }

    @Override
    public String getMode() {
        return "Broken State";
    }

    @Override
    public void kidsFound(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("Can't find kinds in Broken State");
    }

    @Override
    public void carBroken(IceCreamTruckImpl iceCreamTruck,
                          ShiftState shiftState) {
        System.out.println("Already in Broken State");
    }

    @Override
    public void carFixed(IceCreamTruckImpl iceCreamTruck,
                         ShiftState shiftState) {
        System.out.println("exit Broken State");
        shiftState.setState(new FixedState(historyActivity));
        System.out.println("enter " + historyActivity.getMode());
        iceCreamTruck.setHasFixed(true);
        setState(historyActivity);
    }
}
