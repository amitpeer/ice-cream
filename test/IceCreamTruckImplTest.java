import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by amitp on 10/06/2017
 */
public class IceCreamTruckImplTest {

    IceCreamTruckImpl iceCreamTruck;

    @Before
    public void beforeTest() {
        iceCreamTruck = new IceCreamTruckImpl();
        iceCreamTruck.initCounter();
    }

    @Test
    public void test1() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.driverSeeKidsGroup();
        Thread.sleep(60500);
        iceCreamTruck.carBroken();
        Thread.sleep(500);
        iceCreamTruck.carFixed();
        Assert.assertEquals("In Shift State: Fixed State: Patrol State", iceCreamTruck.getMode());
        Assert.assertEquals("true", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("true", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }

    @Test
    public void test2() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        Thread.sleep(10000);
        iceCreamTruck.kidsFound();
        Assert.assertEquals("In Shift State: Fixed State: Patrol State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("true", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("true", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }

    @Test
    public void test3() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        Thread.sleep(70000);
        iceCreamTruck.kidsFound();
        Assert.assertEquals("In Shift State: Fixed State: Patrol State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfChases());
        Assert.assertEquals(0, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("true", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("true", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }

    @Test
    public void test4() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        Thread.sleep(10000);
        iceCreamTruck.carBroken();
        Assert.assertEquals("In Shift State: Broken State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfChases());
        Assert.assertEquals(0, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("false", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("false", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }

    @Test
    public void test5() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        Thread.sleep(10000);
        iceCreamTruck.kidsFound();
        iceCreamTruck.carBroken();
        Thread.sleep(55000);
        Assert.assertEquals("In Shift State: Broken State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfChases());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("false", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("false", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }

    @Test
    public void test6() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        iceCreamTruck.carBroken();
        iceCreamTruck.carFixed();
        Assert.assertEquals("In Shift State: Fixed State: Chase State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfChases());
        Assert.assertEquals(0, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("true", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("true", iceCreamTruck.lights.toString());
        Assert.assertEquals("true", iceCreamTruck.sounds.toString());
    }

    @Test
    public void test7() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        Thread.sleep(10000);
        iceCreamTruck.carBroken();
        Thread.sleep(100000);

        Assert.assertEquals("Out Shift State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfChases());
        Assert.assertEquals(0, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("false", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("false", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }
}