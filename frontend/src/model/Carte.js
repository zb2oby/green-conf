import {Categorie} from "./Categorie";

export class Carte {
    constructor(idCarte, image, description, categorie, scoreBohneur) {
        this.idCarte = idCarte;
        this.image = image;
        this.description = description;
        this.categorie = categorie ? new Categorie(categorie) : null;
        this.scoreBohneur = scoreBohneur;
    }

    static from({idCarte, image, description, categorie, scoreBohneur}) {
        return new Carte(idCarte, image, description, categorie, scoreBohneur)
    }
}