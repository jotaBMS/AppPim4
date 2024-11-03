package com.example.pim_iv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class ConfirmacaoPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacao_pedido);


// MainActivity

        };

    public void IrTelaInicial(View view) {

        Intent intent = new Intent(ConfirmacaoPedidoActivity.this, TelaCatalogo.class);
        startActivity(intent);
    }


}
