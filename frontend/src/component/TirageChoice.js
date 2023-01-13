import React, {useCallback, useEffect, useState} from 'react';
import {shuffle} from "../utils";


export const TirageChoice = ({nbCartes, isRevealed, onChoiceOk, categories}) =>  {

    const [choiceCategories, setChoiceCategories] = useState([])
    const [choicesCard, setChoicesCard] = useState([])
    const [choosenCards, setChoosenCards] = useState([]);
    const [stopPersist, setStopPersist] = useState(false)

    useEffect(() => {
        if (categories) {
            const cats = []
            categories.forEach(c => {
                cats.push(`${c.name}_01`);
                cats.push(`${c.name}_02`);
            })
            setChoiceCategories(shuffle(cats))
        }
    }, [categories])

    useEffect(() => {
        if (choosenCards.length === nbCartes) {
            setStopPersist(true);
            onChoiceOk(true);
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
        choiceCategories.forEach(cat => {
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
    }, [choiceCategories, choosenCards, isRevealed, persist])



    return (
        <div className={"card-tarot"}>
            <h3>Choisissez {nbCartes} cartes</h3>
            <ul className={"inline"}>
                {choicesCard}
            </ul>
        </div>
    )
}