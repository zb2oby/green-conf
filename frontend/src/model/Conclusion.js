export class Conclusion {
    constructor(numTirage, analyse, scoreBohneur) {
        this.numTirage = numTirage;
        this.analyse = analyse;
        this.scoreBonheur = scoreBohneur;
    }

    static from({numTirage, analyse, scoreBohneur}) {
        return new Conclusion(numTirage, analyse, scoreBohneur);
    }
}