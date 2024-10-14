
```bash
en 
conf t
hostname R1
no ip domain lookup
line con 0
 exec-timeout 0 0
 logging synchronous
 exit
line vty 0 4
 privilege level 15
 password cisco123
 exec-timeout 0 0
 logging synchronous
 login
 exit
banner motd # This is R1, Implement NAT Lab #
interface g0/0/0
 ip address 209.165.200.1 255.255.255.0
 no shut
 exit
interface g0/0/1
 ip address 10.0.0.1 255.255.255.0
 no shut
 exit
 ip route 0.0.0.0 0.0.0.0 g0/0/0 209.165.200.2
```

```bash
en 
conf t
hostname R2
no ip domain lookup
line con 0
 exec-timeout 0 0
 logging synchronous
 exit
line vty 0 4
 privilege level 15
 password cisco123
 exec-timeout 0 0
 logging synchronous
 login
 exit
banner motd # This is R2, Implement NAT Lab #
interface g0/0/0
ip address 209.165.200.2 255.255.255.0
no shut
exit
interface g0/0/1
ip address 209.165.224.2 255.255.255.0
no shut
exit
interface loopback 0
ip address 209.165.240.1 255.255.255.0
no shut
exit
ip route 10.0.0.0 255.255.255.0 g0/0/0 209.165.200.1
ip route 10.1.0.0 255.255.255.0 g0/0/1 209.165.224.3
```

```bash
en
conf t
hostname D1
no ip domain lookup
line con 0
 exec-timeout 0 0
 logging synchronous
 exit
line vty 0 4
 privilege level 15
 password cisco123
 exec-timeout 0 0
 logging synchronous
 login
 exit
banner motd # This is D1, Implement NAT Lab #
interface range g1/0/1-24, g1/1/1-4
 shutdown
 exit
interface range g1/0/11, g1/0/23
 no shutdown
 exit
interface g1/0/23
 switchport mode access
 spanning-tree portfast
 exit
interface vlan 1
 ip address 10.0.0.2 255.255.255.0
 no shutdown
ip default-gateway 10.0.0.1
```

```bash
hostname D2
no ip domain lookup
line con 0
 exec-timeout 0 0
 logging synchronous
 exit
line vty 0 4
 privilege level 15
 password cisco123
 exec-timeout 0 0
 logging synchronous
 login
 exit
banner motd # This is D2, Implement NAT Lab #
interface range g1/0/1-24, g1/1/1-4
 shutdown
 exit
interface range g1/0/11, g1/0/23-24
 no shutdown
 exit
interface range g1/0/23-24
 switchport mode access
 spanning-tree portfast
 exit
interface vlan 1
 ip address 10.1.0.2 255.255.255.0
 no shutdown
ip default-gateway 10.1.0.1
```