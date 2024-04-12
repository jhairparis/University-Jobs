# Lab - Implement Inter-VLAN Routing​ 

![Topology](../images/topology%20vlan%20lab.png)

| Nombre | IPV4         | Mascara       | Gateway      |
|--------|--------------|---------------|--------------|
| PC-A   | `192.168.20.3` | `255.255.255.0` | `192.168.20.1` |
| PC-B   | `192.168.30.3` | `255.255.255.0` | `192.168.30.1` |

## Script config for Router

```bash
enable
conf t

hostname R-1
no ip domain lookup

enable secret class

line console 0
password cisco
login
exit

line vty 0 4
password cisco
login

service password-encryption

banner motd $Configuracion basica de router unicamente se permite el acceso autorizado!$
exit

copy running-config startup-config

clock set 8:00:00 April 12 2024

conf t

interface g0/0/1
no shutdown
exit

interface g0/0/1.10
encapsulation dot1q 10
description Management Network
ip address 192.168.10.1 255.255.255.0
exit

interface g0/0/1.20
encapsulation dot1q 20
description Sales Network
ip address 192.168.20.1 255.255.255.0
exit

interface g0/0/1.30
encapsulation dot1q 30
description Operations Network
ip address 192.168.30.1 255.255.255.0
exit

interface g0/0/1.1000
encapsulation dot1q 1000 native
description Native VLAN
exit

```
## Script config for Switch 1

```bash
enable
conf t

hostname S-1
no ip domain lookup

enable secret class

line console 0
password cisco
login
exit

line vty 0 4
password cisco
login

service password-encryption

banner motd $Configuracion basica de switch unicamente se permite el acceso autorizado!$
exit

copy running-config startup-config

clock set 8:00:00 April 12 2024

conf t

vlan 10
name Management
vlan 20
name Sales
vlan 30
name Operations
vlan 999
name Parking_Lot
vlan 1000
name Native
exit

interface vlan 10
ip address 192.168.10.11 255.255.255.0
no shutdown
exit
ip default-gateway 192.168.10.1

interface range f0/2 - 4 , f0/7 - 24 , g0/1 - 2
switchport mode access
switchport access vlan 999
shutdown
exit

interface f0/6
switchport mode access
switchport access vlan 20
exit

interface f0/1
switchport mode trunk
switchport trunk native vlan 1000
switchport trunk allowed vlan 10,20,30,1000
exit

interface f0/5
switchport mode trunk
switchport trunk native vlan 1000
switchport trunk allowed vlan 10,20,30,1000
exit
exit

copy running-config startup-config

```

## Script config for Switch 2

```bash
enable
conf t

hostname S-1
no ip domain lookup

enable secret class

line console 0
password cisco
login
exit

line vty 0 4
password cisco
login

service password-encryption

banner motd $Configuracion basica de switch unicamente se permite el acceso autorizado!$
exit

copy running-config startup-config

clock set 8:00:00 April 12 2024

conf t

vlan 10
name Management
vlan 20
name Sales
vlan 30
name Operations
vlan 999
name Parking_Lot
vlan 1000
name Native
exit

interface vlan 10
ip address 192.168.10.12 255.255.255.0
no shutdown
exit
ip default-gateway 192.168.10.1

interface range f0/2 - 17 , f0/19 - 24 , g0/1 - 2
switchport mode access
switchport access vlan 999
shutdown
exit

interface f0/18
switchport mode access
switchport access vlan 30
exit

interface f0/1
switchport mode trunk
switchport trunk native vlan 1000
switchport trunk allowed vlan 10,20,30,1000
exit
exit

copy running-config startup-config

```