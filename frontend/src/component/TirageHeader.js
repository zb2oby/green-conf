import React from 'react';


export const TirageHeader = ({className, currentTirage, currentJoueur}) => {
    return (
        <div className={className}>
            <div className="m-3 d-flex justify-content-around">
                <div>
                    <div>Prénom : {currentJoueur?.prenom} </div>
                    <div>Signe : {currentJoueur?.signeAstro}</div>
                    <div>Date de naissance : {currentJoueur?.dateNaissance}</div>
                </div>
            </div>
        </div>

    )
}