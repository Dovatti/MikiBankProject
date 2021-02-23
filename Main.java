import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int scelta, loginCheck = 0;
        Scanner input = new Scanner(System.in);
        //datiCorrentista Dati[] = new datiCorrentista[16];
        //ArrayList<datiCorrentista> giuseppe = Controllo();

        //ListaCorrentisti salvataggioCorrentisti = new ListaCorrentisti();
        //esporta(salvataggioCorrentisti);

        ListaCorrentisti salvataggioCorrentisti = importa();
        ArrayList<datiCorrentista> listaUtenti = salvataggioCorrentisti.getListaCorrentisti();
        ArrayList<Conto> listaConti = null;
        //datiCorrentista correntista = new datiCorrentista();
        //datiCorrentista correntista = importa();
        //datiCorrentista correntista = new datiCorrentista();
        //salvataggio(correntista);
        float soldiA = 0, soldiB = 0;
        int posizioneA = 0, posizioneB = 0;

        System.out.println("Benvenuto in MikiBank (Registered to Robin Dabank)! La banca più trasparente dell'acqua!");

        //do-while con switch per gestire la Login Zone
        do {
            System.out.println("Digita 0 per uscire, digita 1 per eseguire il login");
            scelta = Integer.parseInt(input.nextLine());
            switch (scelta) {
                case 0:
                    System.out.println("    Uscita dalla Login Zone    ");
                    break;

                case 1:
                    System.out.println("    Login Zone    ");
                    System.out.println("    Inserisca il nome utente    ");
                    String nomeUtente = input.nextLine();

                    System.out.println("    Inserisca la password    ");
                    String password = input.nextLine();

                    File file = new File("login.txt");

                    Scanner login = new Scanner(file);

                    String nome1 = login.nextLine();
                    String nome2 = login.nextLine();

                    if (nomeUtente.equals(nome1) && password.equals(nome2)) {
                        System.out.println("Login corretto!");
                        loginCheck = 1;
                    }
                    break;
                case 2:
                    salvataggioCorrentisti = new ListaCorrentisti();
                    listaUtenti = salvataggioCorrentisti.getListaCorrentisti();
                    esporta(salvataggioCorrentisti);
                    break;
            }

        } while (loginCheck != 1);

        do {
            System.out.println("    Centro di Amministrazione    ");
            System.out.println("Scelga una voce dal seguente menù");
            System.out.println("0 ~ Uscita e pulizia della memoria");
            System.out.println("1 ~ Visualizzazione Scheda Identificativa Cliente");
            System.out.println("2 ~ Registrazione Scheda Identificativa Cliente");
            System.out.println("3 ~ Apertura di un conto");
            System.out.println("4 ~ Gestione di un conto");
            System.out.println("5 ~ Chiusura di un conto");
            scelta = Integer.parseInt(input.nextLine());
            switch (scelta) {
                case 0:
                    System.gc();
                    System.exit(0);
                    break;

                case 1:
                    //Visualizzazione SIC
                    System.out.println("    Scheda Identificativa Cliente   ");
                    for (int i = 0; i < listaUtenti.size(); i++) {
                        try {
                            System.out.println(i + ": " + listaUtenti.get(i).toString());
                        } catch (NullPointerException e) {
                            System.out.println(i + ": " + "vuoto");
                        }
                    }
                    break;

                case 2:
                    //Registrazione SIC
                    String setGenereT, setCognomeT, setNomeT, setDataNascitaT, setLuogoNascitaT, setResidenzaT, setCittadinanzaT, setStatoCivileT, setCodiceFiscale;
                    System.out.println("    Inizializzazione Scheda Identificativa Cliente  ");
                    System.out.println("Il correntista è un maschio o una femmina?");
                    setGenereT = input.nextLine();
                    System.out.println("Cognome del correntista: ");
                    setCognomeT = input.nextLine();
                    System.out.println("Nome del correntista: ");
                    setNomeT = input.nextLine();
                    System.out.println("Data di nascita del correntista: ");
                    setDataNascitaT = input.nextLine();
                    System.out.println("Luogo di nascita del correntista: ");
                    setLuogoNascitaT = input.nextLine();
                    System.out.println("Via, città e stato di residenza del correntista: ");
                    setResidenzaT = input.nextLine();
                    System.out.println("Cittadinanza del correntista: ");
                    setCittadinanzaT = input.nextLine();
                    System.out.println("Stato civile del correntista: ");
                    setStatoCivileT = input.nextLine();
                    System.out.println("Inserisci il codice fiscale: ");
                    setCodiceFiscale = input.nextLine();

                    datiCorrentista dato = new datiCorrentista(setCognomeT, setNomeT, setCodiceFiscale, setGenereT, setDataNascitaT, setLuogoNascitaT, setResidenzaT, setCittadinanzaT, setStatoCivileT, true, setGenereT, true);

                    listaUtenti.add(dato);

                    salvataggioCorrentisti.setListaCorrentisti(listaUtenti);
                    esporta(salvataggioCorrentisti);
                    break;

                case 3:
                    //Apertura conto
                    System.out.println("Scegli il tipo di conto:\n");
                    System.out.println("1)Canone fisso");
                    System.out.println("2)Senza canone");
                    System.out.println("3)Deposito");

                    int tipoConto = Integer.parseInt(input.nextLine());

                    System.out.println("Inserisci il codice fiscale dell'intestatario: ");
                    String codiceFiscale = input.nextLine();

                    salvataggioCorrentisti = importa();
                    listaUtenti = salvataggioCorrentisti.getListaCorrentisti();

                    int posizione = -1;
                    for (int i = 0; i < listaUtenti.size(); i++) {
                        if (codiceFiscale.equals(listaUtenti.get(i).getCodiceFiscale())) {
                            posizione = i;
                        }
                    }

                    datiCorrentista utenteTemp = listaUtenti.get(posizione);
                    String iban = generaIban();
                    Conto contoTemp = new Conto(tipoConto, iban);

                    utenteTemp.addConto(contoTemp);
                    listaUtenti.set(posizione, utenteTemp);

                    salvataggioCorrentisti.setListaCorrentisti(listaUtenti);
                    esporta(salvataggioCorrentisti);
                    System.out.println("Conto creato correttamente!");

                    break;
                case 4:
                    //Gestione conto
                    salvataggioCorrentisti = importa();
                    listaUtenti = salvataggioCorrentisti.getListaCorrentisti();

                    visualizzaConti();

                    System.out.println("Inserisci l'iban del conto: ");
                    iban = input.nextLine();

                    posizioneA = -1;
                    posizioneB = -1;

                    for (int i = 0; i < listaUtenti.size(); i++) {
                        utenteTemp = listaUtenti.get(i);
                        listaConti = utenteTemp.getListaConti();
                        for (int j = 0; j < listaConti.size(); j++) {
                            if (iban.equals(listaConti.get(j).getIban())) {
                                posizioneA = i;
                                posizioneB = j;
                            }
                        }
                    }

                    utenteTemp = listaUtenti.get(posizioneA);
                    contoTemp = utenteTemp.getListaConti().get(posizioneB);

                    if (contoTemp.getDisponibilita()) {
                        System.out.println("Intestatario: " + utenteTemp.getNome() + " " + utenteTemp.getCognome());
                        System.out.println("Iban: " + contoTemp.getIban());
                        System.out.println("Data valuta: " + contoTemp.getDataValuta());
                        System.out.println("Data contabile: " + contoTemp.getDataContabile());

                        System.out.println("\n Cosa vuoi fare?");
                        System.out.println("1)Deposita denaro");
                        System.out.println("2)Preleva denaro");

                        scelta = Integer.parseInt(input.nextLine());

                        switch (scelta) {
                            case 1:
                                System.out.println("\n Inserisci la somma da depositare: ");
                                scelta = Integer.parseInt(input.nextLine());

                                soldiA = contoTemp.getDataContabile();
                                soldiB = contoTemp.getDataValuta();

                                soldiA += scelta;
                                soldiB += scelta;

                                contoTemp.setDataContabile(soldiA);
                                contoTemp.setDataValuta(soldiB);

                                listaConti = utenteTemp.getListaConti();
                                listaConti.set(posizioneB, contoTemp);

                                utenteTemp.setListaConti(listaConti);
                                listaUtenti.set(posizioneA, utenteTemp);
                                salvataggioCorrentisti.setListaCorrentisti(listaUtenti);
                                esporta(salvataggioCorrentisti);
                                break;
                            case 2:
                                System.out.println("\n Inserisci la somma da prelevare: ");
                                scelta = Integer.parseInt(input.nextLine());

                                soldiA = contoTemp.getDataContabile();
                                soldiB = contoTemp.getDataValuta();

                                if (soldiA >= scelta) {
                                    soldiA -= scelta;
                                    soldiB -= scelta;

                                    contoTemp.setDataContabile(soldiA);
                                    contoTemp.setDataValuta(soldiB);

                                    listaConti = utenteTemp.getListaConti();
                                    listaConti.set(posizioneB, contoTemp);

                                    utenteTemp.setListaConti(listaConti);
                                    listaUtenti.set(posizioneA, utenteTemp);
                                    salvataggioCorrentisti.setListaCorrentisti(listaUtenti);
                                    esporta(salvataggioCorrentisti);
                                } else {
                                    System.out.println("Impossibile, sei povero non hai abbastanza soldi");
                                }
                                break;
                        }
                    } else {
                        System.out.println("Questo conto è bloccato");
                    }
                    break;

                case 5:
                    //Chiusura conto
                    visualizzaConti();
                    System.out.println("Inserisci l'IBAN del conto: ");

                    iban = input.nextLine();

                    for (int i = 0; i < listaUtenti.size(); i++) {
                        utenteTemp = listaUtenti.get(i);
                        listaConti = utenteTemp.getListaConti();
                        for (int j = 0; j < listaConti.size(); j++) {
                            if (iban.equals(listaConti.get(j).getIban())) {
                                posizioneA = i;
                                posizioneB = j;
                            }
                        }
                    }

                    utenteTemp = listaUtenti.get(posizioneA);
                    contoTemp = utenteTemp.getListaConti().get(posizioneB);

                    System.out.println("Intestatario: " + utenteTemp.getNome() + " " + utenteTemp.getCognome());
                    System.out.println("Iban: " + contoTemp.getIban());
                    System.out.println("Data valuta: " + contoTemp.getDataValuta());
                    System.out.println("Data contabile: " + contoTemp.getDataContabile());

                    System.out.println("\n Cosa vuoi fare?");
                    System.out.println("1 ~ Bloccare conto");
                    System.out.println("2 ~ Sbloccare conto");

                    scelta = Integer.parseInt(input.nextLine());

                    switch (scelta) {
                        case 1:
                            contoTemp.setDisponibilita(false);
                            break;
                        case 2:
                            contoTemp.setDisponibilita(true);
                            break;
                    }
                    listaConti = utenteTemp.getListaConti();
                    listaConti.set(posizioneB, contoTemp);

                    utenteTemp.setListaConti(listaConti);
                    listaUtenti.set(posizioneA, utenteTemp);
                    salvataggioCorrentisti.setListaCorrentisti(listaUtenti);
                    esporta(salvataggioCorrentisti);

                    System.out.println("Modifica effettuata con successo");
                    break;

                default:
                    System.out.println("La selezione da lei effettuata non corrisponde a nessuna voce sopra indicata! Riprovare per cortesia.");
                    break;
            }

        } while (scelta != 0);
    }

    public static void Lettura() {
        try {
            File file = new File("Demo.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contenuto del file: ");
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<datiCorrentista> Controllo() throws Exception {
        File controllo = new File("dati.txt");
        ArrayList<datiCorrentista> elencocorrentisti;
        if (controllo.exists()) {
            FileInputStream inputStream = new FileInputStream(controllo);
            ObjectInputStream reader = new ObjectInputStream(inputStream);
            //noinspection unchecked
            elencocorrentisti = (ArrayList<datiCorrentista>) reader.readObject();
            reader.close();
            inputStream.close();
        } else {
            elencocorrentisti = new ArrayList<datiCorrentista>();
        }
        return elencocorrentisti;
    }

    public static void esporta(ListaCorrentisti listaCorrentisti) {
        try {
            FileOutputStream f = new FileOutputStream(new File("listaUtenti.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(listaCorrentisti);
            o.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ListaCorrentisti importa() {
        try {
            FileInputStream fi = new FileInputStream(new File("listaUtenti.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            ListaCorrentisti listaCorrentisti = (ListaCorrentisti) oi.readObject();
            oi.close();

            return listaCorrentisti;
        } catch (Exception e) {
            e.printStackTrace();
            ListaCorrentisti salvataggioutenti = new ListaCorrentisti();
            esporta(salvataggioutenti);
            return salvataggioutenti;
        }
    }

    public static void visualizzaConti() {
        ListaCorrentisti salvataggioCorrentisti = importa();
        ArrayList<datiCorrentista> listaUtenti = salvataggioCorrentisti.getListaCorrentisti();

        int conta = 1;
        for (int i = 0; i < listaUtenti.size(); i++) {
            datiCorrentista utenteTemp = listaUtenti.get(i);
            ArrayList<Conto> listaConti = utenteTemp.getListaConti();
            for (int j = 0; j < listaConti.size(); j++) {
                System.out.println("Conto numero " + conta + "\t IBAN: " + listaConti.get(j).getIban() + "\t Saldo disponibile: " + listaConti.get(j).getDataContabile());
                conta++;
            }
        }
    }

    public static String generaIban() {
        String base = "0123456789ABCDEFGHILMNOPQRSTUVZ";
        String iban = "IT";

        for (int i = 0; i < 25; i++) {
            iban += base.charAt((int) (Math.random() * 31));
        }

        ListaCorrentisti salvataggiCorrentisti = importa();
        ArrayList<datiCorrentista> listaUtenti = salvataggiCorrentisti.getListaCorrentisti();

        while (verificaIban(iban)) {
            iban = generaIban();
        }
        return iban;
    }

    //metodo che verifica se l'iban è già presente nei dati del correntista
    public static boolean verificaIban(String iban) {
        ListaCorrentisti salvataggiCorrentisti = importa();
        ArrayList<datiCorrentista> listaUtenti = salvataggiCorrentisti.getListaCorrentisti();

        for (int i = 0; i < listaUtenti.size(); i++) {
            datiCorrentista utenteTemp = listaUtenti.get(i);
            ArrayList<Conto> listaConti = utenteTemp.getListaConti();

            for (int j = 0; j < listaConti.size(); j++) {
                if (iban.equals(listaConti.get(j).getIban())) {
                    return true;
                }
            }
        }

        return false;
    }
}
