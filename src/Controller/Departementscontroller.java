package Controller;
import Modules.Departement;
import Modules.Enseignant;
import Services.*;

import java.util.List;

import static Services.Main.affichermenuprincipale;
public class Departementscontroller{

    public static void afficherMenu() {
    System.out.println("--------------------[Menu Departement]-----------------------");
    System.out.println("1.pour ajouter un département");
    System.out.println("2.pour afficher  un département");
    System.out.println("3.pour modifier un département");
    System.out.println("4.pour  supprimer un département");
    System.out.println("5.pour retourner au menu principale");
    int option = Main.getIntInput("choisir une option :");
    switch (option) {
        case 1:
            ajouterDepartement();
            break;
        case 2:
            afficherDepartement();
            break;
        case 3:
            modifierDepartement();
            break;
        case 4:
            supprimerDepartements();
            break;
        case 5:
            affichermenuprincipale();
            break;
        default:
            System.out.println("Option non valide");
    }
}

public static void ajouterDepartement(){
        while (true) {
        String intitule = Main.getStringInput("Saisie l'intitule de departement :");
        int id = Main.getIntInput("Sélectionnez un enseignant par ID :");
        Enseignant enseignant = Enseignantsservices.getEnsById(id);

        if (enseignant == null) {
        System.out.println("Le responsable n'existe pas. Veuillez réessayer.");
        } else {
        Departementsservices.ajouterDept(intitule, id); // Utilisation de la méthode d'insertion
        System.out.println("Département ajouté avec succès !");
        break;
        }
        }
        afficherMenu();
        }

public static void afficherDepartement() {
        List<Departement> departements = Departementsservices.getAllDepartements(); // Utilisation de la méthode pour récupérer tous les départements
        for (Departement departement : departements) {
        System.out.print("Id : " + departement.getId());
        System.out.print(" | Intitule : " + departement.getIntitule());

        int responsableId = departement.getresponsable().getId();
        Enseignant enseignant = Enseignantsservices.getEnsById(responsableId);

        if (enseignant != null) {
        System.out.print(" | Responsable : " + enseignant.getNom() + " " + enseignant.getPrenom());
        } else {
        System.out.print(" | Enseignant : ");
        }
        System.out.println("");
        }
        }

public static void modifierDepartement() {
        afficherDepartement();
        int id = Main.getIntInput("Entrer l'ID de departement à modifier: ");
        String intitule = Main.getStringInput("Saisir le nouveau intitule :");
        int idEns = Main.getIntInput("Entrer le nouvel ID de responsable :");
        Departementsservices.modifyDepartement(id, intitule, idEns); // Utilisation de la méthode pour modifier le département
        afficherDepartement();
        afficherMenu();
        }

public static void supprimerDepartements() {
        afficherDepartement();
        int id = Main.getIntInput("Entrer l'ID de DEPARTEMENT à supprimer :");
        Departementsservices.deleteDepartement(id); // Utilisation de la méthode pour supprimer le département
        afficherDepartement();
        afficherMenu();
        }}

  /*
//Ce menu  contient les opérations qu'on doit effectuer pour le departement




        public static void ajouterDepartement(){
            while (true) {
                String intutule = Main.getStringInput("Saisie l'intitule de departement :");
                int id = Main.getIntInput("Sélectionnez un enseignant  par ID :");
              Enseignant enseignant = Enseignantsservices.getEnsById(id);

                if (enseignant == null) {
                    System.out.println("Le responsable  n'existe pas. Veuillez réessayer.");
                } else {
                    Departement departement =Departementsservices.ajouterDept(intutule, enseignant );
                    if ( departement!= null) {
                        System.out.println("L'ajout de departement avec succès");
                        break;
                    } else {
                        System.out.println("Échec de l'ajout. Veuillez réessayer.");
                    }
                }
            }
            afficherMenu();
        }

        public static void afficherDepartement(){
            for (Departement departement : Configuration.departements) {
                System.out.print("Id : " + departement.getId());
                System.out.print(" | Intitule : " + departement.getIntitule());

                Enseignant enseignant = departement.getresponsable();
                if (enseignant != null) {
                        System.out.print(" | Responsable : " + enseignant.getNom() + " " + enseignant.getPrenom());


                } else {
                    System.out.print(" | Enseignant : ");
                }
                System.out.println("");
            }

        }


        public static void modifierDepartement() {
            afficherDepartement();
            int id = Main.getIntInput("Entrer l'ID de departement à modifier: ");
            // Demander les nouvelles informations
            String intitule = Main.getStringInput("Saisir le nouveau intitule :");

            int idens = Main.getIntInput("Entrer le nouvel ID de responsable :");
            Enseignant enseignant = Enseignantsservices.getEnsById(idens);

            Departementsservices.modifierDept(id, intitule, enseignant);

            // Afficher les enseignants mis à jour
            afficherDepartement();
            afficherMenu();
        }

        public static void supprimerDepartements() {
            afficherDepartement();
            int id = Main.getIntInput("Entrer l'ID de DEPARTEMENT à supprimer :");
            Departementsservices.supprimerDepartementParId(id);
            afficherDepartement();
            afficherMenu();

        }



    }*/






