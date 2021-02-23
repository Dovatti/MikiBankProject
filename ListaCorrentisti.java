import java.io.Serializable;
import java.util.ArrayList;

public class ListaCorrentisti implements Serializable {
    private ArrayList<datiCorrentista> listaCorrentisti = new ArrayList<datiCorrentista>();

    public ListaCorrentisti(){

    }


    public void setListaCorrentisti(ArrayList<datiCorrentista> listaCorrentisti){
        this.listaCorrentisti = listaCorrentisti;
    }

    public ArrayList<datiCorrentista> getListaCorrentisti(){
        return listaCorrentisti;
    }
}
