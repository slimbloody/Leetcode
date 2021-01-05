public class P1108_Defanging_an_IP_Address {
  public String defangIPaddr(String address) {
    return sol1(address);
  }
  
  public String sol1(String address) {
    return address.replace(".", "[.]");
  }
}
