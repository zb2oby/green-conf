import React, {useEffect, useState} from 'react';
import {initTirage} from "../service/TirageService";
import {Joueur} from "../model/Joueur";
import { Button, Form } from 'react-bootstrap';
import {Tirage} from "../model/Tirage";

export const TirageForm = ({joueur, handleInitTirage, handleInitJoueur}) => {

    const [joueurData, setJoueurData] = useState(joueur);


    const submitInit = (e) => {
        e.preventDefault();
        if (allValid()) {
            initTirage(Joueur.from(joueurData)).then(res => {
                const tirage = Tirage.from(res);
                const joueur = res.joueur;
                sessionStorage.setItem("savedTirage", JSON.stringify({tirage: tirage, joueur: joueur}))
                handleInitTirage(tirage);
                handleInitJoueur(joueur);
            })
        }
    }

    const allValid = () => {
        return (joueurData && joueurData?.prenom && joueurData?.prenom.length >= 2)
            && (joueurData?.dateNaissance?.match("(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"))
            && (joueurData?.signeAstro !== undefined && joueurData?.signeAstro !== "null");
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
    console.log(joueurData)
    return (
        <div className={"init-form"}>
                <Form onSubmit={submitInit}>
                    <Form.Group className="mb-3 inp-grp" controlId="prenom">
                        <Form.Label>Prénom :</Form.Label>
                        <Form.Control
                            defaultValue={joueurData?.prenom}
                            onChange={v => setJoueurData({...joueurData, prenom: v.target.value})}
                            type={"text"}
                            isInvalid={joueurData?.prenom && joueurData?.prenom.length < 2}
                            isValid={joueurData?.prenom && (joueurData?.prenom.length >= 2)}
                        />
                    </Form.Group>

                    <Form.Group className="mb-3 inp-grp" controlId="dateNaissance">
                        <Form.Label>Date de naissance :</Form.Label>
                        <Form.Control
                            defaultValue={joueurData?.dateNaissance}
                            onChange={v => setJoueurData({...joueurData, dateNaissance: v.target.value})}
                            type="date"
                            isValid={joueurData?.dateNaissance?.match("(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))")}
                            isInvalid={joueurData?.dateNaissance && !joueurData?.dateNaissance?.match("(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))")}
                        />
                    </Form.Group>

                    <Form.Group className="mb-3 inp-grp" controlId="signeAstro">
                        <Form.Label>Signe astrologique :</Form.Label>
                        <Form.Select
                            value={joueurData?.signeAstro}
                            onChange={v => setJoueurData({...joueurData, signeAstro: v.target.value})}
                            type="select"
                            isValid={joueurData?.signeAstro !== undefined && joueurData?.signeAstro !== "null"}
                            isInvalid={joueurData?.signeAstro === "null"}
                        >
                            <option value={"null"}>Choisir un signe astrologique</option>
                            {dataAstro.map(astro => <option key={astro} value={astro}>{astro}</option>)}
                        </Form.Select>
                    </Form.Group>

                    <Button className={"irma-btn"} type={"submit"}>Enregistrer</Button>
                </Form>
        </div>
    )
}