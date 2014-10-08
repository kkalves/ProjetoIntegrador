package table;

import java.util.ArrayList;

/**
 *
 * @author Giseli e Keyve
 */
public class FormatoTabela {
    
    ArrayList<String> cabecalho = new ArrayList<String>();;
    
    ArrayList<String[]> dados = new ArrayList<String[]>();
    
    public FormatoTabela() {
    }

    public ArrayList<String> getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(ArrayList<String> cabecalho) {
        this.cabecalho = cabecalho;
    }

    public ArrayList<String[]> getDados() {
        return dados;
    }

    public void setDados(ArrayList<String[]> dados) {
        this.dados = dados;
    }
    
    public String[][] getRowData (){
     String[][] data = new String[dados.size()][cabecalho.size()];
     
     for (int i = 0; i < dados.size(); i++) {
        data[i] = dados.get(i);            
        }     
     
     return data;
    }
    
    public String[] getColumnData(){
    String [] data = new String[cabecalho.size()];
    
    for (int i = 0; i < cabecalho.size(); i++) {
            data[i] = cabecalho.get(i);            
        }      
    
    return data;
    }
}
