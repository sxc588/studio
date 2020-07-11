package leetcode.t07xx.t0639.dd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class SolutionTest {

    private static Solution s = new Solution();

    public static boolean isboolIp(String ipAddress) {
        String ip = "([0-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);

        return matcher.matches();
    }

    @Test
    public void name() {
        assertTrue(isboolIp("0"));
        assertTrue(isboolIp("1"));
        assertTrue(isboolIp("10"));
        assertTrue(isboolIp("100"));
        assertTrue(isboolIp("123"));
        assertTrue(isboolIp("255"));

        assertFalse(isboolIp("00"));
        assertFalse(isboolIp("01"));
        assertFalse(isboolIp("010"));
        assertFalse(isboolIp("256"));
        assertFalse(isboolIp("356"));
        assertFalse(isboolIp("1356"));
    }
    
    @Test
    public void TT () {

        
        
        assertTrue(isboolIp("1"));
        assertTrue(isboolIp("10"));
        assertTrue(isboolIp("100"));
        assertTrue(isboolIp("123"));
        assertTrue(isboolIp("255"));

        assertFalse(isboolIp("00"));
        assertFalse(isboolIp("01"));
        assertFalse(isboolIp("010"));
        assertFalse(isboolIp("256"));
        assertFalse(isboolIp("356"));
        assertFalse(isboolIp("1356"));
    }
    
    
    

}
