import {Joueur} from "../Joueur";

export class InitierTirageResponse {
    constructor({numTirage, joueur}) {
        this.numTirage = numTirage;
        this.joueur = joueur ? Joueur.from(joueur) : null;
    }
}