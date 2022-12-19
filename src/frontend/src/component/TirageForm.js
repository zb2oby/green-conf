import React, {useState} from 'react';
import {initTirage} from "../service/TirageService";
import {Joueur} from "../model/Joueur";
import {InitierTirageResponse} from "../model/response/InitierTirageResponse";

export const TirageForm = (props) => {

    const [joueurData, setJoueurData] = useState(new Joueur());
    const [initResponse, setInitResponse] = useState({})

    const handleCallInit = () => {
        initTirage(joueurData).then(res => setInitResponse(res))
    }

    return (
        <form onSubmit={handleCallInit}>
            <label htmlFor="prenom">Prénom :</label>
            <input type="text" name={"prenom"}/>
            <label htmlFor="dateNaissance">Date de naissance</label>
            <input type="date" name={"dateNaissance"}/>
        </form>
    )
}