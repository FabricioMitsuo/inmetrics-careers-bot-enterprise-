
package br.com.inmetrics.bot.model;

public class Vaga {
    private String titulo;
    private String local;

    public Vaga(String titulo, String local) {
        this.titulo = titulo;
        this.local = local;
    }

    public String getTitulo() { return titulo; }
    public String getLocal() { return local; }
}
