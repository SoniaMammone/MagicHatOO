package org.generation.italy.magicHatOO.model;

import java.util.Random;

public class MagicHat {

    private Random random = new Random();

    public House assignStudent(Student s){
        /*controolo se lo studente ha una casa preferita, 
        se ha beccato il 50% di fortuna e prova ad aggiungerlo direttamente*/
        if (s.hasFavHouse() && s.isLucky() && s.getFavHous().addStudent(s)){
            return s.getFavHous();
        }
        boolean assigned;
        House randomHouse;
        do{
            randomHouse = House.getRandomHouse();
            assigned = randomHouse.addStudent(s); //il metodo randomHouse ritorna una casa che poi richiama l'aggiungi studente
           
        } while(!assigned);
        return randomHouse;
    }

    public void announceAssignement(Student s, House randomHouse) {
        System.out.printf("%s .... ", s.getFullName());
        generateSuspance();
        if(s.getFavHous() != null){
            System.out.printf("e stato inserito nella casa %s anzichè nella sua casa preferita %s%n", randomHouse, s.getFavHous());
        } else{
            System.out.printf("è stato inserito nella %s%n",randomHouse);
        }
        //controllo trenario??
        //System.out.printf("è stato ineserito nella casa %s%s%n", randomHouse, s.getFavHous() != null ? " invece che nella sua preferita" + s.getFavHous() : "");
    }

    public void announceAssignement(Student s) {
        System.out.printf("%s .... ", s.getFullName());
        generateSuspance();
        System.out.printf("fortunello è stato inserito nella sua casa preferita %s%n", s.getFavHous());
    }

    private void generateSuspance() {
        int millis = random.nextInt(2000, 4000);

       try {
            Thread.sleep(millis);
       } catch (Exception e) {
            //will never execute
       }
    }

    
}
