import {TirageCompletResponse} from "../model/response/TirageCompletResponse";
import {Conclusion} from "../model/Conclusion";
import {InitierTirageResponse} from "../model/response/InitierTirageResponse";
import {TirageUnitaireResponse} from "../model/response/TirageUnitaireResponse";
import {Carte} from "../model/Carte";
import {Categorie} from "../model/Categorie";
import {Joueur} from "../model/Joueur";
import {Tirage} from "../model/Tirage";

export function initTirage(joueur) {
    return Promise.resolve(new InitierTirageResponse({numeroTirage: Math.random().toString().split(".")[1], joueur: joueur}))
    /*const url = `/api/irma/v1/tirage/initier-tirage`;
    return fetch(url, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Accept': 'application/json'
        },
        body: JSON.stringify(joueur)
    })
    .then(r => r.json())
    .then(r => new InitierTirageResponse(r));*/
}

export function tirageUnitaireForNum(numeroTirage) {
    return Promise.resolve(
        new TirageUnitaireResponse({
            tirage: new Tirage(
                numeroTirage,
                Carte.from({idCarte: Math.random().toString().split(".")[1], image: "image.jpg", description: "oulala", categorie: new Categorie("mort", "CODE_01")})
            ),
            joueur: new Joueur()}
    ))
    /*const url = `/api/irma/v1/tirage/tirage-unitaire/${numeroTirage}`;
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

export function conclusionTirageFor(numeroTirage) {
    return Promise.resolve(new Conclusion(numeroTirage, "analyse de fifou",22));
    /*const url = `/api/irma/v1/tirage/conclusion-tirage/${numeroTirage}`;
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