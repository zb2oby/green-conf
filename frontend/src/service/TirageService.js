import {TirageCompletResponse} from "../model/response/TirageCompletResponse";
import {Conclusion} from "../model/Conclusion";
import {InitierTirageResponse} from "../model/response/InitierTirageResponse";
import {TirageUnitaireResponse} from "../model/response/TirageUnitaireResponse";
import {Carte} from "../model/Carte";
import {Categorie} from "../model/Categorie";
import {Joueur} from "../model/Joueur";
import {Tirage} from "../model/Tirage";

const BASE_URI = 'http://localhost:8080/irma/v1';

export function initTirage(joueur) {
    const url = `${BASE_URI}/tirage/initier-tirage`;
    return fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(joueur)
    })
    .then(r => r.json())
    .then(r => new InitierTirageResponse(r));
}

export function tirageUnitaireForNum(numTirage) {
    return Promise.resolve(
        new TirageUnitaireResponse({
            tirage: new Tirage(
                numTirage,
                Carte.from({idCarte: Math.random().toString().split(".")[1], image: "image.jpg", description: "oulala", categorie: new Categorie("mort", "CODE_01")})
            ),
            joueur: new Joueur()}
    ))
    /*const url = `${BASE_URI}/tirage/tirage-unitaire/${numTirage}`;
     return fetch(url, {
         method: 'GET',
         credentials: 'include',
         headers: {
             'Accept': 'application/json'
         }
     })
     .then(r => r.json())
     .then(r => new TirageUnitaireResponse(r));*/
}

export function conclusionTirageFor(numTirage) {
    return Promise.resolve(new Conclusion(numTirage, "analyse de fifou",22));
    /*const url = `${BASE_URI}/tirage/conclusion-tirage/${numTirage}`;
    return fetch(url, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Accept': 'application/json'
        }
    })
        .then(r => Conclusion.from(r.json()));*/
}

export function getTirageComplet(joueur) {
    const url = `${BASE_URI}/tirage/tirage-complet`;
    return fetch(url, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Accept': 'application/json'
        },
        body: JSON.stringify(joueur)
    })
    .then(r => r.json())
    .then(r => new TirageCompletResponse(r));
}