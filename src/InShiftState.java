/**
 * Created by amitp on 10/06/2017
 */
public class InShiftState extends ShiftState {

    public  InShiftState(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("enter InShift state");
        setState(new FixedState(iceCreamTruck ));
    }

    @Override
    public void startShift(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("already in InShift state");
    }

    @Override
    public void startChase(IceCreamTruckImpl iceCreamTruck) {
        mechanicalState.startChase(iceCreamTruck);
    }

    @Override
    public void kidsFound(IceCreamTruckImpl iceCreamTruck) {
        mechanicalState.kidsFound(iceCreamTruck);
    }

    @Override
    public void carBroken(IceCreamTruckImpl iceCreamTruck) {
        mechanicalState.carBroken(iceCreamTruck, this);
    }

    @Override
    public void carFixed(IceCreamTruckImpl iceCreamTruck) {
        mechanicalState.carFixed(iceCreamTruck, this);
    }

    @Override
    public void endShift(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("exit InShift State");
        iceCreamTruck.setLights(false);
        iceCreamTruck.setState(new OutShiftState());
    }

    @Override
    public String getMode() {
        return "In Shift State: " + mechanicalState.getMode();
    }
}
