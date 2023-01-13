import React, {useEffect, useRef, useState} from 'react';
import {Button} from "react-bootstrap";
import {getTirageComplet} from "../service/TirageService";
import {TirageChoice} from "./TirageChoice";
import {InitierTirageResponse} from "../model/response/InitierTirageResponse";

export const TirageContent = ({currentTirage, currentJoueur, categories, handleInitTirage}) => {

    const [cartes, setCartes] = useState([]);
    const [conclusion, setConclusion] = useState(null);
    const [revealable, setRevealable] = useState(false);
    const [revealed, setRevealed] = useState(false);
    const scrollRef = useRef(null)

    const NB_CARTES = 6;

    useEffect(()=> {
        if (currentTirage) {
            setRevealed(false)
        }
    }, [currentTirage])

    const tirageComplet = () => {
        setRevealed(true);
        setRevealable(false);

        getTirageComplet(currentJoueur)
            .then(tirageComplet => {

                handleInitTirage(new InitierTirageResponse({numTirage: tirageComplet?.tirages[0]?.numTirage, joueur: currentJoueur}))

                const allCartesWithCategory = tirageComplet.tirages.map(tirage => {
                    const theCategory = categories.find(c => c.code === tirage?.carte?.categorie);
                    return {...tirage?.carte, categorie: theCategory.name}
                })
                setCartes(allCartesWithCategory)
                setConclusion(tirageComplet.conclusion)

            }).finally(() =>
                setTimeout(()=> {
                    executeScroll()
                }, 120)
            );

    }

    const executeScroll = () => scrollRef && scrollRef?.current && scrollRef.current.scrollIntoView({
        behavior: 'smooth',
        block: 'start'
    })

    return (
        <div>
            <TirageChoice nbCartes={NB_CARTES} isRevealed={revealed} onChoiceOk={setRevealable} categories={categories}/>
            {revealable && <div className={"m-5"}>
                <Button className={"irma-btn mt-3 reveal-btn"} onClick={() => tirageComplet()}>Révéler les cartes !</Button>
            </div>}
            <div ref={scrollRef} className="revealed-container d-flex justify-content-around flex-wrap">
                {cartes.map(carte => {
                    return (
                        <div className="card-revealed p-4" key={carte.idCarte}>
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