package com.example.pim_iv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pim_iv.API.ApiService;
import com.example.pim_iv.API.RetrofitCliente;
import com.example.pim_iv.model.Login;
import com.example.pim_iv.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            // Referência do botão "Entrar"
            Button BotaoEntrar = findViewById(R.id.BotaoEntrar);

            // Referência do email
            EditText editTextEmail = findViewById(R.id.editTextEmail);

            // Referência da senha
            EditText Senha = findViewById(R.id.Senha);

            // Configurando o listener de clique
            BotaoEntrar.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v)
                {

                    // Pegando o email e inserido na variavel EmailInserido
                    String EmailInserido = editTextEmail.getText().toString();

                    // Pegando a senha e inserido na variavel EmailInserido
                    String SenhaInserida = Senha.getText().toString();

                    ApiService api =  RetrofitCliente.getRetrofitInstance().create(ApiService.class);

                    Login login = new Login (EmailInserido, SenhaInserida);


                    Call <LoginResponse> call = api.verificarLogin(login);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                            LoginResponse loginResponse = response.body();
//                            String mensagem = loginResponse.getMensage();
//                            Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();

                            if(response.isSuccessful() && response.body() != null){
                            Intent intent = new Intent(MainActivity.this, TelaCatalogo.class);
                                startActivity(intent);
                            }else {
                                // Se incorreto, mostrar uma mensagem de erro
                                Toast.makeText(MainActivity.this, "Email ou senha incorreto", Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable throwable) {

                            Toast.makeText(MainActivity.this, "Sem acesso a internet. Conecte-se à internet e tente novamente.", Toast.LENGTH_SHORT).show();

                        }
                    });


                    /*AQUI O EMAIL E A SENHA FORAM ATRIBUIDOS AS VARIAVEIS "EmailInserido" E
                    "SenhaInserida" RESPECTIVAMENTE (ISSO TUDO NA TEORIA NÉ) */


                    // Defina o email e senha corretos
                    //String emailCorreto = "jota";
                    //String senhaCorreta = "123";

                    // Verificação de email e senha
                    /*if (EmailInserido.equals(emailCorreto) && SenhaInserida.equals(senhaCorreta)) {
                        // Se correto, passar para a próxima Activity
                        Intent intent = new Intent(MainActivity.this, TelaCatalogo.class);
                        startActivity(intent);
                    } else {
                        // Se incorreto, mostrar uma mensagem de erro
                        Toast.makeText(MainActivity.this, "Email ou senha incorreto", Toast.LENGTH_SHORT).show();
                    }*/
                }

            });


    }
// botão para ir na parte de criar um login
    public void CriarConta(View view) {

        Intent intent = new Intent(MainActivity.this, CriarContaActivity.class);
        startActivity(intent);
    }
}
