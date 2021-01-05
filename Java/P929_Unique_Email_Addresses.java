import java.util.HashSet;
import java.util.Set;

public class P929_Unique_Email_Addresses {
  public int numUniqueEmails(String[] emails) {
    return sol1(emails);
  }
  
  public int sol1(String[] emails) {
    Set<String> set = new HashSet<>();
    
    for (String email: emails) {
      StringBuilder stringBuilder = new StringBuilder();
      
      boolean writeDown = true;
      boolean ignoreDot = true;
      for (int i = 0; i < email.length(); ++i) {
        if (email.charAt(i) == '+') {
          writeDown = false;
        }
        else if (email.charAt(i) == '@') {
          writeDown = true;
          ignoreDot = false;
          stringBuilder.append(email.charAt(i));
        }
        else if (email.charAt(i) == '.') {
          if (!ignoreDot) {
            stringBuilder.append(email.charAt(i));
          }
        }
        else {
          if (writeDown) {
            stringBuilder.append(email.charAt(i));
          }
        }
      }
      
      set.add(stringBuilder.toString());
    }
    
    return set.size();
  }
}
