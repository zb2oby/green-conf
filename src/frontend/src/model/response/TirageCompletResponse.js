import {Tirage} from "../Tirage";
import {Conclusion} from "../Conclusion";

export class TirageCompletResponse {
    constructor({tirages, conclusion}) {
        this.tirages = tirages.map(tirage => Tirage.from(tirage));
        this.conclusion = Conclusion.from(conclusion);
    }

}