import java.io.IOException; // Importing IOException class to handle IO-related exceptions
import java.net.InetAddress; // Importing InetAddress class for handling IP addresses
import java.net.UnknownHostException; // Importing exception for handling unknown host errors

/*
*
* @author tnjela
*/
public class Main {

  /*
   *
   * @param args the command line arguments
   */

  public static void main(String[] args) {
    if (args.length > 0 && args.length < 2) { // ensure only a single argument is provided

      InetAddress node; // Declare a variable to hold the InetAddress object
      String addr = args[0]; // Store the first command-line argument

      try {
        // getLocalHost returns the address of the local host
        node = InetAddress.getLocalHost();
        System.out.println("\nLocal address: " + node.getHostAddress());
        System.out.println("Hostname: " + node.getHostName());

        if (node.isLoopbackAddress()) {
          System.out.println("This is a loopback address!");
        }

        // Print a separator line for readability
        System.out.println("\n" + "#".repeat(40));
        System.out.println("Using the passed argument:");

        // getByName gets the IP address of the string specified in parenthesis
        node = InetAddress.getByName(addr);
        System.out.println("Given argument: " + "\"" + addr + "\"");
        System.out.println("Remote Address: " + node.getHostAddress());
        System.out.println("Remote Hostname: " + node.getHostName());
        System.out.println("Canonical Name: " + node.getCanonicalHostName());
        System.out.println("Hashcode: " + node.hashCode());
        System.out.println("Is " + "\"" + addr + "\"" + " multicast?: " + node.isMulticastAddress());

        if (node.isLoopbackAddress()) {
          System.out.printf("\"%s\" is a loopback address!\n", addr);
        }
        if (node.isReachable(1000)) {
          System.out.printf("%s is reachable!\n", addr);
        } else {
          System.out.printf("%s is not reachable!\n", addr);
        }

        // Print a separator line for readability
        System.out.println("\n" + "#".repeat(40));
        System.out.println("Now using ONLY an IP:");

        if (isValidIPAddress(addr)) {
          // Parse the IP address into a byte array
          byte[] ipAddress = parseIPAddress(addr);
          if (ipAddress != null) { // Ensure the parsing was successful
            node = InetAddress.getByAddress(ipAddress);
            System.out.println("Given argument: " + "\"" + addr + "\"");
            System.out.println("Remote Address: " + node.getHostAddress());
            System.out.println("Remote Hostname: " + node.getHostName());
            System.out.println("Canonical Name: " + node.getCanonicalHostName());
            System.out.println("Hashcode: " + node.hashCode());
            System.out.println("Is " + "\"" + addr + "\"" + " multicast?: " + node.isMulticastAddress());
          } else {
            System.out.println("Invalid IP address format.");
          }
        } else {
          System.out.println("Provided argument is not a valid IP address.");
        }

        // Print a separator line for readability
        System.out.println("\n" + "#".repeat(40));
        // Check a range of addresses
        System.out.println("Now checking range of addresses: ");
        checkAddressRange(addr, 5); // Check the next 5 addresses

      } catch (UnknownHostException e) {
        System.out.println("UnknownHost Exception");
      } catch (IOException e) {
        System.out.println("A network error occurred!");
      }

    } else {
      System.out.println("Please enter 1 argument!");
    }
  }

  /*
   * Validate whether a given string is a valid IPv4 address.
   *
   * @param ip the IP address string to validate
   * 
   * @return true if valid; false otherwise
   */
  private static boolean isValidIPAddress(String ip) {
    String[] parts = ip.split("\\."); // Split the IP address into its parts
    if (parts.length != 4) // Check if there are exactly 4 parts
      return false; // Return false if not a valid format
    try {
      // Check each part to ensure it's an integer between 0 and 255
      for (String part : parts) {
        int val = Integer.parseInt(part); // Convert string part to integer
        if (val < 0 || val > 255) // Validate the range
          return false; // Return false if out of range
      }
      return true; // Return true if all parts are valid
    } catch (NumberFormatException e) {
      // Handle the case where conversion fails
      return false; // Return false if any part is not a valid integer
    }
  }

  /*
   * Convert a valid IPv4 address string into a byte array.
   *
   * @param ip the valid IP address string to convert
   * 
   * @return byte array representing the IP address or null if invalid
   */
  private static byte[] parseIPAddress(String ip) {
    // Check if the IP address is valid before parsing
    if (!isValidIPAddress(ip))
      return null; // Return null if invalid
    String[] parts = ip.split("\\."); // Split the IP address into parts
    byte[] bytes = new byte[4]; // Create a byte array for the 4 octets
    try {
      // Convert each part to a byte
      for (int i = 0; i < 4; i++) {
        int val = Integer.parseInt(parts[i]); // Convert string part to integer
        bytes[i] = (byte) val; // Assign to byte array
      }
      return bytes; // Return the byte array representing the IP address
    } catch (NumberFormatException e) {
      return null; // Return null if any conversion fails
    }
  }

  /*
   * Check a range of addresses starting from the given address.
   *
   * @param baseAddr the base address to start checking from
   * 
   * @param range the number of addresses to check
   */
  private static void checkAddressRange(String baseAddr, int range) {
    byte[] baseIp = parseIPAddress(baseAddr);
    if (baseIp == null) {
      System.out.println("Invalid base IP address.");
      return;
    }

    for (int i = 1; i <= range; i++) {
      // Increment the last byte of the base IP address
      byte[] checkIp = baseIp.clone(); // Clone the base IP array to modify
      checkIp[3] += i; // Increment the last byte
      InetAddress checkNode = null;
      try {
        checkNode = InetAddress.getByAddress(checkIp);
        if (checkNode.isReachable(1000)) {
          System.out.printf("%s is reachable!\n", checkNode.getHostAddress());
        } else {
          System.out.printf("%s is not reachable!\n", checkNode.getHostAddress());
        }
      } catch (IOException e) {
        System.out.printf("Error checking %s: %s\n", checkNode.getHostAddress(), e.getMessage());
      }
    }
  }
}
