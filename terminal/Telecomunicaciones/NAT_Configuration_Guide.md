Static Inside NAT (One-to-One Mapping):
Configure R1 to translate the address on D1 Interface VLAN 1 to 209.165.200.99:12
R1(config)# ip nat inside source static 10.0.0.2 209.165.200.99[^3^][3][^4^][4]

Specify the inside and outside interfaces for NAT purposes:5

R1(config)# interface g0/0/0[^6^][6][^7^][7]
R1(config-if)# ip nat outside
R1(config-if)# exit[^6^][6]
R1(config)# interface g0/0/1[^7^][7]
R1(config-if)# ip nat inside[^9^][9]
R1(config-if)# exit[^6^][6]

Pooled NAT (Many-to-Many Mapping):
Create an access list to identify the source addresses for translation (e.g., entire 10.1.0.0/24 network):
R3(config)# access-list 33 permit 10.1.0.0 0.0.0.255[^10^][10]

Create a pool of addresses for translation (e.g., 209.165.224.5 to 209.165.224.6):
R3(config)# ip nat pool POOLEDNAT 209.165.224.5 209.165.224.6 prefix-length 24[^11^][11][^12^][12]

Associate the interesting addresses with the NAT pool:
R3(config)# ip nat inside source list 33 pool POOLEDNAT[^13^][13][^9^][9]

NAT Overload (PAT - Port Address Translation):
Configure R3 to overload on the outside interface (g0/0/0):89
R3(config)# ip nat inside source list 33 interface g0/0/0 overload[^9^][9][^13^][13]

Remember to adjust the IP addresses, interfaces, and pool ranges according to your network setup. These commands will enable NAT functionality based on your requirements. 😊