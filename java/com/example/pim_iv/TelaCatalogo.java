package com.example.pim_iv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pim_iv.API.ApiService;
import com.example.pim_iv.API.RetrofitCliente;
import com.example.pim_iv.model.Pedido;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaCatalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_catalogo);

        // Referências dos elementos
        CheckBox checkTomate = findViewById(R.id.checkTomate);
        EditText qtdTomate = findViewById(R.id.Qtd_Tomate);

        CheckBox checkUva = findViewById(R.id.checkUva);
        EditText qtdUva = findViewById(R.id.Qtd_Uva);

        CheckBox checkBatata = findViewById(R.id.checkBatata);
        EditText qtdBatata = findViewById(R.id.Qtd_Batata);

        CheckBox checkBeteraba = findViewById(R.id.checkBeteraba);
        EditText qtdBeteraba = findViewById(R.id.Qtd_Beteraba);

        CheckBox checkCebola = findViewById(R.id.checkCebola);
        EditText qtdCebola = findViewById(R.id.Qtd_Cebola);

        Button confirmarPedido = findViewById(R.id.ConfirmarPedido);

        // Preços dos itens
        final double precoTomate = 100.00;
        final double precoUva = 50.00;
        final double precoBatata = 280.80;
        final double precoBeteraba = 450.20;
        final double precoCebola = 360.00;

        confirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = 0.0;

                // Verificar cada checkbox e calcular o total
                if (checkTomate.isChecked()) {
                    total += calcularPreco(qtdTomate, precoTomate);
                }
                if (checkUva.isChecked()) {
                    total += calcularPreco(qtdUva, precoUva);
                }
                if (checkBatata.isChecked()) {
                    total += calcularPreco(qtdBatata, precoBatata);
                }
                if (checkBeteraba.isChecked()) {
                    total += calcularPreco(qtdBeteraba, precoBeteraba);
                }
                if (checkCebola.isChecked()) {
                    total += calcularPreco(qtdCebola, precoCebola);
                }

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                String data = formatter.format(new Date());

                ApiService api = RetrofitCliente.getRetrofitInstance().create(ApiService.class);
                Pedido pedido = new Pedido(2, data, total, "em espera");

                Call<Pedido> call = api.fazerPedido(pedido);

                call.enqueue(new Callback<Pedido>() {
                    @Override
                    public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Toast.makeText(TelaCatalogo.this, "Compra realizada com sucesso.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(TelaCatalogo.this, ConfirmacaoPedidoActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(TelaCatalogo.this, "Erro na compra. Código: " + response.code(), Toast.LENGTH_LONG).show();
                            // Log adicional
                            if (response.errorBody() != null) {
                                try {
                                    String erro = response.errorBody().string();
                                    System.out.println("Erro do servidor: " + erro);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Pedido> call, Throwable throwable) {

                    }
                });



            }
        });
    }

    // Função para calcular o preço com base na quantidade
    private double calcularPreco(EditText editText, double preco) {
        String quantidadeTexto = editText.getText().toString();
        if (!quantidadeTexto.isEmpty()) {
            int quantidade = Integer.parseInt(quantidadeTexto);
            return quantidade * preco;
        }
        return 0.0;
    }
}
