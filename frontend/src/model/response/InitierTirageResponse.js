import {Joueur} from "../Joueur";

export class InitierTirageResponse {
    constructor({numeroTirage, joueur}) {
        this.numeroTirage = numeroTirage;
        this.joueur = joueur ? Joueur.from(joueur) : null;
    }
}