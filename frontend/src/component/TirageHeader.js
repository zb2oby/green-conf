import React from 'react';


export const TirageHeader = ({className, currentTirage, currentJoueur}) => {
    return (
        <div className={className}>
            <div className="d-flex justify-content-around">
                <div>
                    <span>Prénom : {currentJoueur?.prenom}, </span>
                    <span>Signe : {currentJoueur?.signeAstro}, </span>
                    <span>Date de naissance : {currentJoueur?.dateNaissance}</span>
                </div>
            </div>
        </div>

    )
}