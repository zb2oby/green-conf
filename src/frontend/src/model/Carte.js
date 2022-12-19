import {Categorie} from "./Categorie";

export class Carte {
    constructor(idCarte, image, description, categorie) {
        this.idCarte = idCarte;
        this.image = image;
        this.description = description;
        this.categorie = new Categorie(categorie);
    }

    static from({idCarte, image, description, categorie}) {
        return new Carte(idCarte, image, description, categorie)
    }
}