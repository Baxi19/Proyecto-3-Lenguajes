% Proyecto #3 de Lenguajes de Programacion.
% Randald Villegas Brenes
% 29/06/2020


%:- use_module(library(clpfd)).
:- use_module(library(jpl)).


simple(str) :-
    use_module(library(jpl)),
    jpl_new('java.lang.String',['Hello, World'],JS),
    format("Obtained Java String = ~q\n",[JS]),
    (jpl_is_object(JS) -> format("JS is an object\n") ; format("JS is NOT an object\n")),
    (atom(JS) -> format("JS is an atom\n") ; format("JS is NOT an atom\n")).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% cursos
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% findall(C->A->V->S->D,(curso(C),asignatura(C,A),creditos(C,V),semestre(C,S),dias(C,D)),Res).

curso(fundamentos).
curso(introduccion).
curso(taller).
curso(estructuras).
curso(poo).
curso(arquitectura).
curso(analisis).
curso(bases1).
curso(bases2).
curso(lenguajes).
curso(requerimientos).
curso(ap).
curso(compiladores).
curso(diseno).
curso(electiva1).
curso(io).
curso(operativos).
curso(calidad).
curso(compuSociedad).
curso(electiva2).
curso(ia).
curso(redes).
curso(proyectoS).
curso(practica).

asignatura(fundamentos,normal).
asignatura(introduccion, normal).
asignatura(taller, laboratorio ).
asignatura(estructuras, laboratorio ).
asignatura(poo,laboratorio ).
asignatura(arquitectura, normal).
asignatura(analisis, laboratorio ).
asignatura(bases1,laboratorio ).
asignatura(bases2,laboratorio ).
asignatura(lenguajes,laboratorio ).
asignatura(requerimientos, normal).
asignatura(ap, normal).
asignatura(compiladores, laboratorio ).
asignatura(diseno, laboratorio ).
asignatura(electiva1, laboratorio ).
asignatura(io, normal).
asignatura(operativos,laboratorio ).
asignatura(calidad, laboratorio ).
asignatura(compuSociedad, normal).
asignatura(electiva2, laboratorio ).
asignatura(ia, laboratorio ).
asignatura(redes, laboratorio ).
asignatura(proyectoS, laboratorio ).
asignatura(practica, laboratorio).

creditos(fundamentos,3).
creditos(introduccion, 3).
creditos(taller, 3 ).
creditos(estructuras, 4 ).
creditos(poo,3 ).
creditos(arquitectura, 4).
creditos(analisis, 4 ).
creditos(bases1,4 ).
creditos(bases2,3 ).
creditos(lenguajes,4 ).
creditos(requerimientos, 4).
creditos(ap, 4).
creditos(compiladores, 4 ).
creditos(diseno, 4 ).
creditos(electiva1, 3 ).
creditos(io, 4).
creditos(operativos,4 ).
creditos(calidad, 3 ).
creditos(compuSociedad, 2).
creditos(electiva2, 4 ).
creditos(ia, 4 ).
creditos(redes, 4 ).
creditos(proyectoS, 3 ).
creditos(practica,12).

semestre(fundamentos,1).
semestre(introduccion, 1).
semestre(taller,1 ).
semestre(estructuras, 2).
semestre(poo,2).
semestre(arquitectura, 2).
semestre(analisis, 3).
semestre(bases1,3).
semestre(bases2,4 ).
semestre(lenguajes,4 ).
semestre(requerimientos, 4).
semestre(ap, 5).
semestre(compiladores, 5 ).
semestre(diseno, 5 ).
semestre(electiva1, 6 ).
semestre(io, 6).
semestre(operativos,6).
semestre(calidad, 6).
semestre(compuSociedad, 6).
semestre(electiva2, 7).
semestre(ia, 7).
semestre(redes, 7).
semestre(proyectoS, 7).
semestre(practica,8).

dias(fundamentos,2).
dias(introduccion, 2).
dias(taller,1).
dias(estructuras, 1).
dias(poo,2).
dias(arquitectura, 1).
dias(analisis, 2).
dias(bases1,1).
dias(bases2,2).
dias(lenguajes,1).
dias(requerimientos, 2).
dias(ap, 1).
dias(compiladores, 2).
dias(diseno, 1).
dias(electiva1, 2).
dias(io, 1).
dias(operativos,2).
dias(calidad, 1).
dias(compuSociedad, 2).
dias(electiva2, 1).
dias(ia, 2).
dias(redes, 1).
dias(proyectoS, 2).
dias(practica,5).

%Para calcular los semestres, si es par o no
par(X) :- 0 is X mod 2.
impar(X) :- 1 is X mod 2.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%profesores
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% findall(P->A->C->D->I, (profesor(P),apellidos(P,A),cedula(P,C),disponibildad(P,D),imparte(P,I)),Res).

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
imparte(marlen, [bases1, bases2, calidad]).
imparte(leo,    [bases2]).
imparte(oscar,  [compiladores, lenguajes]).
imparte(vera,   [introduccion, taller, compuSociedad]).
imparte(rogelio,[ia, io, redes, electiva1, electiva2]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%aulas
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%findall(A->C->T, (aula(A),capacidad(A,C), tipo(A,T)),Res).
aula(lab-01).
aula(lab-02).
aula(auc-01).
aula(mvl-01).
aula(e-10).
aula(e-11).
aula(e-12).
aula(e-13).
aula(e-14).
aula(e-15).

capacidad(lab-01,20).
capacidad(lab-02,20).
capacidad(auc-01,24).
capacidad(mvl-01,20).
capacidad(e-10,  24).
capacidad(e-11,  24).
capacidad(e-12,  28).
capacidad(e-13,  24).
capacidad(e-14,  24).
capacidad(e-15,  20).

tipo(lab-01,laboratorio).
tipo(lab-02,laboratorio).
tipo(auc-01,laboratorio).
tipo(mvl-01,laboratorio).
tipo(e-10,  normal).
tipo(e-11,  normal).
tipo(e-12,  normal).
tipo(e-13,  normal).
tipo(e-14,  normal).
tipo(e-15,  normal).



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



