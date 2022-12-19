import {Tirage} from "../Tirage";
import {Joueur} from "../Joueur";

export class TirageUnitaireResponse {
    constructor({tirage, joueur}) {
        this.tirage = Tirage.from(tirage);
        this.joueur = Joueur.from(joueur);
    }

}