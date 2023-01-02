import React, {useEffect, useState} from 'react';
import {initTirage} from "../service/TirageService";
import {Joueur} from "../model/Joueur";
import { Button, Form } from 'react-bootstrap';
import {Tirage} from "../model/Tirage";

export const TirageForm = ({joueur, handleInitTirage, handleInitJoueur}) => {

    const [joueurData, setJoueurData] = useState(joueur);


    const submitInit = (e) => {
        e.preventDefault();
        initTirage(Joueur.from(joueurData)).then(res => {
            const tirage = Tirage.from(res);
            const joueur = res.joueur;
            sessionStorage.setItem("savedTirage", JSON.stringify({tirage: tirage, joueur: joueur}))
            handleInitTirage(tirage);
            handleInitJoueur(joueur);
        })
    }

    useEffect(() => {
        if (sessionStorage.getItem("savedTirage")) {
            const savedTirage = JSON.parse(sessionStorage.getItem("savedTirage"));
            setJoueurData(savedTirage.joueur)
        }
    }, [])

    const dataAstro = [
        "Bélier",
        "Taureau",
        "Gémeau",
        "Cancer",
        "Lion",
        "Vierge",
        "Balance",
        "Scorpion",
        "Sagittaire",
        "Capricorne",
        "Verseau",
        "Poisson",
    ]

    return (
        <div>
                <Form onSubmit={submitInit}>
                    <Form.Group className="mb-3" controlId="prenom">
                        <Form.Label>Prénom :</Form.Label>
                        <Form.Control defaultValue={joueurData?.prenom}
                                      onChange={v => setJoueurData({...joueurData, prenom: v.target.value})}
                                      type={"text"}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="dateNaissance">
                        <Form.Label>Date de naissance :</Form.Label>
                        <Form.Control defaultValue={joueurData?.dateNaissance}
                                      onChange={v => setJoueurData({...joueurData, dateNaissance: v.target.value})}
                                      type="date"/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="signeAstro">
                        <Form.Label>Signe astrologique :</Form.Label>
                        <Form.Select value={joueurData?.signeAstro} onChange={v => setJoueurData({...joueurData, signeAstro: v.target.value})}
                                     type="select">
                            {dataAstro.map(astro => <option key={astro} value={astro}>{astro}</option>)}
                        </Form.Select>
                    </Form.Group>

                    <Button className={"irma-btn"} type={"submit"}>Enregistrer</Button>
                </Form>
        </div>
    )
}