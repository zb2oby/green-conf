export class Conclusion {
    constructor(numeroTirage, analyse, scoreBohneur) {
        this.numeroTirage = numeroTirage;
        this.analyse = analyse;
        this.scoreBonheur = scoreBohneur;
    }

    static from({numeroTirage, analyse, scoreBohneur}) {
        return new Conclusion(numeroTirage, analyse, scoreBohneur);
    }
}