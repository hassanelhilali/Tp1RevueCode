package isima.codereview;

import isima.codereview.AwesomePasswordChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class AwesomePasswordCheckerTest {

    @Test
    public void testGetInstance() throws IOException {
        // Ensure the instance is not null
        assertNotNull(AwesomePasswordChecker.getInstance(), "Instance should not be null");
    }

    @Test
    public void testGetInstanceWithParam() throws IOException {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        assertNotNull(AwesomePasswordChecker.getInstance(file), "Instance should not be null");
    }

    @Test
    void testMaskAff_LowercaseLetters() throws IOException {
        String password = "hassan";
        ByteArrayInputStream emptyStream = new ByteArrayInputStream("".getBytes());
        AwesomePasswordChecker checker = new AwesomePasswordChecker(emptyStream);

        int[] maskArray = checker.maskAff(password);
        assertNotNull(maskArray);
        assertEquals(28, maskArray.length, "Mask array length should be 28");
        assertArrayEquals(new int[] { 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, maskArray);
    }

    @Test
    public void testGetDistance() throws IOException {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance(file);

        String password = "hassanisima";
        double distance = checker.getDistance(password);

        assertTrue(distance >= 0);
        assertEquals(2.0500939777849654, distance);
    }

    @Test
    public void testGetDistance2() throws IOException {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance(file);

        String password = "elhilali";
        double distance = checker.getDistance(password);

        assertTrue(distance >= 0);
        assertEquals(3.0909928290278406, distance);
    }

    @Test
    public void testMD5() {
        String expected = "5d41402abc4b2a76b9719d911017c592"; // MD5 of "hello"
        String result = AwesomePasswordChecker.ComputeMD5("hello");

        assertNotNull(result);
        assertEquals(expected, result);
    }

    // New test cases

    @Test
    public void testMaskAff_UppercaseLetters() throws IOException {
        String password = "HASSAN";
        ByteArrayInputStream emptyStream = new ByteArrayInputStream("".getBytes());
        AwesomePasswordChecker checker = new AwesomePasswordChecker(emptyStream);

        int[] maskArray = checker.maskAff(password);
        assertNotNull(maskArray);
        assertEquals(28, maskArray.length, "Mask array length should be 28");
        assertArrayEquals(new int[] { 4, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, maskArray);
    }

    @Test
    public void testMaskAff_SpecialCharacters() throws IOException {
        String password = "!@#";
        ByteArrayInputStream emptyStream = new ByteArrayInputStream("".getBytes());
        AwesomePasswordChecker checker = new AwesomePasswordChecker(emptyStream);

        int[] maskArray = checker.maskAff(password);
        assertNotNull(maskArray);
        assertEquals(28, maskArray.length, "Mask array length should be 28");
        assertArrayEquals(new int[] { 6, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, maskArray);
    }

    @Test
    public void testMaskAff_MixedCharacters() throws IOException {
        String password = "Hassan123!";
        ByteArrayInputStream emptyStream = new ByteArrayInputStream("".getBytes());
        AwesomePasswordChecker checker = new AwesomePasswordChecker(emptyStream);

        int[] maskArray = checker.maskAff(password);
        assertNotNull(maskArray);
        assertEquals(28, maskArray.length, "Mask array length should be 28");
        assertArrayEquals(new int[] { 4, 1, 1, 1, 1, 1, 5, 5, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, maskArray);
    }
}