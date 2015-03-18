# Build Dojo Howto #

Pour construire le projet dojo-wombat, il faut :
  * récupérer via svn le projet, tout est expliqué [ici](http://code.google.com/p/jugbordeaux/source/checkout) mais plus particulièrement le projet qui nous intéresse est https://jugbordeaux.googlecode.com/svn/trunk/200911-dojo/
  * utiliser [maven](http://maven.apache.org) pour lancer le build :
` mvn clean install `

Il est prévu de le rendre "eclipse compatible" grâce au plugin maven eclipse.