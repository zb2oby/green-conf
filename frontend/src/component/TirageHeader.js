import React from 'react';


export const TirageHeader = ({currentTirage, currentJoueur}) => {
    return (
        <div>
            <div className="m-3 d-flex justify-content-around">
                <div>
                    <h3>Joueur</h3>
                    <div>{currentJoueur?.prenom} {currentJoueur?.signeAstro}</div>
                    <div>{currentJoueur?.dateNaissance}</div>
                </div>
                <div>
                    <h3>Tirage</h3>
                    <div>{currentTirage?.numTirage}</div>
                </div>
            </div>
        </div>

    )
}