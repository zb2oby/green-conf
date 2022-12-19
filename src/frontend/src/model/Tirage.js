import {Joueur} from "./Joueur";
import {Carte} from "./Carte";

export class Tirage {
    constructor(numeroTirage, carte, joueur) {
        this.numeroTirage = numeroTirage;
        this.carte = Carte.from(carte);
        this.joueur = Joueur.from(joueur);
    }

    static from({numeroTirage, carte, joueur}) {
        return new Tirage(numeroTirage, carte, joueur);
    }
}