# INSTRUCCIONES

Tres en Raya es un clásico juego de tablero donde dos jugadores, el humano y la máquina, compiten por alinear tres de sus símbolos (X o O) en una fila, columna o diagonal. El juego se juega en un tablero de 3x3 casillas, y el primero en lograr una alineación gana la partida. Si el tablero se llena sin que haya un ganador, el juego termina en empate.

En esta versión del juego, el jugador compite contra la máquina, que juega a nivel de dificultad simple. La máquina toma decisiones en función del nivel seleccionado, y el jugador humano realiza sus movimientos introduciendo las coordenadas de las casillas que desea marcar.

>- **Clase motor3R.TresEnRaya**
Esta clase se encarga de la lógica principal del juego y controla el estado del tablero. No solo almacena la información del tablero, sino que también gestiona la lógica de la partida:
>   - Controla el avance del juego, incluyendo la verificación de si la partida ha terminado.
>   - Permite consultar si la partida terminó, y si es así, determina si el ganador es el jugador humano, la máquina o si hubo un empate (es decir, si el tablero está lleno pero no se logró una alineación).
>   - Cuando la máquina juega, es esta clase la que toma la decisión sobre dónde colocar su movimiento, basándose en el nivel de dificultad seleccionado al inicio de la partida.
>
>- **Clase InterfaceConsola**
La clase InterfaceConsola actúa como la interfaz entre el usuario y la lógica del juego (la clase motor3R.TresEnRaya). Dado que se trata de una interfaz de consola, esta clase contiene el método principal (main()) y es responsable de:
>   - Recoger las coordenadas introducidas por el jugador humano.
>   - Enviar esos datos a la clase TresEnRaya para realizar los movimientos en el tablero.
>   - Preguntar a la clase TresEnRaya si la partida ha terminado y, en caso afirmativo, mostrar el resultado al u  usuario, indicando si ganó el jugador, la máquina o si hubo empate.
>   - Asume que el jugador siempre introduce datos correctos, es decir, no elige casillas ya ocupadas.

El juego se limita a la modalidad Jugador Humano vs Máquina, y la interacción se realiza a través de la consola, donde el jugador debe indicar las coordenadas de las casillas en formato "fila columna", empezando desde 1 para filas y columnas. Si el jugador intenta colocar su movimiento en una casilla ocupada, el juego lo avisa y le solicita que elija otra.
