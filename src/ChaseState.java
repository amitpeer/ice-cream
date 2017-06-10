/**
 * Created by amitp on 10/06/2017
 */
public class ChaseState extends ActivityState {

    public ChaseState() {
        System.out.println("enter Chase State");
    }

    @Override
    public void startChase(IceCreamTruckImpl iceCreamTruck,
                           MechanicalState mechanicalState) {
        System.out.println("Already in Chase State");
    }

    @Override
    public String getMode() {
        return "Chase State";
    }

    @Override
    public void kidsFound(IceCreamTruckImpl iceCreamTruck,
                          MechanicalState mechanicalState) {
        IceCreamTruckImpl.increaseChaseSuccessCounter();
        iceCreamTruck.setHasKidsFound(true);
        iceCreamTruck.setSounds(false);
        System.out.println("exit Chase State");
        mechanicalState.setState(new PatrolState());
    }
}
