package test.Services;

import com.tsystems.logiweb2.Services.DriverService;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import org.junit.Test;
import org.mockito.Mockito;


public class DriverServiceTest {

    @Test
    public void testSave() {
        DriverService driverService = Mockito.mock(DriverService.class);
        Driver driver = new Driver();
        driver.setName("George Bush");
        driver.setLicenseNumber("090909");
        driver.setDriverStatus(DriverStatus.FREE);
        driverService.save(driver);
        Mockito.verify(driverService, Mockito.times(1)).save(driver);
    }

    @Test
    public void testGetAll() {
        DriverService driverService = Mockito.mock(DriverService.class);
        driverService.getAll();
        Mockito.verify(driverService, Mockito.times(1)).getAll();
    }
}
