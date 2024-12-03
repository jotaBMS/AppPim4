package com.example.pim_iv.model;

import com.google.gson.annotations.SerializedName;

public class Pedido {
    @SerializedName("fornecedor")
    int Fornecedor = 2;
    @SerializedName("dataPedido")
    String data;
    @SerializedName("total_PedidosCompra")
    double total_PedidosCompra;
    @SerializedName("status")
    String status = "em espera";

    public Pedido(int fornecedor, String data, double total_PedidosCompra, String status) {
        Fornecedor = fornecedor;
        this.data = data;
        this.total_PedidosCompra = total_PedidosCompra;
        this.status = status;
    }

    public int getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        Fornecedor = fornecedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTotal_PedidosCompra() {
        return total_PedidosCompra;
    }

    public void setTotal_PedidosCompra(double total_PedidosCompra) {
        this.total_PedidosCompra = total_PedidosCompra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
