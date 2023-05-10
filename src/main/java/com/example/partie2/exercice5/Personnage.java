package com.example.partie2.exercice5;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class Personnage extends Group {
    protected final static double LARGEUR_MOITIE_PERSONNAGE = 10;
    protected final static double LARGEUR_PERSONNAGE = LARGEUR_MOITIE_PERSONNAGE * 2;
    private final Circle corps;
    protected String direction;

    public Personnage(String direction, Color couleurContour, Color couleurRemplissage) {
        this.direction = direction;
        corps = new Circle(10, 10, LARGEUR_MOITIE_PERSONNAGE, couleurContour);
        corps.setFill(couleurRemplissage);
        getChildren().add(corps);
    }
    private boolean collisionAvecObstacles() {
        for (Obstacle obstacle : JeuMain.obstacles) {
            if (getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    public void deplacerAGauche() {
        double oldX = getLayoutX();
        double oldY = getLayoutY();

        // Faites le déplacement voulu
        setLayoutX(oldX - LARGEUR_PERSONNAGE/2);

        // Détectez une collision avec un obstacle
        if (collisionAvecObstacles()) {
            // Repositionnez le personnage avec les coordonnées sauvegardées
            setLayoutX(oldX);
            setLayoutY(oldY);
        }

        if (!direction.equals("gauche")) {
            direction = "gauche";
        }
    }


    public void deplacerADroite(double largeurJeu) {
        double oldX = getLayoutX();
        double oldY = getLayoutY();

        // Faites le déplacement voulu
        setLayoutX(oldX + LARGEUR_PERSONNAGE/2);

        // Détectez une collision avec un obstacle
        if (collisionAvecObstacles()) {
            // Repositionnez le personnage avec les coordonnées sauvegardées
            setLayoutX(oldX);
            setLayoutY(oldY);
        }

        if (!direction.equals("droite")) {
            direction = "droite";
        }
    }

    public void deplacerEnBas(double hauteurJeu) {
        double oldX = getLayoutX();
        double oldY = getLayoutY();

        // Faites le déplacement voulu
        setLayoutY(oldY + LARGEUR_PERSONNAGE/2);

        // Détectez une collision avec un obstacle
        if (collisionAvecObstacles()) {
            // Repositionnez le personnage avec les coordonnées sauvegardées
            setLayoutX(oldX);
            setLayoutY(oldY);
        }

        if (!direction.equals("bas")) {
            direction = "bas";
        }
    }

    public void deplacerEnHaut() {
        double oldX = getLayoutX();
        double oldY = getLayoutY();

        // Faites le déplacement voulu
        setLayoutY(oldY - LARGEUR_PERSONNAGE/2);

        // Détectez une collision avec un obstacle
        if (collisionAvecObstacles()) {
            // Repositionnez le personnage avec les coordonnées sauvegardées
            setLayoutX(oldX);
            setLayoutY(oldY);
        }

        if (!direction.equals("haut")) {
            direction = "haut";
        }
    }



    boolean estEnCollision(Personnage autrePersonnage) {
        return getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(getBoundsInParent());
    }

}
