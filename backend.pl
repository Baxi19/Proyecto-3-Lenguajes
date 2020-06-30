% Proyecto #3 de Lenguajes de Programacion.
% Randald Villegas Brenes
% 29/06/2020

%profesores
%findall(P->A->C->D->I, (profesor(P),apellidos(P,A), cedula(P,C),disponibilidad(P,D),imparte(P,I)),Res).
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
apellidos(marlen, "Treviño Villalobos").
apellidos(leo, "Viquez Acuña").
apellidos(oscar, "Viquez Acuña").
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

disponibilidad(alejandro, [lunes, martes]).
disponibilidad(rocio,  [miercoles]).
disponibilidad(abel,   [lunes, viernes]).
disponibilidad(diego,  [jueves, viernes]).
disponibilidad(efren,  [lunes, martes, miercoles, jueves]).
disponibilidad(lorena, [lunes, martes, miercoles, jueves]).
disponibilidad(jorge,  [lunes, martes, miercoles, jueves]).
disponibilidad(marlen, [lunes, martes, miercoles, jueves]).
disponibilidad(leo,    [lunes, martes, miercoles, jueves]).
disponibilidad(oscar,  [lunes, martes, jueves, viernes]).
disponibilidad(vera,   [lunes, martes, miercoles, jueves]).
disponibilidad(rogelio,[lunes, martes, jueves, viernes]).

imparte(alejandro, [requerimientos, diseno]).
imparte(rocio,  [fundamentos]).
imparte(abel,   [bases1, proyecto]).
imparte(diego,  [fundamentos, proyecto]).
imparte(efren,  [bases1, bases2, analisis]).
imparte(lorena, [analisis, bases1, poo]).
imparte(jorge,  [operativos, arquitectura]).
imparte(marlen, [bases1, bases2, qa]).
imparte(leo,    [bases2]).
imparte(oscar,  [compiladores, lenguajes]).
imparte(vera,   [introduccion, taller, computacion_sociedad]).
imparte(rogelio,[ia, investigacion_operaciones, redes, electiva1, electiva2]).


%aulas
%findall(A->C->T, (aula(A),capacidad(A,C), tipo(A,T)),Res).
aula(lab-01).
aula(lab-02).
aula(auc-01).
aula(mvl-01).
aula(e  -10).

capacidad(lab-01,20).
capacidad(lab-02,20).
capacidad(auc-01,24).
capacidad(mvl-01,20).
capacidad(e-10,  24).

tipo(lab-01,laboratorio).
tipo(lab-02,laboratorio).
tipo(auc-01,aula).
tipo(mvl-01,laboratorio).
tipo(e-10,  aula).


%horarios semanales
horario(l,"07:55","08:45").
horario(l,"08:50","09:40").
horario(l,"09:45","10:35").
horario(l,"10:40","11:30").
horario(l,"12:30","01:20").
horario(l,"01:25","02:15").
horario(l,"02:20","03:10").
horario(l,"03:15","04:05").

horario(k,"07:55","08:45").
horario(k,"08:50","09:40").
horario(k,"09:45","10:35").
horario(k,"10:40","11:30").
horario(k,"12:30","01:20").
horario(k,"01:25","02:15").
horario(k,"02:20","03:10").
horario(k,"03:15","04:05").

horario(m,"07:55","08:45").
horario(m,"08:50","09:40").
horario(m,"09:45","10:35").
horario(m,"10:40","11:30").
horario(m,"12:30","01:20").
horario(m,"01:25","02:15").
horario(m,"02:20","03:10").
horario(m,"03:15","04:05").

horario(j,"07:55","08:45").
horario(j,"08:50","09:40").
horario(j,"09:45","10:35").
horario(j,"10:40","11:30").
horario(j,"12:30","01:20").
horario(j,"01:25","02:15").
horario(j,"02:20","03:10").
horario(j,"03:15","04:05").

horario(v,"07:55","08:45").
horario(v,"08:50","09:40").
horario(v,"09:45","10:35").
horario(v,"10:40","11:30").
horario(v,"12:30","01:20").
horario(v,"01:25","02:15").
horario(v,"02:20","03:10").
horario(v,"03:15","04:05").


%buscarHorario(X, 01:25","02:15").
%buscarHorario(lunes, X, Y).


buscarHorario(Dia, Inicio, Fin) :-
    horario(Dia, Inicio, Fin).





% curso(Codigo,Materia,Horas,Creditos)

%curso("CA3125","Analisis Y Diseño De Algoritmos",3.5, 3).

%curso("IC1400","Fundamentos De Organizacion De Computadoras",3.5, 3).



curso("CA3125","Analisis Y Diseño De Algoritmos",3.5, 3).


curso(prolog,horario(lunes,9,12),profesor(eduardo,morales),lugar(ccc,8301)).


