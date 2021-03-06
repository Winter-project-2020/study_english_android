프로젝트 제목 : study english
=====================================
>영어공부를 좀 더 쉽고 재미있게 할 수 있도록 도와주는 앱

결과물
-----------------------
### 홈 화면

<div>
  <img width="250" src="https://user-images.githubusercontent.com/43267195/87910748-7c2d9c80-caa5-11ea-91f0-4d8c3fad6d8d.gif">
</div>

### 레벨 화면

<img width="200" src="https://user-images.githubusercontent.com/43267195/83660141-6e0fe380-a5ff-11ea-82b0-d7439ee6ca9e.gif">

### 일정 화면

<div>
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614132-bc04f700-a5bf-11ea-8ebe-dda40a071a22.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614176-d0e18a80-a5bf-11ea-8bb2-02794345ad40.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614229-e22a9700-a5bf-11ea-8c5a-038a2bdbb475.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614286-f373a380-a5bf-11ea-9338-8acf5b34fe4a.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614416-21f17e80-a5c0-11ea-9077-c96a4d136f55.jpg">
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614338-071f0a00-a5c0-11ea-9f99-cd437115120f.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614590-60873900-a5c0-11ea-9b0a-14ff1856ebae.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83614629-6ed55500-a5c0-11ea-803d-7c5fced91098.jpg">
</div>

### 내정보 화면

<div>
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83612921-06857400-a5be-11ea-84ea-e0b12f98cbb6.jpg"> 
  <img width="200" src="https://user-images.githubusercontent.com/43267195/83613333-94f9f580-a5be-11ea-99ca-bc86c8c158b6.jpg"> 
</div>

### 로그인 화면

<div>
  <img width="250" src="https://user-images.githubusercontent.com/43267195/87910888-b72fd000-caa5-11ea-87f0-06c5957c541f.gif">
</div>

```
btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 백그라운드 스레드 실행 */
                Thread th = new Thread(LoginActivity.this);
                th.start();
            }
        });
.
.
.
/* 백그라운드 스레드가 사용하는 함수 */
    @Override
    public void run() {
        /* 사용자의 입력값 */
        String userID = et_id.getText().toString();
        String userPASSWORD = et_password.getText().toString();
        boolean success = false;
        Activity activity = LoginActivity.this;
        try {
            OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormBody.Builder()
                    .add("userID", userID)
                    .add("userPASSWORD", userPASSWORD)
                    .build();
            Request request = new Request.Builder()
                    .url(url_data)
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            response.body().close();

            JSONObject jsonObject = new JSONObject(responseString);
            final String message = jsonObject.getString("message");

            if(message.contains("로그인 되었습니다.")){
                success = true;
                mUserDTO.setUSER_ID(jsonObject.getString("userID"));
                mUserDTO.setUSER_PASSWORD(jsonObject.getString("userPASSWORD"));
            }

            /* 백그라운드 스레드에서 메인UI를 변경할 경우 사용 */
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    name = mUserDTO.getUSER_ID();
                    userFragment.changeLoginStatus(name);
                }
            });

            if(success){
                activity.finish();
            }
        } catch (Exception e) {

        }
    }
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            userFragment.changeLoginStatus(name);
        }
    };
```

### 회원가입 화면

<div>
  <img width="250" src="https://user-images.githubusercontent.com/43267195/88673444-9578bd80-d123-11ea-9780-e3b2c5209efd.PNG">
</div>

환경설정
--------------------------
### Build.gradle(Module)
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

//animated chart
implementation 'com.github.bmarrdev:android-DecoView-charting:v1.2'

//OkHttp3 (Http기반의 request/response하는 라이브러리)
implementation "com.squareup.okhttp3:okhttp:4.8.0"

//Retrofit2, gson (회원가입)
implementation 'com.google.code.gson:gson:2.8.6'
implementation 'com.squareup.retrofit2:converter-gson:2.7.2'

```
### Manifest
```
//챗봇, 웹뷰, OkHttp3
<uses-permission android:name="android.permission.INTERNET"/> 
```
