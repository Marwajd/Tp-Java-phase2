package Services;

import Modules.Departement;
import Modules.Enseignant;

import java.util.ArrayList;
public class Enseignantsservices{

    public static Enseignant ajouterEns(String nom, String prenom, String email, String grade, Departement departement) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setGrade(grade);
        enseignant.setEmail(email);
        enseignant.setDepartement(departement);
        enseignant.setId(Configuration.getEnsId());
        Configuration.enseignants.add(enseignant);
        return enseignant;
    }

    public static Enseignant modifierEns(int id, String nom, String prenom, String email, String grade, Departement departement) {
        for (Enseignant enseignant : Configuration.enseignants) {
            if (enseignant.getId() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setGrade(grade);
                enseignant.setEmail(email);
                enseignant.setDepartement(departement);
            }
            return enseignant;
        }
        return new Enseignant();
    }

    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant : Configuration.enseignants) {
            if (enseignant.getId() == id) {
                return enseignant;
            }
        }
        return new Enseignant();
    }

    public static ArrayList<Enseignant> supprimerEnseignantParId(int id) {
        Configuration.enseignants.remove(getEnsById(id));
        return Configuration.enseignants;
    }

    public static ArrayList<Enseignant> getAllEns() {
        return Configuration.enseignants;
    }
}

