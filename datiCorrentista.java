import java.io.Serializable;
import java.util.ArrayList;

public class datiCorrentista implements Serializable {
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private String dataNascita;
    private String luogoNascita;
    private String residenza;
    private String provincia;
    private String cittadinanza;
    private String statoCivile;
    private boolean accreditoStipendio;
    private String genere;
    private boolean clienteRegistrato;
    private ArrayList<Conto> listaConti = new ArrayList<Conto>();

    public ArrayList<Conto> getListaConti() {
        return listaConti;
    }

    public void setListaConti(ArrayList<Conto> listaConti) {
        this.listaConti = listaConti;
    }

    public void addConto(Conto contoTemp){
        this.listaConti.add(contoTemp);
    }

    public datiCorrentista(String cognome, String nome, String codiceFiscale, String provincia, String dataNascita, String luogoNascita, String residenza, String cittadinanza, String statoCivile, boolean accreditoStipendio, String genere, boolean clienteRegistrato) {
        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.provincia = provincia;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.residenza = residenza;
        this.cittadinanza = cittadinanza;
        this.statoCivile = statoCivile;
        this.accreditoStipendio = accreditoStipendio;
        this.genere = genere;
        this.clienteRegistrato = clienteRegistrato;
    }



    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public  void setNome(String nome) {
        this.nome = nome;
    }

    public  String getCodiceFiscale() {
        return codiceFiscale;
    }

    public  void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public  String getDataNascita() {
        return dataNascita;
    }

    public  void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public  String getLuogoNascita() {
        return luogoNascita;
    }

    public  void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public  String getResidenza() {
        return residenza;
    }

    public  void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public  String getProvincia() {
        return provincia;
    }

    public  void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public  String getCittadinanza() {
        return cittadinanza;
    }

    public  void setCittadinanza(String cittadinanza) {
        this.cittadinanza = cittadinanza;
    }

    public  String getStatoCivile() {
        return statoCivile;
    }

    public  void setStatoCivile(String statoCivile) {
        this.statoCivile = statoCivile;
    }

    public  boolean isAccreditoStipendio() {
        return accreditoStipendio;
    }

    public  void setAccreditoStipendio(boolean accreditoStipendio) {
        this.accreditoStipendio = accreditoStipendio;
    }

    public  String getGenere() {
        return genere;
    }

    public  void setGenere(String genere) {
        this.genere = genere;
    }

    public  boolean isClienteRegistrato() {
        return clienteRegistrato;
    }

    public  void setClienteRegistrato(boolean clienteRegistrato) {
        this.clienteRegistrato = clienteRegistrato;
    }

    public String toString() {
        return "datiCorrentista{" +
                "cognome='" + getCognome() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", codiceFiscale='" + getCodiceFiscale() + '\'' +
                ", dataNascita='" + getDataNascita() + '\'' +
                ", luogoNascita='" + getLuogoNascita() + '\'' +
                ", residenza='" + getResidenza() + '\'' +
                ", provincia='" + getProvincia() + '\'' +
                ", cittadinanza='" + getCittadinanza() + '\'' +
                ", statoCivile='" + getStatoCivile() + '\'' +
                ", accreditoStipendio=" + isAccreditoStipendio() +
                ", genere='" + getGenere() + '\'' +
                ", clienteRegistrato=" + isClienteRegistrato() +
                '}';
    }


}

