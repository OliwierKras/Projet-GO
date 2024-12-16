# Projet-GO

Projet académique collaboratif visant à développer un programme permettant de jouer au Go, avec un moteur de jeu en Java.

## Utilisation

```plaintext
- boardsize x              // Donne une taille x au plateau de jeu

- showboard                // Affiche le plateau

- genmove couleur          // Génére coup de la couleur désirée avec l'algo minimaxx

- clear_board              // Vide le plateau des pions

- play couleur coordonnée  // Place un pion d'une couleur à des coordonnées données

- name                     // Affiche le nom du programme (moteur)

- protocol_version         // Affiche la version du protocole GTP

- version                  // Affiche la version du programme

- list_commands            // Affiche la liste des commandes GTP

- set_player couleur type ?profondeur //Défini un joueur d'un certain type (human, randomBot, minimax) et d'une certaine profondeur si besoin

- quit                     // Ferme le programme
