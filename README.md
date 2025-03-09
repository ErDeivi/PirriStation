# PirriStation

## Requisitos previos

1. Java 21 o superior
2. MySQL 8.0 o superior instalado y configurado

### Base de datos
La aplicación espera:
- Nombre de la base de datos: pirristation
- Usuario: root
- Contraseña: (vacía)

## Funcionalidades
- Exportación de base de datos con fecha y hora
- Importación de backups
- Los backups se guardan en la carpeta `backups` del proyecto

## Estructura del proyecto
```
PirriStation/
├── backups/           # Carpeta donde se guardan los backups
└── src/              # Código fuente
```

## Notas de instalación
Asegúrate de que los comandos `mysql` y `mysqldump` estén disponibles en el PATH del sistema. Puedes verificarlo abriendo una terminal y ejecutando:
```
mysql --version
mysqldump --version
```
