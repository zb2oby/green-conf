export class Joueur {
    constructor(prenom, dateNaissance, signeAstro) {
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.signeAstro = signeAstro;
    }

    static from({prenom, dateNaissance, signeAstro}) {
        return new Joueur(prenom, dateNaissance, signeAstro);
    }
}