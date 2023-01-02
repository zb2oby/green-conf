import React, {useCallback, useEffect, useState} from 'react';
import {shuffle} from "../utils";
import {getAllCategories} from "../service/Referentiel";


export const TirageChoice = ({nbCartes, isRevealed, onChoiceOk}) =>  {

    const [categories, setAllCategories] = useState([])
    const [choicesCard, setChoicesCard] = useState([])
    const [choosenCards, setChoosenCards] = useState([]);
    const [stopPersist, setStopPersist] = useState(false)

    useEffect(() => {
        getAllCategories().then(cs => {
            const cats = []
            cs.forEach(c => {
                cats.push(`${c}_01`);
                cats.push(`${c}_02`);
            })
            setAllCategories(shuffle(cats))
        })
    }, [])

    useEffect(() => {
        if (choosenCards.length === nbCartes-1) {
            setStopPersist(true);
            onChoiceOk(true)
        }
    }, [choosenCards, nbCartes, onChoiceOk])

    const persist = useCallback((choosenKey) => {
        if (! stopPersist) {
            const choosen = [...choosenCards]
            choosen.push(choosenKey)
            setChoosenCards(choosen)
        }
    }, [choosenCards, stopPersist])

    useEffect(() => {
        let choices = [];
        categories.forEach(cat => {
            const isChoosenCard = choosenCards.some(c => c === `choice-${cat}`)
            choices.push(
                <li id={`choice-${cat}`} key={`choice-${cat}`}>
                    <span onClick={() => persist(`choice-${cat}`)}>
                        <img src={require("../assets/card.png")} alt="card" className={`back-card ${isChoosenCard ? "hover" : ""} ${isChoosenCard && isRevealed ? "hideCard" : ""}`} />
                    </span>
                </li>
            )
        })
        setChoicesCard(choices)
    }, [categories, choosenCards, isRevealed, persist])



    return (
        <div className={"card-tarot"}>
            <h3>Choisissez {nbCartes} cartes</h3>
            <ul className={"inline"}>
                {choicesCard}
            </ul>
        </div>
    )
}