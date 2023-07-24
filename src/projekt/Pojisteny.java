package projekt;

public class Pojisteny {
    public String jmeno; 
    public String prijmeni; 
    public int vek; 
    public int cislo; 
    
    public Pojisteny(String jmeno, String prijmeni, int cislo, int vek)
    {
        this.jmeno = jmeno; 
        this.prijmeni = prijmeni; 
        this.cislo = cislo; 
        this.vek = vek; 
    }
    
    public Pojisteny(String jmeno, String prijmeni)
    {
        this.jmeno = jmeno; 
        this.prijmeni = prijmeni;   
    }
    
    @Override 
    public String toString() {
        return "Jméno: " + jmeno + "\t" + "Příjmení: " + prijmeni + "\t" + "Telefonní číslo: " + cislo + "\t" + "Věk: " + vek + "\t";
    }

    @Override
    public boolean equals(Object obj) {
        Pojisteny pojisteny = (Pojisteny)obj;
        if (this.jmeno.equals(pojisteny.jmeno) && this.prijmeni.equals(pojisteny.prijmeni)) {
            return true; 
        }
        return false; 
    }
}