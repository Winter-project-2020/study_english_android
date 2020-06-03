# 프로젝트 제목 : study english
>번역기를 사용해 영어공부를 좀 더 쉽게 도와주는 앱
## 1.결과물
- 홈 화면
<div>

</div>

- 레벨 화면
<div>
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83613604-fae67d00-a5be-11ea-9b36-0ac6956a89dd.jpg">
</div>

- 일정 화면
<div>
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614132-bc04f700-a5bf-11ea-8ebe-dda40a071a22.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614176-d0e18a80-a5bf-11ea-8bb2-02794345ad40.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614229-e22a9700-a5bf-11ea-8c5a-038a2bdbb475.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614286-f373a380-a5bf-11ea-9338-8acf5b34fe4a.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614416-21f17e80-a5c0-11ea-9077-c96a4d136f55.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614338-071f0a00-a5c0-11ea-9f99-cd437115120f.jpg"> 
  <img width="200" src=""> 
  <img width="200" src="">
</div>

- 내정보 화면
<div>
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83612921-06857400-a5be-11ea-84ea-e0b12f98cbb6.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83613333-94f9f580-a5be-11ea-99ca-bc86c8c158b6.jpg"> 
</div>

## 2. 환경설정
- Build.gradle(Module)
```
//Google Firebase Authentication 
implementation 'com.google.firebase:firebase-auth:19.1.0'
implementation 'com.google.android.gms:play-services-auth:18.0.0'
implementation 'com.google.android.material:material:1.1.0'
implementation 'com.shobhitpuri.custombuttons:google-signin:1.0.0'
//Google Dialogflow(챗봇)
implementation 'ai.api:sdk:2.0.7@aar'
implementation 'ai.api:libai:1.6.12'
// Java V2
implementation 'com.google.cloud:google-cloud-dialogflow:0.67.0-alpha'
implementation 'io.grpc:grpc-okhttp:1.15.1'
```
- Manifest
```
//챗봇, 웹뷰
<uses-permission android:name="android.permission.INTERNET"/> 
```
