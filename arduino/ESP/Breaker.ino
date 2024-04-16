#include <HTTPClient.h>
#include <WiFi.h>

const char *ssid = "";
const char *password = "";

String LED_id = "1";
bool toggle_pressed = false;
String data_to_send = "";
unsigned int Actual_Millis, Previous_Millis;
int refresh_time = 200;

int button1 = 13;
int LED = 2;

void IRAM_ATTR isr()
{
  toggle_pressed = true;
}

void setup()
{
  delay(10);
  Serial.begin(921600);
  pinMode(LED, OUTPUT);
  pinMode(button1, INPUT_PULLDOWN);
  attachInterrupt(button1, isr, RISING);

  WiFi.begin(ssid, password);
  Serial.print("Connecting...");
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }

  Serial.print("Connected, my IP: ");
  Serial.println(WiFi.localIP());
  Actual_Millis = millis();
  Previous_Millis = Actual_Millis;
}

void loop()
{
  Actual_Millis = millis();

  if (Actual_Millis - Previous_Millis > refresh_time)
  {
    Previous_Millis = Actual_Millis;

    if (WiFi.status() == WL_CONNECTED)
    {
      HTTPClient http;
      if (toggle_pressed)
      {
        data_to_send = "toggle_LED=" + LED_id;
        toggle_pressed = false;
      }
      else
      {
        data_to_send = "check_LED_status=" + LED_id;
      }

      http.begin(""); // page
      http.addHeader("Content-Type", "application/x-www-form-urlencoded");

      int response_code = http.POST(data_to_send);

      if (response_code > 0)
      {
        Serial.println("HTTP code " + String(response_code));

        if (response_code == 200)
        {
          String response_body = http.getString();
          Serial.print("Server reply: ");
          Serial.println(response_body);

          if (response_body == "LED_is_off")
          {
            digitalWrite(LED, LOW);
          }
          else if (response_body == "")
          {
            digitalWrite(LED, HIGH);
          }
        }
      }

      else
      {
        Serial.print("Error sending POST, code: ");
        Serial.println(response_code);
      }
      http.end();
    }
    else
    {
      Serial.println("WIFI connection error");
    }
  }
}