import {TirageForm} from "../component/TirageForm";
import {Button} from 'react-bootstrap';
import React, {useEffect, useState} from "react";
import {TirageHeader} from "../component/TirageHeader";
import {TirageContent} from "../component/TirageContent";

function App() {

    const [iniTirage, setInitTirage] = useState(true);
    const [currentTirage, setCurrentTirage] = useState(null)
    const [currentJoueur, setCurrentJoueur] = useState(null)

    useEffect(() => {
        if (sessionStorage.getItem("savedTirage")) {
            setInitTirage(false)
            const savedTirage = JSON.parse(sessionStorage.getItem("savedTirage"));
            setCurrentTirage(savedTirage.tirage)
            setCurrentJoueur(savedTirage.joueur)
        }
    }, [])

    const handleInitTirage = (tirage) => {
        setCurrentTirage(tirage)
        setInitTirage(false)
    }

    const handleInitJoueur = (joueur) => {
        setCurrentJoueur(joueur)
    }

    return (
        <div className="container">
            <div className={"mb-5 text-center"}>
                <h1>IRMA SAUVE LA PLANETE</h1>
                {!iniTirage && <Button onClick={() => setInitTirage(true)}>Initialiser un nouveau tirage</Button>}
            </div>
            {iniTirage &&
                <TirageForm joueur={currentTirage} handleInitTirage={handleInitTirage} handleInitJoueur={handleInitJoueur}/>
            }
            {!iniTirage &&
                <>
                    <TirageHeader currentTirage={currentTirage} currentJoueur={currentJoueur}/>
                    <div className={"text-center"}>
                        <TirageContent currentTirage={currentTirage} />
                    </div>
                </>
            }
        </div>
    );
}

export default App;
