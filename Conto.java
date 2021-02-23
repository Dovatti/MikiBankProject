import java.io.Serializable;

public class Conto implements Serializable {
    private float dataContabile;
    private float dataValuta;
    private int tipoConto;
    private String iban;
    private boolean disponibilita = true;

    public Conto(int tipoConto, String iban) {
        this.tipoConto = tipoConto;
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public float getDataContabile() {
        return dataContabile;
    }

    public void setDataContabile(float dataContabile) {
        this.dataContabile = dataContabile;
    }

    public float getDataValuta() {
        return dataValuta;
    }

    public void setDataValuta(float dataValuta) {
        this.dataValuta = dataValuta;
    }

    public int getTipoConto() {
        return tipoConto;
    }

    public void setTipoConto(int tipoConto) {
        this.tipoConto = tipoConto;
    }

    public boolean getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }
}
