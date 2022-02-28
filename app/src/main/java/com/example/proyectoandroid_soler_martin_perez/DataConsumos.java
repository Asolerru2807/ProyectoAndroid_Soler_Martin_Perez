package com.example.proyectoandroid_soler_martin_perez;

public class DataConsumos {

    /*
     * Objeto que almacena los datos de cada consumo de un usuario
     */
    double datosConsumidos, costeDatos, costeLlamadas, costeMensajes;
    int minutosLlamadas, mensajesEnviados;
    String correo, dia;

    public DataConsumos(double datosConsumidos, double costeDatos, double costeLlamadas, double costeMensajes, int minutosLlamadas, int mensajesEnviados, String correo, String dia) {
        this.datosConsumidos = datosConsumidos;
        this.costeDatos = costeDatos;
        this.costeLlamadas = costeLlamadas;
        this.costeMensajes = costeMensajes;
        this.minutosLlamadas = minutosLlamadas;
        this.mensajesEnviados = mensajesEnviados;
        this.correo = correo;
        this.dia = dia;
    }

    public double getDatosConsumidos() {
        return datosConsumidos;
    }

    public void setDatosConsumidos(double datosConsumidos) {
        this.datosConsumidos = datosConsumidos;
    }

    public double getCosteDatos() {
        return costeDatos;
    }

    public void setCosteDatos(double costeDatos) {
        this.costeDatos = costeDatos;
    }

    public double getCosteLlamadas() {
        return costeLlamadas;
    }

    public void setCosteLlamadas(double costeLlamadas) {
        this.costeLlamadas = costeLlamadas;
    }

    public double getCosteMensajes() {
        return costeMensajes;
    }

    public void setCosteMensajes(double costeMensajes) {
        this.costeMensajes = costeMensajes;
    }

    public int getMinutosLlamadas() {
        return minutosLlamadas;
    }

    public void setMinutosLlamadas(int minutosLlamadas) {
        this.minutosLlamadas = minutosLlamadas;
    }

    public int getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(int mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
