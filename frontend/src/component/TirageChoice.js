import React, {useEffect, useState} from 'react';
import {shuffle} from "../utils";
import {getAllCategories} from "../service/Referentiel";


export const TirageChoice = () =>  {

    const [categories, setAllCategories] = useState([])
    const [choicesCard, setChoicesCard] = useState([])

    useEffect(() => {
        getAllCategories().then(cs => setAllCategories(cs))
    }, [])

    useEffect(() => {
        let choices = [];
        categories.forEach(cat => {
            choices.push(
                <>
                    <li id={`choice-${cat}1`} key={`choice-${cat}1`}>
                        <span>
                            <img src={require("../assets/card.png")} alt="card" className="back-card" />
                            <img src={require(`../assets/${cat}_01.jpeg`)} alt="card1" className="hidden-card" />
                        </span>
                    </li>
                    <li id={`choice-${cat}2`} key={`choice-${cat}2`}>
                        <span>
                            <img src={require("../assets/card.png")} alt="card" className="back-card" />
                            <img src={require(`../assets/${cat}_02.jpeg`)} alt="card2" className="hidden-card" />
                        </span>
                    </li>
                </>
            )
        })
        setChoicesCard(shuffle(choices));
    }, [categories])

    return (
        <div className={"card-tarot"}>
            <ul className={"inline"}>
                {choicesCard}
            </ul>
        </div>
    )
}