# Projet R304 Moteur Gomoku

Groupe: 207/208
Membres:
- SOUMAH Ali (208)
- TABTI Abdelhilah (207)
- KRAS Oliwier (208)
- BARBIER Lucas (207)

Tout fonctionne correctement, le bot minimax partiellement.

Tout nos tests unitaires passsent.

L'impléméntation de l'algorithme minimax a été la plus grande difficulté.

Le moteur a pu etre connecté à gogui.

## Utilisation

```plaintext
- boardsize x              // Donne une taille x au plateau de jeu

- showboard                // Affiche le plateau

- genmove couleur          // Génére coup de la couleur désirée avec l'algo minimax

- clear_board              // Vide le plateau des pions

- play couleur coordonnée  // Place un pion d'une couleur à des coordonnées données

- name                     // Affiche le nom du programme (moteur)

- protocol_version         // Affiche la version du protocole GTP

- version                  // Affiche la version du programme

- list_commands            // Affiche la liste des commandes GTP

- set_player couleur type ?profondeur //Défini un joueur d'un certain type (human, randomBot, minimax) et d'une certaine profondeur si besoin

- quit                     // Ferme le programme
