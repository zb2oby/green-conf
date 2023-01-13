import {Categorie} from "../model/Categorie";
import {BASE_URI} from "./constants";

export function getCategorieByCode(codeCategorie) {
    const url = `${BASE_URI}/tirage/categorie/code?code=${codeCategorie}`;
    return fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(r => r.json())
        .then(name => new Categorie(name, codeCategorie));
}

export function getAllCategories() {
    const url = `${BASE_URI}/tirage/categorie/get-all`;
    return fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(r => r.json());
}

export function getAllCompleteCategories() {
    const url = `${BASE_URI}/tirage/categorie/get-all-complete`;
    return fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(r => r.json());
}