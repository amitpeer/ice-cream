/**
 * Created by amitp on 10/06/2017
 */
public class FixedState extends MechanicalState {

    public FixedState() {
        System.out.println("enter Fixed State");
        if (historyActivity == null) {
            setState(new PatrolState());
        }
    }

    public FixedState(ActivityState historyActivity) {
        System.out.println("enter Fixed State");
        this.historyActivity = historyActivity;
    }

    @Override
    public void startChase(IceCreamTruckImpl iceCreamTruck) {
        activityState.startChase(iceCreamTruck, this);
    }

    @Override
    public String getMode() {
        return activityState.getMode();
    }

    @Override
    public void kidsFound(IceCreamTruckImpl iceCreamTruck) {
        activityState.kidsFound(iceCreamTruck, this);
    }

    @Override
    public void carBroken(IceCreamTruckImpl iceCreamTruck,
                          ShiftState shiftState) {
        System.out.println("exit " + activityState.getMode());
        iceCreamTruck.setSounds(false);
        iceCreamTruck.setLights(false);
        iceCreamTruck.setHasFixed(false);
        historyActivity = activityState;
        shiftState.setState(new BrokenState(historyActivity));
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!iceCreamTruck.getHasFixed()) {
                    System.out.println("exit InShift State");
                    iceCreamTruck.setState(new OutShiftState());
                }
            }
        }.start();
    }

    @Override
    public void carFixed(IceCreamTruckImpl iceCreamTruck, ShiftState shiftState) {
        System.out.println("Already in fixed state");
    }
}
