package java.factureanalyse.bean;

public class FactureAnalyse {
	  private int id_facture;
	    private int id_analyse_souhaitee;
	    
	public FactureAnalyse() {
		// TODO Auto-generated constructor stub
	}
	// Getters et Setters
    public int getId_facture() {
        return id_facture;
    }
    
    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }
    
    public int getId_analyse_souhaitee() {
        return id_analyse_souhaitee;
    }
    
    public void setId_analyse_souhaitee(int id_analyse_souhaitee) {
        this.id_analyse_souhaitee = id_analyse_souhaitee;
    }
    
    @Override
    public String toString() {
        return "FactureAnalyse{id_facture=" + id_facture + 
               ", id_analyse=" + id_analyse_souhaitee + "}";
    }
}
