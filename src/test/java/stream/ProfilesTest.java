package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfilesTest {

    @Test
    public void whenShowListOfAddresses() {
        Address address1 = new Address("Tallinn", "Heli", 1, 70);
        Address address2 = new Address("Arkhangelsk", "Lomonosova", 175, 77);
        Address address3 = new Address("London", "Baker street", 221, 2);

        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);

        List<Profile> profile = Arrays.asList(profile1, profile2, profile3);
        List<Address> rsl = Profiles.collect(profile);
        List<Address> expected = Arrays.asList(address1, address2, address3);
        assertEquals(rsl, expected);
    }
}