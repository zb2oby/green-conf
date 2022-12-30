import {Carte} from "./Carte";

export class Tirage {
    constructor(numTirage, carte) {
        this.numTirage = numTirage;
        this.carte = carte ? Carte.from(carte) : null;
    }

    static from({numTirage, carte}) {
        return new Tirage(numTirage, carte);
    }
}