import {Tirage} from "../Tirage";
import {Joueur} from "../Joueur";

export class TirageUnitaireResponse {
    constructor({tirage, joueur}) {
        this.tirage = tirage ? Tirage.from(tirage) : null;
        this.joueur = joueur ? Joueur.from(joueur) : null;
    }

}