package org.jby.studyenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.shobhitpuri.custombuttons.GoogleSignInButton;

import org.jby.studyenglish.data.UserDTO;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements Runnable, GoogleApiClient.OnConnectionFailedListener {
    GoogleSignInButton googleLogin;
    GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;

    private static final int RC_SIGN_IN = 1000;

    UserFragment userFragment;
    EditText et_id, et_password;
    Button btn_login, btn_signin;
    UserDTO mUserDTO;
    String name;
    final String url_data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        mAuth = FirebaseAuth.getInstance();

        /* 위젯 설정 */
        et_id = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_signin = findViewById(R.id.btn_signin);
        mUserDTO = new UserDTO();
        userFragment = new UserFragment();
        googleLogin = findViewById(R.id.googleLogin);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 백그라운드 스레드 실행 */
                Thread th = new Thread(LoginActivity.this);
                th.start();
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });

        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googleSignInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(googleSignInIntent,RC_SIGN_IN);
            }
        });
    }

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                //구글 로그인 성공해서 파베에 인증
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            }else{
                //구글 로그인 실패
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct){
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "인증 실패", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this, "구글 로그인 인증 성공", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {}
}
