public class P717_1_bit_and_2_bit_Characters {
  public boolean isOneBitCharacter(int[] bits) {
    return sol1(bits);
  }
  
  // there can't be odd number 1 before the last zero
  public boolean sol1(int[] bits) {
    int count = 0;
    
    for (int i = bits.length - 2; i >= 0; --i) {
      if (bits[i] == 1) {
        ++count;
      }
      else {
        break;
      }
    }
  
    if (count % 2 != 0) {
      return false;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P717_1_bit_and_2_bit_Characters p = new P717_1_bit_and_2_bit_Characters();
    p.isOneBitCharacter(new int[]{1,1,1,0});
  }
}
