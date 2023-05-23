const express = require('express');
const bodyParser = require('body-parser');
const config = require('./config');

const PlanteController = require('./src/main/java/vinckier/hydrogrow_back_v2/API/PlanteController');
const planteController = new PlanteController();

const app = express();
app.use(bodyParser.json());

// Définition des routes
app.get('/api/users', (req, res) => {
    // Logique de récupération des utilisateurs depuis la base de données
    res.json({ users: [{ id: 1, name: 'John' }, { id: 2, name: 'Jane' }] });
});

app.post('/api/users', (req, res) => {
    // Logique de création d'un nouvel utilisateur dans la base de données
    const user = req.body;
    // Enregistrer l'utilisateur dans la base de données
    res.json({ message: 'Utilisateur créé avec succès', user });
});

// Définition des routes
app.get('/api/plante/:id', (req, res) => {
    const id = req.params.id;
    const plante = planteController.findById(id);
    res.json(plante);
});

app.get('/api/plante', (req, res) => {
    const plantes = planteController.findAll();
    res.json(plantes);
});

app.post('/api/plante', (req, res) => {
    const plante = req.body;
    planteController.save(plante);
    res.json({ message: 'Plante créée avec succès', plante });
});

app.put('/api/plante/:id', (req, res) => {
    const id = req.params.id;
    const plante = req.body;
    planteController.update(plante, id);
    res.json({ message: 'Plante mise à jour avec succès', plante });
});

app.delete('/api/plante/:id', (req, res) => {
    const id = req.params.id;
    planteController.delete(id);
    res.json({ message: 'Plante supprimée avec succès' });
});


// Démarrage du serveur
app.listen(config.port, () => {
    console.log(`Serveur démarré sur le port ${config.port}`);
});
