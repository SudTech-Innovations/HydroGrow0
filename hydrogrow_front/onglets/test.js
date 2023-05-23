// utilisation de l'API Fetch pour récupérer les données JSON depuis le serveur
fetch('http://localhost:3000/plante')
    .then(response => response.json()) // convertir la réponse en JSON
    .then(data => {
        // traitement des données récupérées 
        const plantNames = data.map(plant => plant.nom); // extraire uniquement les noms de plantes
        console.log(plantNames); // afficher les noms de plantes dans la console
    })
    .catch(error => {
        console.error('Erreur lors de la récupération des données :', error);
    });