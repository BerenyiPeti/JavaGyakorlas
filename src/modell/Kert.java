package modell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kert {

    private ArrayList<Noveny> novenyek = new ArrayList();
    //private Noveny[] novenyek2= {};

    public Kert() {
        Noveny n1 = new Noveny("no01", "piros növény", 1000, 1);
        Noveny n2 = new Noveny("no02", "zöld növény", 1500, 2);
        Noveny n3 = new Noveny("no03", "kék növény", 2000, 3);
        novenyek.add(n1);
        novenyek.add(n2);
        novenyek.add(n3);
    }

    public Kert(ArrayList<Noveny> novenyek) {
        this.novenyek = novenyek;
    }

    public void NovenyBeszerez(Noveny noveny) {
        novenyek.add(noveny);
    }

    public void novenyElad(String azon) {
        int index = getNovenyIndexByAzon(azon);
        if (index >= 0) {
            novenyek.remove(index);
        } else {
            System.out.println("Nincs ilyen növény");
        }
    }
  
    private int getNovenyIndexByAzon(String azon) {
        int index = 0;
        for (Noveny noveny : novenyek) {
            if (noveny.getAzonosito().equals(azon)) {
                return index;
            }
            index++;
        }
        return -1;
    }
    
    private int getNovenyIndexByNev(String nev) {
        int index = 0;
        for (Noveny noveny : novenyek) {
            if (noveny.getNev().equals(nev)) {
                return index;
            }
            index++;
        }
        return -1;
    }
    
    public Noveny getNovenyByAzon(String azon) {
        int index = getNovenyIndexByAzon(azon);
        return novenyek.get(index);
    }
    
    public Noveny getNovenyByNev(String nev) {
        int index = getNovenyIndexByNev(nev);
        return novenyek.get(index);
    }
    
    public ArrayList<Noveny> getNovenyek() {
        return novenyek;
    }

    public void NovenyekKiir() {
        if (novenyek == null || novenyek.isEmpty()) {
            System.out.println("Nincsenek növények");
        } else {
            for (Noveny noveny : novenyek) {
                System.out.println("------------------");
                System.out.print("Azonosító: ");
                System.out.println(noveny.getAzonosito());
                System.out.print("Név: ");
                System.out.println(noveny.getNev());
                System.out.print("Ár: ");
                System.out.println(noveny.getAr());
                System.out.print("Kor: ");
                System.out.println(noveny.getKor());
            }
        }
    }
    
    public String Novenyek() {
        String szoveg = "";
        if (novenyek == null || novenyek.isEmpty()) {
            szoveg = "Nincsenek növények";
        } else {
            for (Noveny noveny : novenyek) {
                szoveg += "------------------\n";
                szoveg += ("Azonosító: " + noveny.getAzonosito() + "\n");
//                System.out.println(noveny.getAzonosito());
//                System.out.print("Név: ");
//                System.out.println(noveny.getNev());
//                System.out.print("Ár: ");
//                System.out.println(noveny.getAr());
//                System.out.print("Kor: ");
//                System.out.println(noveny.getKor());
            }
        }
        
        return szoveg;
    }

    public void StatisztikaMentes(String fajl) {
        try {
            FileOutputStream fajlKi = new FileOutputStream(fajl);
            ObjectOutputStream objKi = new ObjectOutputStream(fajlKi);
            objKi.writeObject(novenyek);
            objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Kert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Frissites(String fajl) {
        try ( ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajl))) {
            novenyek = (ArrayList<Noveny>) objBe.readObject();
        } catch (Exception e) {
        }
    }
}
