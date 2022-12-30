import {Tirage} from "../Tirage";
import {Conclusion} from "../Conclusion";

export class TirageCompletResponse {
    constructor({tirages, conclusion}) {
        this.tirages = tirages ? tirages.map(tirage => Tirage.from(tirage)) : [];
        this.conclusion = conclusion ? Conclusion.from(conclusion) : null;
    }

}