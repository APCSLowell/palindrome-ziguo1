import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  return clean(word).equals(reverse(clean(word)));
}

public String clean(String str) {
  String sNew = new String();
  for (int i = 0; i < str.length(); i++) {
      String str2 = String.valueOf(str.charAt(i)).toLowerCase();
      char car = str2.charAt(0);
      if (car >= 97 && car <= 122)
        sNew += str2;
  }
  return sNew;
}

public String reverse(String str)
{
    String sNew = new String();
    for (int i = str.length() - 1; i >= 0; i--) {
      String str2 = String.valueOf(str.charAt(i));
      sNew += str2;
    }
    return sNew;
}
}
