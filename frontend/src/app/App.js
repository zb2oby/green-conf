import {TirageForm} from "../component/TirageForm";
import {Button} from 'react-bootstrap';
import React, {useState} from "react";
import {TirageHeader} from "../component/TirageHeader";
import {TirageContent} from "../component/TirageContent";
import {getAllCompleteCategories} from "../service/Referentiel";
import {Categorie} from "../model/Categorie";
import {useEffectOnce} from "../service/useEffectOnce";

function App() {

    const [iniTirage, setInitTirage] = useState(true);
    const [currentTirage, setCurrentTirage] = useState(null)
    const [currentJoueur, setCurrentJoueur] = useState(null)
    const [categories, setCategories] = useState([]);

    useEffectOnce(() => {
        if (sessionStorage.getItem("savedTirage")) {
            setInitTirage(false)
            const savedTirage = JSON.parse(sessionStorage.getItem("savedTirage"));
            setCurrentTirage(savedTirage.tirage || null)
            setCurrentJoueur(savedTirage.joueur)
        }
    }, [])

    useEffectOnce(() => {
        if (categories.length === 0) {
            getAllCompleteCategories().then(res => setCategories(Object.entries(res).map(([k,v]) => new Categorie(v, k))));
        }
    }, [])

    const handleInitTirage = (tirage) => {
        setCurrentTirage(tirage.numTirage)
        sessionStorage.setItem("savedTirage", JSON.stringify({tirage: tirage.numTirage, joueur: currentJoueur}));
    }

    const handleInitJoueur = (joueur) => {
        setCurrentJoueur(joueur)
        setInitTirage(false)
    }

    return (
        <div className="container">
            <div className={"mb-5 text-center"}>
                <h1 className={"mb-5 mt-3"}>IRMA SAUVE LA PLANETE</h1>
                {!iniTirage && <Button className={"irma-btn"} onClick={() => setInitTirage(true)}>Initialiser un nouveau tirage</Button>}
            </div>
            {iniTirage &&
                <TirageForm joueur={currentJoueur} handleInitJoueur={handleInitJoueur}/>
            }
            {!iniTirage &&
                <>
                    <TirageHeader className={"tirageHeader"} currentTirage={currentTirage} currentJoueur={currentJoueur}/>
                    <div className={"text-center"}>
                        <TirageContent currentTirage={currentTirage} currentJoueur={currentJoueur} categories={categories} handleInitTirage={handleInitTirage} />
                    </div>
                </>
            }
        </div>
    );
}

export default App;
