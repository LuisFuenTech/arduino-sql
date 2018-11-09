# Arduino - Control de acceso
Proyecto que integra la tecnología de microcontrolador Arduino y el SGBD MySQL con el objeto de crear un sistema de acceso para permitir 
la entrada a personas en un área determinada. El acceso se realiza a través de una tarjeta RFID y una clave personal.

Componentes del sistema
* Arduino Uno
* Pad RFID
* Tarjeta RFID 

## Instalación
* Para la correcta instalación del proyecto, es necesario descargar el conector `mysql-connector-java-8.0.11.jar` y pegarlo en la ruta 
`C:\Program Files\Java\jre1.8.0_191\lib\ext`.
* La carpeta `Wiegand_Java` contiene el archivo con el códgio fuente para cargar en el arduino.
* La carpeta `Librería Wiegand` debe ser copiada en la ruta `C:\Program Files(x86)\Arduino\libraries`. Esta librería es requerida para cargar correctamente  el código fuente a Arduino.

## Descarga
`https://dev.mysql.com/downloads/connector/j/8.0.html`.