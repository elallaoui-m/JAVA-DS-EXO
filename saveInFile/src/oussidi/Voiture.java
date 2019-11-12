package oussidi;

public class Voiture {
    String designation;
    String model;
    double prix;
    String type;
    
    public Voiture(String designation, String model, double prix, String type) {
        this.designation = designation;
        this.model = model;
        this.prix = prix;
        this.type = type;
    }
    
    @Override
    public String toString() {
        return designation + '|' +model+'|' +prix +"|"+ type+"\n";
    }
}
