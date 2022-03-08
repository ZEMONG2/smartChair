#include <WiFi.h>
#include <HTTPClient.h>

const char* ssid = "1234";              // 변경
const char* password = "12345679";      // 변경
//String ip = " 192.168.22.115";

//const char* ssid = "zemong";              // 변경
//const char* password = "12345678";      // 변경
//String ip = " 192.168.22.115";

//const char* ssid = "SaJa";              // 변경
//const char* password = "saja1004";      // 변경
String ip = "192.168.222.10";

int En0 = 18;  //  Low enabled
int En1 = 19;  //  Low enabled

int S0  = 23;
int S1  = 5;
int S2  = 13;
int S3  = 12;

int SIG_pin = 34;
int SERVER_PORT = 8081;

String port = "8081";
String baseName = "http://" + ip + ":" + port;

WiFiClient client;

void setup() {
  Serial.begin(115200);

  pinMode(En0, OUTPUT);
  pinMode(En1, OUTPUT);

  pinMode(S0, OUTPUT);
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT);

  Serial.print("SSID: ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.println("Connecting to WiFi..");
  }
  Serial.println("Connected to the WiFi network");
}

void loop() {
  String value;

  int LB = 0;  //LeftBottom
  int LC = 0;  //LeftCenter
  int LT = 0;  //LeftTop

  int RB = 0;  //RightBottom
  int RC = 0;  //RightCenter
  int RT = 0;  //RightTop

  for (int i = 0; i < 32; i ++) {
    int result = readMux(i);
//    if(i<=4){
//       LB += result;
//    }else if(){
//      
//    }else if(){
//      
//    }else if(){
//      
//    }else if(){
//      
//    }else if(){
//      
//    }
    if (i <= 4) {
      LB += result;
    } else if ((5 <= i)||(i <= 13) && (i != 10) && i != 12) {
      LC += result;
    } else if ((i == 10) || (i == 12) || (i == 14)) {
      LT += result;
    } else if ((i == 16) || (i == 18) || (i == 20)) {
      RT += result;
    } else if ((17 <= i)||(i<= 25)&&( i != 18)&&(i != 20)) {
      RC += result;
    } else if ((26 <= i )&& (i<= 31)) {
      RB += result;
    }
  }

  Serial.println("LB:" + String(LB) + "   LC:" + String(LC) + "   LT:" + String(LT));
  Serial.println("RB:" + String(RB) + "   RC:" + String(RC) + "   RT:" + String(RT));

  if (LB > 500 && LC > 500 && LT > 500 && RB > 500 && RC > 500 && RT > 500) {
    if (LB > LC && LB > LT && LB > RB && LB > RC && LB > RT) {
      value = "LB";
    } else if (LC > LB && LC > LT && LC > RB && LC > RC && LC > RT) {
      value = "LC";
    } else if (LT > LB && LT > LC && LT > RB && LT > RC && LT > RT) {
      value = "LT";
    } else if (RB > LB && RB > LC && RB > LT && RB > RC && RB > RT) {
      value = "RB";
    } else if (RC > LB && RC > LC && RC > LT && RC > RB && RC > RT) {
      value = "RC";
    } else if (RT > LB && RT > LC && RT > LT && RT > RB && RT > RC) {
      value = "RT";
    } else {
      value = "N";
    }
  } else {
    value = "0";
  }

  delay(100);

  if (WiFi.status() == WL_CONNECTED) {

    HTTPClient http;
    http.begin(baseName + "/smartChair/Test2?");
    http.addHeader("Content-Type", "application/x-www-form-urlencoded");
    String httpRequestData = "sensor=" + value ;
    Serial.println(httpRequestData);

    int httpResponseCode = http.POST(httpRequestData);

    if (httpResponseCode > 0) {
      //      String response = http.getString();
      //    } else {
      Serial.println("Error on sending POST: ");
    }
    http.end();
  } else {
    Serial.println("Error in WiFi connection");
  }
  delay(100);
}

int readMux(int channel) {
  int controlPin[] = {S0, S1, S2, S3, En0, En1};

  int muxChannel[32][6] = {
    {0, 0, 0, 0, 0, 1}, //channel 0
    {0, 0, 0, 1, 0, 1}, //channel 1
    {0, 0, 1, 0, 0, 1}, //channel 2
    {0, 0, 1, 1, 0, 1}, //channel 3
    {0, 1, 0, 0, 0, 1}, //channel 4
    {0, 1, 0, 1, 0, 1}, //channel 5
    {0, 1, 1, 0, 0, 1}, //channel 6
    {0, 1, 1, 1, 0, 1}, //channel 7
    {1, 0, 0, 0, 0, 1}, //channel 8
    {1, 0, 0, 1, 0, 1}, //channel 9
    {1, 0, 1, 0, 0, 1}, //channel 10
    {1, 0, 1, 1, 0, 1}, //channel 11
    {1, 1, 0, 0, 0, 1}, //channel 12
    {1, 1, 0, 1, 0, 1}, //channel 13
    {1, 1, 1, 0, 0, 1}, //channel 14
    {1, 1, 1, 1, 0, 1}, //channel 15
    {0, 0, 0, 0, 1, 0}, //channel 16
    {0, 0, 0, 1, 1, 0}, //channel 17
    {0, 0, 1, 0, 1, 0}, //channel 18
    {0, 0, 1, 1, 1, 0}, //channel 19
    {0, 1, 0, 0, 1, 0}, //channel 20
    {0, 1, 0, 1, 1, 0}, //channel 21
    {0, 1, 1, 0, 1, 0}, //channel 22
    {0, 1, 1, 1, 1, 0}, //channel 23
    {1, 0, 0, 0, 1, 0}, //channel 24
    {1, 0, 0, 1, 1, 0}, //channel 25
    {1, 0, 1, 0, 1, 0}, //channel 26
    {1, 0, 1, 1, 1, 0}, //channel 27
    {1, 1, 0, 0, 1, 0}, //channel 28
    {1, 1, 0, 1, 1, 0}, //channel 29
    {1, 1, 1, 0, 1, 0}, //channel 30
    {1, 1, 1, 1, 1, 0} //channel 31
  };

  //loop through the 6 sig
  for (int i = 0; i < 6; i ++) {
    digitalWrite(controlPin[i], muxChannel[channel][i]);
  }

  //read the value at the SIG pin
  int val = analogRead(SIG_pin);

  //return the value
  return val;
}
