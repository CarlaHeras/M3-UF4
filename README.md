
# Projecte UF4 M03

## Manual d'usuari

* Al executar el programa apareix el menú principal.

* En el cas d'inentar entrar a les opcions 2 (de consulta) i 4 (esborrar dades) saltarà un error demanant que s'insereixin dades abans.
  ![menu](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/1.png)

* Si escollim la 1ª opció, es carreguen les dades de l'API.
![carregar](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/2.png)

* Si escollim la 2ª opció, entrem a un submenú que ens dona la possibilitat d'escollir entre 3 opcions.
![consulta](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/3.png)

* Si escollim la 1ª opció del submenú es mostraràn tots els personatges carregats.
![personatges](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/4.png)

* Si escollim la 2ª opció del submenú es mostraràn tots els estudiants carregats.
![estudiants](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/5.png)

* Si escollim la 3ª opció del submenú es mostraràn tots els professors carregats.
![professors](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/6.png)

* Si posem 0 es tancarà el submenú i es tornarà al menú principal.

* Si escollim l'opció 3 del menú ens demana si volem afegir un alumne o un professor i ens demana tots els seus atributs.
![afegir](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/7.png)

* Si escollim l'opció 4 del menú ens pregunta quin personatge volem borrar, si posem el nom i coincideix amb algun dels carregats l'elimina.
![esborrar](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/8.png)

* Amb l'opció 0 tanquem el programa.
![sortir](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/9.png)

  ## POO
  * He utilitzat l'herència on la classe pare es Personatge i les classes filles són Estudiant i Professor.
  * També he utilitzat la sobrecàrrega per afegir estudiants o professors de forma manual i la sobreescriptura de toString() per printar els personatges amb una estructura. 
  
  ## VCS
  * Vaig decidir fer Personatge una classe pare i Estudiant i Professor classes filles que heretaven perquè em vaig adonar que els personatges eren constituits per la unió dels alumnes i els professors.
  * En el principal problema que m'he trobat ha sigut que m'he quedat sense company, amb poc temps i pràcticament sense gaire idea del que fer, per sort he aconseguit organitzarme el temps i buscar solucions als problemes que anava trobant.

  ## UML
 * Diagrama de classes.
 
 ![classes](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/diag1.png)
    
 * Diagrama de casos d'ús.
 
 ![classes](https://raw.githubusercontent.com/CarlaHeras/M3-UF4/master/fotos/diag2.png)