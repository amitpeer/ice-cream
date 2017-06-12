/**
 * Created by amitp on 10/06/2017
 */
public class PatrolState extends ActivityState {

    public PatrolState() {
        this.soundOn = false;
        System.out.println("enter Patrol state");
    }

    @Override
    public void startChase(IceCreamTruckImpl iceCreamTruck,
                           MechanicalState mechanicalState) {
        mechanicalState.setState(new ChaseState( iceCreamTruck));
      //  IceCreamTruckImpl.increaseChaseCount();
       // iceCreamTruck.setSounds(true);

        new Thread()
        {
            public void run() {
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(!iceCreamTruck.getHasKidsFound()){
                    System.out.println("exit Chase state");
                    iceCreamTruck.setSounds(false);
                    mechanicalState.setState(new PatrolState());
                }
            }
        }.start();
    }

    @Override
    public String getMode() {
        return "Patrol State";
    }

    @Override
    public void kidsFound(IceCreamTruckImpl iceCreamTruck,
                          MechanicalState mechanicalState) {
        System.out.println("Can't find kids in Patrol State");
    }
}
