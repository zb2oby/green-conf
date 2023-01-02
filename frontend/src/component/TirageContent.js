import React, {useEffect, useState} from 'react';
import {Button} from "react-bootstrap";
import {conclusionTirageFor, tirageUnitaireForNum} from "../service/TirageService";
import {getCategorieByCode} from "../service/Referentiel";
import {TirageChoice} from "./TirageChoice";

export const TirageContent = ({currentTirage}) => {

    const [cartes, setCartes] = useState([]);
    const [conclusion, setConclusion] = useState(null);
    const [revealable, setRevealable] = useState(false);
    const [revealed, setRevealed] = useState(false);
    const NB_CARTES = 6;

    useEffect(()=> {
        if (currentTirage) {
            setRevealed(false)
        }
    }, [currentTirage])

    const tirerUnitairement = async (nbTirage) => {
        setRevealed(true);
        setRevealable(false);
        const proms = await prepareListTirageUnitaire(nbTirage)
        Promise.all(proms)
            .then(allTirages => {
                Promise.all(allTirages.map(async tirage => {
                    const theCategory = await getCategorieByCode(tirage?.carte?.categorie);
                    return {...tirage?.carte, categorie: theCategory.name}
                })).then(allCartesWithCategory => {
                    setCartes(allCartesWithCategory)
                })
            })
            .then(_ =>  conclusionTirageFor(currentTirage?.numTirage).then(conc => setConclusion(conc)))


    }

    const prepareListTirageUnitaire = async (nbTirage) => {
        const proms = [];
        for (let i = 0; i<nbTirage; i++) {
            proms.push(tirageUnitaireForNum(currentTirage?.numTirage))
        }
        return proms
    }

    return (
        <div>
            <TirageChoice nbCartes={NB_CARTES} isRevealed={revealed} onChoiceOk={setRevealable}/>
            {revealable && <div className={"m-5"}>
                <Button className={"mt-3"} onClick={() => tirerUnitairement(NB_CARTES)}>Révéler les cartes !</Button>
            </div>}
            <div className="m-5 d-flex justify-content-around flex-wrap">
                {cartes.map(carte => {
                    return (
                        <div className="card-revealed w-50 p-4" key={carte.idCarte}>
                            <h4 className={"mb-2"}>{carte?.categorie}</h4>
                            <img src={require(`../assets/${carte?.image}`)} alt={carte?.idCarte}/>
                            <div className={"mt-3"}>{carte?.description}</div>
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