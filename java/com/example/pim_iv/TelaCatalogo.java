package com.example.pim_iv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TelaCatalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_catalogo);

        //colocando a mensagem de "pedido registrado" quando aperta o botão mas a mensagem aparece no topo da tela
        Button ConfirmarPedido = findViewById(R.id.ConfirmarPedido);


        ConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //teoricamente clica no botão e vai pra proxima tela
                Intent intent = new Intent(TelaCatalogo.this, ConfirmacaoPedidoActivity.class);
                startActivity(intent);
            }
        });
    }
}
