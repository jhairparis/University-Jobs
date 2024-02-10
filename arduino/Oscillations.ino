unsigned long preTime;
unsigned long currentTime;

int pin = 2; // remember connect to pin 2
float timePeriod;
boolean flag = true;
float g, g1=0, T;
int i=0;

void setup(){
  Serial.begin(9600);
  pinMode(pin, INPUT);
  preTime = micros();
  Serial.println("Hello!");
}

void loop(){
  if (digitalRead(pin) == 0)
  {
    if (flag == true)
    {
      currentTime = micros();
      timePeriod = currentTime-preTime;
      preTime = currentTime;
      flag = !flag;

      T=timePeriod/1000000;

      //4π²l is 1.36 change value for l
      g=(1.36/(T*T)); 
      g1=(g1+g)/2.0;

      // print the value of gravity
      if (i%2==0){
        if (g<12 && g>7){
          Serial.println(g);
          g1,g=0;
        }
      }
      i+=1;
    }
    else{
      flag = !flag;
      delay(100);
    }
  }
}