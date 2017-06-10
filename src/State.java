/**
 * Created by amitp on 10/06/2017
 */
public interface State {

    void startShift(IceCreamTruckImpl iceCreamTruck);

    void startChase(IceCreamTruckImpl iceCreamTruck);

    void kidsFound(IceCreamTruckImpl iceCreamTruck);

    void carBroken(IceCreamTruckImpl iceCreamTruck);

    void carFixed(IceCreamTruckImpl iceCreamTruck);

    void endShift(IceCreamTruckImpl iceCreamTruck);

}
