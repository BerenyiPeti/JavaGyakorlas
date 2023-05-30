package nezet;

import java.util.ArrayList;
import modell.Kert;
import modell.Noveny;

public class KonzolNezet {

    public static void main(String[] args) {
        Kert kert1 = new Kert();
//        System.out.println("Kert1 alap állapot:");
//        kert1.NovenyekKiir();


        ArrayList<Noveny> novenyek = new ArrayList();
        Noveny n1 = new Noveny("no04", "fehér növény", 2500, 1);
        Noveny n2 = new Noveny("no05", "lila növény", 1500, 2);
        Noveny n3 = new Noveny("no06", "rózsaszín növény", 2000, 3);
        novenyek.add(n1);
        novenyek.add(n2);
        novenyek.add(n3);
        System.out.println("itt");
        Kert kert3 = new Kert(novenyek);
        kert3.NovenyekKiir();
        //beszerzés
        kert1.NovenyBeszerez(n1);
        kert1.NovenyBeszerez(n2);
        kert1.NovenyBeszerez(n3);
        
        //eladás
        kert1.novenyElad("no01");
        kert1.novenyElad("no02");

        System.out.println("Kiinduló állapot:");
        kert1.NovenyekKiir();
        
        kert1.StatisztikaMentes("kert.bin");
        kert1 = null;
        
        Kert kert2 = new Kert();
        kert2.Frissites("kert.bin");
        kert1 = kert2;
        
        System.out.println("Firrítés utáni állapot:");
        kert1.NovenyekKiir();
        

    }
}
