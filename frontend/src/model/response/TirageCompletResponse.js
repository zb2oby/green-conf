import {Tirage} from "../Tirage";
import {Conclusion} from "../Conclusion";
import {Joueur} from "../Joueur";

export class TirageCompletResponse {
    constructor({tirages, joueur, conclusion}) {
        this.tirages = tirages ? tirages.map(tirage => Tirage.from(tirage)) : [];
        this.joueur = joueur ? Joueur.from(joueur) : null;
        this.conclusion = conclusion ? Conclusion.from(conclusion) : null;
    }

}