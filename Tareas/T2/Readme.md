- ### **Moneda** : tipo de datos es crearMoneda, nombrarMoneda, listarMoneda, existeMoneda, transferir, transferirEntreUsuarios. 

- ### **Descripción** : los valores del TDA Moneda son objetos de tipo Moneda que poseen un nombre, material y una cantidad. El TDA Moneda es mutable.

- ### **Operaciones**:

    - *crearMoneda* (nombre, material, total; Cadena, cadena, decimal) *devuelve* (Moneda) 
        - requerimientos: total >= 0.
        - efecto : crea una moneda con los parámetros introducidos.
    
    - *nombrarMoneda* (nombre; Cadena) *devuelve* ( )
        - requerimientos: cadena no vacia.
        - modifica : nombre de objeto Moneda.
    
    - *listarMoneda* ( ) *devuelve* (monedas; Arreglo)
        - requerimientos: existencia de objetos Monedas creados.
        - efecto: mostrar listado de las monedas existenes.
    
    - *existeMoneda* (nombre; Cadena) *devuelve* (resultado; Booleano)
        - efecto: devuelve el valor de verdad indicando la existencia de Monedas,
    
    - *transferir* (monto; decimal) *devuelve* ( )
        - requerimientos: monto que no supere el total disponible.
        - efecto: transacción de bienes.
        - modifica: valor de monedas del usuario.

     - *transferirEntreUsuarios* (nombre, nombre, monto; Cadena, cadena, decimal) *devuelve* ()
        - requerimientos: total disponible no negativo al sustraer el monto solicitado.
        - modifica : valor de monedas entre dos usuarios del sistema.

![ Moneda ](https://upload.wikimedia.org/wikipedia/commons/5/5e/Assorted_United_States_coins.jpg)






