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
        Thread.sleep(6050);
        iceCreamTruck.carBroken();
        Thread.sleep(50);
        iceCreamTruck.carFixed();
        Assert.assertEquals("Patrol State", iceCreamTruck.getMode());
        Assert.assertEquals("true", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("true", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());


    }

    @Test
    public void test2() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        Thread.sleep(1000);
        iceCreamTruck.kidsFound();
        Assert.assertEquals("Patrol State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("true", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("true", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }

    @Test
    public void test3() throws InterruptedException {
        iceCreamTruck.startShift();
        iceCreamTruck.kidsGroupAlertFromCenter();
        Thread.sleep(7000);
        iceCreamTruck.kidsFound();
        Assert.assertEquals("Patrol State", iceCreamTruck.getMode());
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
        Thread.sleep(1000);
        iceCreamTruck.carBroken();
        Assert.assertEquals("Broken State", iceCreamTruck.getMode());
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
        Thread.sleep(1000);
        iceCreamTruck.kidsFound();
        iceCreamTruck.carBroken();
        Thread.sleep(5500);
        Assert.assertEquals("Broken State", iceCreamTruck.getMode());
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
        Assert.assertEquals("Chase State", iceCreamTruck.getMode());
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
        Thread.sleep(1000);
        iceCreamTruck.carBroken();
        Thread.sleep(10000);

        Assert.assertEquals("OutShift State", iceCreamTruck.getMode());
        Assert.assertEquals(1, iceCreamTruck.getNumberOfChases());
        Assert.assertEquals(0, iceCreamTruck.getNumberOfSuccessfulChases());

        Assert.assertEquals("false", iceCreamTruck.hasFixed.toString());
        Assert.assertEquals("false", iceCreamTruck.lights.toString());
        Assert.assertEquals("false", iceCreamTruck.sounds.toString());
    }




}