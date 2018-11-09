/*
  Código realizado para enviar datos a la aplicación
  de escritorio desarrolada en Java. Los datos que
  arduino envía son:
  -Codigo leído de la tarjeta RFID.
  -Clave ingresada por el pad.
*/
#include <Wiegand.h>

char teclado;   // For incoming serial data
String claveW26, claveW4;

WIEGAND wg;

void setup() {
  pinMode(12, OUTPUT);
  pinMode(13, OUTPUT);
  Serial.begin(9600);
  wg.begin();
}

void loop() {

  if (wg.available())
  {
    if (wg.getWiegandType() == 26)
    {
      claveW26 = String(wg.getCode());      
      Serial.println(claveW26);
    }

    if (wg.getWiegandType() == 4)
    {
      claveW4 = String(wg.getCode()); 
      Serial.println(claveW4);
    }
  }
}



