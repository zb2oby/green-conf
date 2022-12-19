import {TirageCompletResponse} from "../model/response/TirageCompletResponse";
import {Conclusion} from "../model/Conclusion";
import {InitierTirageResponse} from "../model/response/InitierTirageResponse";
import {TirageUnitaireResponse} from "../model/response/TirageUnitaireResponse";

export function initTirage(joueur) {
    const url = `/api/irma/v1/tirage/initier-tirage`;
    return fetch(url, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Accept': 'application/json'
        },
        body: JSON.stringify(joueur)
    })
    .then(r => r.json())
    .then(r => new InitierTirageResponse(r));
}

export function getTirageByNum(numeroTirage) {
    const url = `/api/irma/v1/tirage/tirage-unitaire/${numeroTirage}`;
    return fetch(url, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Accept': 'application/json'
        }
    })
    .then(r => r.json())
    .then(r => new TirageUnitaireResponse(r));
}

export function getConclusionTirageByNum(numeroTirage) {
    const url = `/api/irma/v1/tirage/conclusion-tirage/${numeroTirage}`;
    return fetch(url, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Accept': 'application/json'
        }
    })
        .then(r => Conclusion.from(r.json()));
}

export function getTirageComplet(joueur) {
    const url = `/api/irma/v1/tirage/tirage-complet`;
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