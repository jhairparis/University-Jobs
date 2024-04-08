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