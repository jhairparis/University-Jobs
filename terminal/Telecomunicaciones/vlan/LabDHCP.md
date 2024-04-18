# Lab – Implement DHCPv4

## Router 1

```bash
enable 
conf t

hostname R1
no ip domain-lookup

enable secret class
line console 0
password cisco
login
exit

line vty 0 4
password cisco
login
exit

service password-encryption

banner motd $ Authorized Users Only! $
copy running-config startup-config

clock set 13:30:00 18 April 2024

interface g0/0/1
no shutdown
exit

interface g0/0/1.100
description Client Network
encapsulation dot1q 100
ip address 192.168.1.1 255.255.255.192

interface g0/0/1.200
encapsulation dot1q 200
description Management Network
ip address 192.168.1.65 255.255.255.224

interface g0/0/1.1000
encapsulation dot1q 1000 native
description Native VLAN

ip dhcp excluded-address 192.168.1.1 192.168.1.5
ip dhcp pool R1_Client_LAN
network 192.168.1.0 255.255.255.192
domain-name ccna-lab.com
default-router 192.168.1.1
lease 2 12 30

ip dhcp excluded-address 192.168.1.97 192.168.1.101
ip dhcp pool R2_Client_LAN
network 192.168.1.96 255.255.255.240
default-router 192.168.1.97
domain-name ccna-lab.com
lease 2 12 30

copy running-config startup-config
```

## Router 2

```bash
enable 
conf t

hostname R2
no ip domain-lookup

enable secret class
line console 0
password cisco
login
exit

line vty 0 4
password cisco
login
exit

service password-encryption

banner motd $ Authorized Users Only! $
copy running-config startup-config

clock set 13:30:00 18 April 2024

interface g0/0/1
ip address 192.168.1.97 255.255.255.240
ip helper-address 10.0.0.1
no shutdown
exit

interface g0/0/0
ip address 10.0.0.1 255.255.255.252
no shutdown

interface g0/0/0
ip address 10.0.0.2 255.255.255.252
no shutdown

ip route 0.0.0.0 0.0.0.0 10.0.0.2
ip route 0.0.0.0 0.0.0.0 10.0.0.1

copy running-config startup-config
```

## Switch 1

```bash
enable
conf t

hostname S1
no ip domain-lookup
enable secret class

line console 0
password cisco
login

line vty 0 4
password cisco
login

service password-encryption

banner motd $ Authorized Users Only! $
exit
copy running-config startup-config

clock set 13:30:00 18 April 2024

vlan 100
name Clients
vlan 200
name Management
vlan 999
name Parking_Lot
vlan 1000
name Native
exit


interface vlan 200
ip address 192.168.1.66 255.255.255.224
no shutdown
exit
ip default-gateway 192.168.1.65

interface range f0/1 - 4, f0/7 - 24, g0/1 - 2
switchport mode access
switchport access vlan 999
shutdown
exit

interface f0/6
switchport mode access
switchport access vlan 100

interface f0/5
switchport mode trunk
switchport trunk native vlan 1000
switchport trunk allowed vlan 100,200,1000
exit

copy running-config startup-config

```
## Switch 2

```bash
enable
conf t

hostname S2
no ip domain-lookup
enable secret class

line console 0
password cisco
login

line vty 0 4
password cisco
login

service password-encryption

banner motd $ Authorized Users Only! $
exit
copy running-config startup-config

clock set 13:30:00 18 April 2024

interface vlan 1
ip address 192.168.1.98 255.255.255.240
no shutdown
exit
ip default-gateway 192.168.1.97

interface range f0/1 - 4, f0/6 - 17, f0/19 - 24, g0/1 - 2
switchport mode access
shutdown
exit
```