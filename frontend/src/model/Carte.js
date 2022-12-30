export class Carte {
    constructor(idCarte, image, description, categorie, scoreBohneur) {
        this.idCarte = idCarte;
        this.image = image;
        this.description = description;
        this.categorie = categorie;
        this.scoreBohneur = scoreBohneur;
    }

    static from({idCarte, image, description, categorie, scoreBohneur}) {
        return new Carte(idCarte, image, description, categorie, scoreBohneur)
    }
}