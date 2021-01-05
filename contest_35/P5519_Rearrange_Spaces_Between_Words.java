public class P5519_Rearrange_Spaces_Between_Words {
  public String reorderSpaces(String text) {
    return sol1(text);
  }
  
  public String sol1(String text) {
    String[] split = text.trim().split("\\s+");
    int total = text.length();
    int count = 0;
    for (int i = 0; i < split.length; ++i) {
      count += split[i].length();
    }
    int diff = total - count;
    int interval, remain;
    if (split.length - 1 == 0) {
      remain = diff;
      interval = 0;
    }
    else {
      remain = diff % (split.length - 1);
      interval = diff / (split.length - 1);
    }
    
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < split.length; ++i) {
      if (split[i].length() != 0) {
        res.append(split[i]);
        
        if (i != split.length - 1) {
          for (int j = 0; j < interval; ++j) {
            res.append(" ");
          }
        }
        else {
          for (int j = 0; j < remain; ++j) {
            res.append(" ");
          }
        }
      }
    }
    
  
    String s = res.toString();
//    System.out.println(s);
    return s;
  }
  
  public static void main(String[] args) {
    P5519_Rearrange_Spaces_Between_Words p = new P5519_Rearrange_Spaces_Between_Words();
    System.out.println(p.reorderSpaces("  this   is  a sentence ") == "this   is   a   sentence");
    System.out.println(p.reorderSpaces(" practice   makes   perfect") == "practice   makes   perfect ");
    System.out.println(p.reorderSpaces("hello   world") == "hello   world");
    System.out.println(p.reorderSpaces("  walks  udp package   into  bar a") == "walks  udp  package  into  bar  a ");
    System.out.println(p.reorderSpaces("a") == "a");
    System.out.println(p.reorderSpaces("  a") == "a  ");
    System.out.println(p.reorderSpaces("a  ") == "a  ");
  }
}
