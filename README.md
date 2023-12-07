# Domino-Piece
-Contexto:
En el marco del curso de Arquitectura de Software, me complace presentar la propuesta para nuestro proyecto titulado "Domino Piece". Este proyecto tiene como objetivo principal diseñar, desarrollar y desplegar un juego de dominó digital que brinde una experiencia intuitiva y atractiva para los usuarios adaptandonos a estilo arquitectonico que en nuestro caso es "Pipes and Filters".
Este es un juego de domino con tematica de one piece

-¿Como inicializar Partida?
Para iniciar el juego Domino Piece, es necesario inicializar la clase principal llamada "Server" que se encuentra en el componente DominoPieceServer. En el caso de jugar localmente o en diferentes dispositivos, puedes acceder al componente DominoPiece en el paquete SocketCliente y entrar a la clase "Cliente". Dentro de esta, encontrarás una instancia del Cliente en la cual deberás dejarlo como "localhost" si deseas jugar localmente. En caso de jugar en línea, deberás cambiar la palabra por una dirección IP válida que funcione como el servidor. Además, puedes seleccionar cualquier puerto de cuatro dígitos.

Una vez que hayas inicializado la clase, aparecerá un mensaje indicando que el puerto está abierto en el puerto seleccionado. Es fundamental dejarlo abierto para que el programa funcione correctamente. Posteriormente, para iniciar el juego y jugar de manera local, debes acceder al componente llamado DominoPiece en el paquete dominoPiece. Dentro de este, encontrarás una clase principal llamada "DominoPiece" que ejecutará el juego de manera intuitiva.

Al crear una partida, podrás seleccionar las fichas del usuario, y después de crearla, se te dirigirá a la selección de tu avatar. Debes escoger un avatar de entre los cuatro presentados en la pantalla haciendo clic en un checkbox. Luego, pasarás a una pantalla de espera donde podrás seleccionar "iniciar votación" para comenzar la partida, en caso de no contar con los cuatro jugadores necesarios (mínimo 2 usuarios y máximo 3 para poder iniciarla).

Si deseas agregar otro usuario, inicia el programa nuevamente y selecciona "unirse a partida". Automáticamente, se te informará que se encontró una partida, y se te dirigirá a la selección de un avatar. En caso de que un usuario repita un avatar, se mostrará un mensaje indicando que ya está en uso y no se le permitirá seleccionarlo. Una vez que los usuarios se unan, podrán iniciar la votación mencionada anteriormente para comenzar el juego, y si son cuatro jugadores, este se iniciará automáticamente.


-Explicacion rapida de nuestro estilo arquitectonico utilizado.
La arquitectura de software Pipes and Filters, conocida por su modularidad y flexibilidad, sirve como el cimiento de Domino Piece. Este modelo divide el sistema en componentes independientes y conectados, llamados "filtros", que se comunican a través de "pipes" unidireccionales. Cada filtro realiza una tarea específica, permitiendo la fácil extensión y mantenimiento del sistema.
