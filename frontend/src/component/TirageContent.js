import React, {useState} from 'react';
import {Button} from "react-bootstrap";
import {conclusionTirageFor, tirageUnitaireForNum} from "../service/TirageService";

export const TirageContent = ({currentTirage}) => {

    const [cartes, setCartes] = useState([]);
    const [conclusion, setConclusion] = useState(null);

    const tirerUnitairement = (nbTirage) => {
        const newCartes = [];
        const proms = [];
        for (let i = 0; i<nbTirage; i++) {
           proms.push(tirageUnitaireForNum(currentTirage?.numTirage))
        }
        Promise.all(proms).then(res => {
            res.forEach(tirage => newCartes.push(tirage?.carte))
            setCartes(newCartes)
            conclusionTirageFor(currentTirage?.numTirage).then(conc => setConclusion(conc))
        })

    }

    return (
        <div>
            <div className={"m-5"}>
                <Button className={"mt-3"} onClick={() => tirerUnitairement(6)}>Tirer des carte !</Button>
            </div>

            <div className="m-5 d-flex justify-content-around flex-wrap">
                {cartes.map(carte => {
                    return (
                        <div key={carte.idCarte}>
                            <h4>CARTE</h4>
                            <img src={carte?.image} alt={carte?.idCarte}/>
                            <div>{carte?.description}</div>
                        </div>
                    )
                })}
            </div>
            {cartes.length > 0 &&
                <div className="m-5 text-center">
                    <h4>CONCLUSION</h4>
                    <div>{conclusion?.analyse}</div>
                    <div>{conclusion?.scoreBonheur}</div>
                </div>
            }
        </div>
    )
}