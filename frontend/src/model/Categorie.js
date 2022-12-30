export class Categorie {
    constructor(name, code) {
        this.name = name;
        this.code = code
    }

    static from({name, code}) {
        return new Categorie(name, code)
    }
}