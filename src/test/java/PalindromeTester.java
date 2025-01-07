

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class PalindromeTester {

   @Test
   public void sentences () {
     PalindromeChecker sim = new PalindromeChecker();
     assertEquals(true, sim.palindrome("Madam, I'm Adam!"));
     assertEquals(true, sim.palindrome("A Man! A Plan! A Canal! Panama!"));
   }
   @Test
   public void space(){
      PalindromeChecker sim = new PalindromeChecker();
      assertEquals(true, sim.palindrome("nurses run"));
   }

   @Test
   public void word(){
        PalindromeChecker sim = new PalindromeChecker();
        assertEquals(false, sim.palindrome("test"));
        assertEquals(true, sim.palindrome("rotator"));
        assertEquals(false, sim.palindrome("rewriter"));
   }
}
