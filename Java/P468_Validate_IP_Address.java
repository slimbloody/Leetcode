import java.net.Inet6Address;
import java.net.InetAddress;

public class P468_Validate_IP_Address {
  public String validIPAddress(String IP) {
    return sol1(IP);
  }
  
  public String sol1(String IP) {
    try {
      return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
    } catch(Exception e) {}
    return "Neither";
  }
  
  public String sol2(String IP) {
    String ipv4 = "^((\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.){4}$";
    String ipv6 = "^(([\\da-fA-F]{1,4}):){8}$";
  
    return IP.matches(ipv4) ? "IPv4" : IP.matches(ipv6) ? "IPv6" : "Neither";
  }
  
  public String sol3(String IP) {
    return "";
  }
}
