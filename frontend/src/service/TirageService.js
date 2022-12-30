import {TirageCompletResponse} from "../model/response/TirageCompletResponse";
import {Conclusion} from "../model/Conclusion";
import {InitierTirageResponse} from "../model/response/InitierTirageResponse";
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
    const url = `${BASE_URI}/tirage/tirage-unitaire?num_tirage=${numTirage}`;
     return fetch(url, {
         method: 'GET',
         headers: {
             'Content-Type': 'application/json'
         }
     })
     .then(r => r.json())
     .then(r => Tirage.from(r));
}

export function conclusionTirageFor(numTirage) {
    const url = `${BASE_URI}/tirage/conclusion-tirage?num_tirage=${numTirage}`;
    return fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(r => r.json())
    .then(r => {
        Conclusion.from(r)
    });
}

export function getTirageComplet(joueur) {
    const url = `${BASE_URI}/tirage/tirage-complet`;
    return fetch(url, {
        method: 'POST',
        headers: {
            'Accept': 'application/json'
        },
        body: JSON.stringify(joueur)
    })
    .then(r => r.json())
    .then(r => new TirageCompletResponse(r));
}