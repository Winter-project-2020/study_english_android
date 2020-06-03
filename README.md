# 프로젝트 제목 : study english
>번역기를 사용해 영어공부를 좀 더 쉽게 도와주는 앱
## 1.결과물
- 홈 화면
<div>
  
</div>

- 레벨 화면
<div>
  
</div>

- 일정 화면
<div>
  
</div>

- 내정보 화면
<div>
  
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
