package com.example.pim_iv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

                    /*AQUI TENQ A O EMAIL E A SENHA FORAM ATRIBUIDOS AS VARIAVEIS "EmailInserido" E
                    "SenhaInserida" RESPECTIVAMENTE (ISSO TUDO NA TEORIA NÉ) */


                    // Defina o email e senha corretos
                    String emailCorreto = "jota";
                    String senhaCorreta = "123";

                    // Verificação de email e senha
                    if (EmailInserido.equals(emailCorreto) && SenhaInserida.equals(senhaCorreta)) {
                        // Se correto, passar para a próxima Activity
                        Intent intent = new Intent(MainActivity.this, TelaCatalogo.class);
                        startActivity(intent);
                    } else {
                        // Se incorreto, mostrar uma mensagem de erro
                        Toast.makeText(MainActivity.this, "Email ou senha incorreto", Toast.LENGTH_SHORT).show();
                    }
                }

            });


    }

    public void CriarConta(View view) {

        Intent intent = new Intent(MainActivity.this, CriarContaActivity.class);
        startActivity(intent);
    }
}
