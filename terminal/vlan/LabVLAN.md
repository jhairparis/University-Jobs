# Lab - Implement Inter-VLAN Routing​ 

![Topology](../src/topology%20vlan%20lab.png)

## Scrip config for Router

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
exec-timeout 0 0

line vty 0 15
login local
exec-timeout 0 0
password cisco
login local
exit


service password-encryption
banner motd $Configuracion basica de router unicamente se permite el acceso autorizado! att: David Mora y Jhair Paris$
exit

clock set 7:48:00 April 8 2024

show running-config
```
## Scrip config for Switch 

```bash
enable
configure terminal
hostname S-1
no ip domain lookup
enable secret class
line 0
exit
line console 0
password cisco
login
exit
line vty 0 15
exec-timeout 0 0
password cisco
login local
exit
service password-encryption
banner motd $Configuracion basica de switch unicamente se permite el acceso autorizado! att: David Mora y Jhair Paris$
exit
clock set 8:01:00 April 04 2024
copy running-config startup-config
```