package donations.server;

import org.junit.Test;

import concesionario.clases.DonationInfo;
import concesionario.server.DonationCollector;

import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class DonationCollectorTest {

    private DonationCollector donationCollector;

    @Before
    public void setUp() {
        donationCollector = new DonationCollector();
    }

    @Test
    public void testEmptyDonation() {
        DonationInfo donationInfo = donationCollector.getDonationInfo();
        assertEquals(0, donationInfo.getLast());
        assertEquals(0, donationInfo.getTotal());
    }
}