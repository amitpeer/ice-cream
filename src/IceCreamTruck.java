/**
 * Created by amitp on 10/06/2017
 */

public interface IceCreamTruck {

    //Strat shift
    void startShift();

    //Return all states of the system
    String getMode();

    //driver see a group of children
    void driverSeeKidsGroup();

    //driver gets an alarm of kids group location
    void kidsGroupAlertFromCenter();

    //the driver catch the group of kind
    void kidsFound();

    //the car is broken
    void carBroken();

    //car is fixed
    void carFixed();

    //the shift ended
    void endShift();

    //return the number of chases
    int getNumberOfChases();

    //return the number of successful chases
    int getNumberOfSuccessfulChases();

}
