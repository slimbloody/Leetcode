import sun.util.resources.sl.CalendarData_sl;

public class P1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence {
  public int isPrefixOfWord(String sentence, String searchWord) {
    return sol1(sentence, searchWord);
  }
  
  public int sol1(String sentence, String searchWord) {
    String[] sList = sentence.split(" ");
    for (int i = 0; i < sList.length; ++i) {
      if (sList[i].startsWith(searchWord)) {
        return i + 1;
      }
    }
    
    return -1;
  }
}
