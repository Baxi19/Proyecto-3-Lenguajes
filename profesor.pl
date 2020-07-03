%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%profesores
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% findall(Profesor->Apellidos->Cedula->Disponibilidad->Imparte,(profesor(Profesor),apellidos(Profesor,Apellidos),cedula(Profesor,Cedula),disponibilidad(Profesor,Disponibilidad),imparte(Profesor,Imparte)),Resultado).



profesor(alejandro).
profesor(rocio).
profesor(abel).
profesor(diego).
profesor(efren).
profesor(lorena).
profesor(jorge).
profesor(marlen).
profesor(leo).
profesor(oscar).
profesor(vera).
profesor(rogelio).

apellidos(alejandro, "Alfaro Quesada").
apellidos(rocio, "Quiros Oviedo").
apellidos(abel, "Mendez Porras").
apellidos(diego, "Rojas Vega").
apellidos(efren, "Jimenez Delgado").
apellidos(lorena, "Valerio Solis").
apellidos(jorge, "Alfaro Velasco").
apellidos(marlen, "Trevi�o Villalobos").
apellidos(leo, "Viquez Acu�a").
apellidos(oscar, "Viquez Acu�a").
apellidos(vera, "Gamboa Guzman").
apellidos(rogelio, "Gonzalez Quiros").

cedula(alejandro, "1-846-952").
cedula(rocio, "1-951-912").
cedula(abel, "7-511-626").
cedula(diego, "6-625-518").
cedula(efren, "3-818-292").
cedula(lorena, "6-514-651").
cedula(jorge, "2-651-611").
cedula(marlen, "6-515-321").
cedula(leo, "3-216-566").
cedula(oscar, "5-616-612").
cedula(vera, "4-646-654").
cedula(rogelio, "6-545-613").


disponibilidad(alejandro, [l, k]).
disponibilidad(rocio,  [m]).
disponibilidad(abel,   [l, v]).
disponibilidad(diego,  [j, v]).
disponibilidad(efren,  [l, k, m, j]).
disponibilidad(lorena, [l, k, m, j]).
disponibilidad(jorge,  [l, k, m,j]).
disponibilidad(marlen, [l,k,m, j]).
disponibilidad(leo,    [l,k, m, v]).
disponibilidad(oscar,  [l, k, m, j]).
disponibilidad(vera,   [l,k,m, j]).
disponibilidad(rogelio,[l, k, m,v]).

imparte(alejandro, [requerimientos, diseno]).
imparte(rocio,  [fundamentos, estructuras]).
imparte(abel,   [bases1, proyectoS, io, ia]).
imparte(diego,  [fundamentos, proyectoS, estructuras]).
imparte(efren,  [bases1, bases2, analisis,electiva2]).
imparte(lorena, [analisis, bases1, poo]).
imparte(jorge,  [operativos, arquitectura]).
imparte(marlen, [bases1, bases2, calidad, poo]).
imparte(leo,    [bases2, ap,electiva1]).
imparte(oscar,  [compiladores, lenguajes,electiva2, practica]).
imparte(vera,   [introduccion, taller, compuSociedad]).
imparte(rogelio,[ia, io, redes, electiva1, electiva2,practica]).


