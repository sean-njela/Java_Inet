# 📦 IP Address Tool

Welcome to the **IP Address Tool** 🌐 — a Java application designed to interact with and analyze IP addresses. This tool provides essential information about both local and remote IP addresses, making it useful for network diagnostics and analysis. 🚀

## 📝 Features

- 🌍 **Local Address Information**: Displays the local IP address and hostname of your machine.
- 🌐 **Remote Address Lookup**: Retrieve details about a given remote IP address or hostname.
- 🔄 **Loopback Address Check**: Identify if the provided address is a loopback address.
- 📈 **Reachability Test**: Check if a given address is reachable within a specified timeout.
- 🔢 **IP Address Validation**: Ensure the provided string is a valid IPv4 address.
- 📊 **Address Range Checking**: Test the reachability of addresses in a specified range.

---

## 🚀 Getting Started

### 1️⃣ **Prerequisites**

Ensure you have the following installed:

- ☕ **Java JDK** (Java Development Kit) — Version 8 or above.

### 2️⃣ **Installation**

Clone the repository and navigate to the folder:

```bash
git clone https://github.com/sean-njela/Java_Inet.git
cd ip_address_tool
```

### 3️⃣ **Usage**

To use the tool, run the compiled Java program with an IP address or hostname as an argument:

```bash
java Main <ip-address-or-hostname>
```

🛑 **Note**: You must provide exactly one argument — the IP address or hostname. The application will automatically handle the rest.

---

## 📂 Tool Details

- The tool outputs information such as local address, remote address, hostname, canonical name, and reachability status.
- Example output for a given IP address:
  ```bash
  Local address: 192.168.1.5
  Hostname: my-computer
  Given argument: "8.8.8.8"
  Remote Address: 8.8.8.8
  Remote Hostname: google-public-dns-a.google.com
  Is "8.8.8.8" multicast?: false
  ```

---

## 🛠️ Code Breakdown

### Main Function: `main`

- **Argument Check**: Validates the number of command-line arguments.
- **Local Host Information**: Fetches and displays the local host address and hostname.
- **Remote Address Information**: Retrieves and displays details for the provided address.
- **IP Address Validation**: Validates if the argument is a proper IPv4 address.
- **Reachability Check**: Determines if the address is reachable within a timeout.
- **Address Range Check**: Checks a range of addresses starting from the provided input.

### Key Functions

- **`isValidIPAddress(String ip)`**: Validates if a given string is a valid IPv4 address.
- **`parseIPAddress(String ip)`**: Converts a valid IPv4 address string into a byte array.
- **`checkAddressRange(String baseAddr, int range)`**: Tests the reachability of a series of addresses starting from the provided base address.

---

## 🧑‍💻 Example

Here's how it works in action:

```bash
$ java Main 8.8.8.8
Local address: 192.168.1.5
Hostname: my-computer
Using the passed argument:
Given argument: "8.8.8.8"
Remote Address: 8.8.8.8
Remote Hostname: google-public-dns-a.google.com
...
```

---

## ⚠️ Error Handling

- 🚫 **Unknown Host Exception**: If the provided address cannot be resolved, an error message will be displayed:
  
  ```bash
  UnknownHost Exception
  ```

- 🛑 **Invalid IP Address**: If the provided argument is not a valid IPv4 address, you’ll see:
  
  ```bash
  Provided argument is not a valid IP address.
  ```

- 🕐 **Network Errors**: Any network-related issues during address reachability checks will yield:
  
  ```bash
  A network error occurred!
  ```

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## ❤️ Contributions

Feel free to submit pull requests or raise issues. Contributions are always welcome!

---

## 👤 Author

**Sean Njela**

- GitHub: [@seannjela](https://github.com/sean-njela/ip_address_tool.git)
- Project Link: [@Project_link](https://roadmap.sh/projects/ip-address-tool)

---

## 🎉 Acknowledgements

Feel free to contribute with enhancements and additional features!

Happy Networking! 🎉
