const unsigned int trigger = 23200;

void setup() {
  pinMode(D0,OUTPUT);
  pinMode(D1,INPUT);

  digitalWrite(D0,LOW);

  unsigned long t1, t2;
}

void loop() {
  digitalWrite(D1, HIGH);
  delayMicroseconds(10);
  digitalWrite(D1, LOW);

  while(digitalRead(D0)==0);

  t1 = micros();
  while(digitalRead(D0)==1);
  t2 = micros();

  if((t2-t1) < trigger){
    digitalWrite(D2,HIGH);
    }
}
