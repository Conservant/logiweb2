package test.Services;

import com.tsystems.logiweb2.Services.TruckService;
import com.tsystems.logiweb2.model.Truck;
import org.junit.Test;
import org.mockito.Mockito;


public class TruckServiceTest {

    @Test
    public void testSave() {
        TruckService truckService = Mockito.mock(TruckService.class);
        Truck truck = new Truck();
        truck.setCapacity(5.0);
        truck.setRequiredNumberOfDrivers(2);
        truck.setRegNumber("I777II");
        truckService.save(truck);
        Mockito.verify(truckService, Mockito.times(1)).save(truck);

    }

    @Test
    public void testGetAll() {
        TruckService truckService = Mockito.mock(TruckService.class);
        truckService.getAll();
        Mockito.verify(truckService, Mockito.times(1)).getAll();
    }
}
