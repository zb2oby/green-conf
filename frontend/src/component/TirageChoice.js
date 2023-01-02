import React, {useEffect, useState} from 'react';
import {shuffle} from "../utils";
import {getAllCategories} from "../service/Referentiel";


export const TirageChoice = ({nbCartes, isRevealed}) =>  {

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
            console.log(cats, shuffle(cats))
            setAllCategories(shuffle(cats))
        })
    }, [])

    useEffect(() => {
        if (choosenCards.length+1 >= nbCartes) {
            setStopPersist(true);
        }
    }, [choosenCards, nbCartes])

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
    }, [categories, choosenCards, isRevealed])

    const persist = (choosenKey) => {
        if (! stopPersist) {
            const choosen = [...choosenCards]
            choosen.push(choosenKey)
            setChoosenCards(choosen)
        }
    }

    return (
        <div className={"card-tarot"}>
            <h3>Choisissez {nbCartes} cartes</h3>
            <ul className={"inline"}>
                {choicesCard}
            </ul>
        </div>
    )
}