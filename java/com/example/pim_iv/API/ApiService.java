package com.example.pim_iv.API;

import com.example.pim_iv.model.Login;
import com.example.pim_iv.model.LoginResponse;
import com.example.pim_iv.model.Pedido;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("Usuario/Verifica-senha")
    Call<LoginResponse> verificarLogin(@Body Login login);

   @POST("Pedido")
   Call<Pedido> fazerPedido(@Body Pedido usuario);

   //@POST("Pedido/criar")
   // Call<Venda> criarVenda(@Body Venda venda);


}
