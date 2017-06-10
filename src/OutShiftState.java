/**
 * Created by amitp on 10/06/2017
 */
public class OutShiftState extends ShiftState {

    public OutShiftState() {
        System.out.println("enter OutShift State");
    }

    @Override
    public void startShift(IceCreamTruckImpl iceCreamTruck) {
        iceCreamTruck.setLights(true);
        iceCreamTruck.setState(new InShiftState());
    }

    @Override
    public void startChase(IceCreamTruckImpl iceCreamTruck) {
        System.out.print("Can't start chase in OutShiftState");
    }

    @Override
    public void kidsFound(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("Can't find kids in OutShift State");
    }

    @Override
    public void carBroken(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("Car can't break in OutShift State");
    }

    @Override
    public void carFixed(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("Can't fix truck in OutShift state");
    }

    @Override
    public void endShift(IceCreamTruckImpl iceCreamTruck) {
        System.out.println("Already in OutShift State");
    }

    @Override
    public String getMode() {
        return "OutShift State";
    }
}
