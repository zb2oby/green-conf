import {Carte} from "./Carte";

export class Tirage {
    constructor(numeroTirage, carte) {
        this.numeroTirage = numeroTirage;
        this.carte = carte ? Carte.from(carte) : null;
    }

    static from({numeroTirage, carte}) {
        return new Tirage(numeroTirage, carte);
    }
}