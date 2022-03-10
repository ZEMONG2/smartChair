#include <ArduinoJson.h>

#include <WiFi.h>
#include <HTTPClient.h>

const char *ssid = "zemong";
const char *password = "12345678";
int in1 = 23; // in1 7번 포트로 제어 (OUT1)
int in2 = 5;  // in2 5번 포트로 제어 (OUT2)
int in3 = 12;
int in4 = 13;
String result = "";
String s;
int cnt = 0;
void setup()
{
  pinMode(18, OUTPUT);
  pinMode(19, OUTPUT);
  pinMode(in1, OUTPUT);
  pinMode(in2, OUTPUT); //각 포트 출력으로 사용
  pinMode(in3, OUTPUT);
  pinMode(in4, OUTPUT); //각 포트 출력으로 사용
  Serial.begin(115200);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.println("Connecting to WiFi..");
  }

  Serial.println("Connected to the WiFi network");
}

void loop()
{

  if ((WiFi.status() == WL_CONNECTED))
  { // Check the current connection status

    HTTPClient http;

    http.begin("http://192.168.111.188:8080/smartChair/Test2");
    // http.begin("http://project-student.ddns.net/nayeho/index.html"); //Specify the URL
    int httpCode = http.GET(); // Make the request

    if (httpCode > 0)
    { // Check for the returning code

      Serial.println(httpCode);
      s = http.getString();
     
      Serial.println("여기까지 됨");

   
      // root 다음에 오는게 이클립스에서
      char led1 = s[0];
      Serial.println("led1: " + (char)led1);
      String led = s;

      Serial.println("led: " + led);
      if (led1 == 'U') //입력된 데이터가 '1'이라면
      {
        digitalWrite(in1, HIGH);
        digitalWrite(in2, LOW); //앞으로 회전
        digitalWrite(in3, HIGH);
        digitalWrite(in4, LOW); //앞으로 회전
      }
      else if (led1 == 'D') //입력된 데이터가 '2'라면
      {
        digitalWrite(in1, LOW);
        digitalWrite(in2, HIGH); //뒤로 회전 (어떤 방향으로 꽂았느냐에 따라서 방향 반대)
        digitalWrite(in3, LOW);
        digitalWrite(in4, HIGH); //앞으로 회전
      }
      else if (led1 == 'S') // 그 이외의 값에서는
      {
        digitalWrite(in1, LOW);
        digitalWrite(in2, LOW); //회전 정지
        digitalWrite(in3, LOW);
        digitalWrite(in4, LOW); //앞으로 회전
      } 
      else if (led1 == 'T') // 그 이외의 값에서는
      {
        digitalWrite(in1, HIGH);
        digitalWrite(in2, LOW); //앞으로 회전
        digitalWrite(in3, HIGH);
        digitalWrite(in4, LOW); //앞으로 회전
      }
    }
    else
    {
      Serial.println("Error on HTTP request");
    }

    http.end(); // Free the resources
  }
  delay(1000);
}
