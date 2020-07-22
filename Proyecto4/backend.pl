% Proyecto #3 de Lenguajes de Programacion.
% Randald Villegas Brenes
% 29/06/2020


%:- use_module(library(clpfd)).

%:- module(prolog_vm).
%:- use_module(library(jpl)).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% cursos
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% findall(C->A->V->S->D,(curso(C),asignatura(C,A),creditos(C,V),semestre(C,S),cantidad_dias(C,D)),Res).

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

asignatura(fundamentos,  "normal").
asignatura(introduccion, "normal").
asignatura(taller,       "laboratorio").
asignatura(estructuras,  "laboratorio").
asignatura(poo,          "laboratorio" ).
asignatura(arquitectura, "normal").
asignatura(analisis,     "laboratorio" ).
asignatura(bases1,       "laboratorio" ).
asignatura(bases2,       "laboratorio" ).
asignatura(lenguajes,    "laboratorio" ).
asignatura(requerimientos,"normal").
asignatura(ap,           "normal").
asignatura(compiladores, "laboratorio" ).
asignatura(diseno,       "laboratorio" ).
asignatura(electiva1,    "laboratorio" ).
asignatura(io,           "normal").
asignatura(operativos,   "laboratorio" ).
asignatura(calidad,      "laboratorio" ).
asignatura(compuSociedad,"normal").
asignatura(electiva2,    "laboratorio" ).
asignatura(ia,           "laboratorio" ).
asignatura(redes,        "laboratorio" ).
asignatura(proyectoS,    "laboratorio" ).
asignatura(practica,     "laboratorio").

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

cantidad_dias(fundamentos,2).
cantidad_dias(introduccion, 2).
cantidad_dias(taller,1).
cantidad_dias(estructuras, 1).
cantidad_dias(poo,2).
cantidad_dias(arquitectura, 1).
cantidad_dias(analisis, 2).
cantidad_dias(bases1,1).
cantidad_dias(bases2,2).
cantidad_dias(lenguajes,1).
cantidad_dias(requerimientos, 2).
cantidad_dias(ap, 1).
cantidad_dias(compiladores, 2).
cantidad_dias(diseno, 1).
cantidad_dias(electiva1, 2).
cantidad_dias(io, 1).
cantidad_dias(operativos,2).
cantidad_dias(calidad, 1).
cantidad_dias(compuSociedad, 2).
cantidad_dias(electiva2, 1).
cantidad_dias(ia, 2).
cantidad_dias(redes, 1).
cantidad_dias(proyectoS, 2).
cantidad_dias(practica,2).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%profesores
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% findall(P->A->C->D->I,(profesor(P),apellidos(P,A),cedula(P,C),disponibilidad(P,D),imparte(P,I)),Res).


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

imparte(alejandro, diseno).
imparte(alejandro, requerimientos).
imparte(rocio,  estructuras).
imparte(rocio,  fundamentos).
imparte(abel,   bases1).
imparte(abel,   proyectoS).
imparte(abel,   io).
imparte(abel,   ia).
imparte(diego,  fundamentos).
imparte(diego,  proyectoS).
imparte(diego,  estructuras).
imparte(efren,  bases1).
imparte(efren,  bases2).
imparte(efren,  analisis).
imparte(efren,  electiva2).
imparte(lorena, analisis).
imparte(lorena, bases1).
imparte(lorena, poo).
imparte(jorge,  operativos).
imparte(jorge,  arquitectura).
imparte(marlen, bases1).
imparte(marlen, bases2).
imparte(marlen, calidad).
imparte(marlen, poo).
imparte(leo,    bases2).
imparte(leo,    ap).
imparte(leo,    electiva1).
imparte(oscar,  compiladores).
imparte(oscar,  lenguajes).
imparte(oscar,  practica).
imparte(vera,   introduccion).
imparte(vera,   taller).
imparte(vera,   compuSociedad).
imparte(rogelio,ia).
imparte(rogelio,io).
imparte(rogelio,redes).
imparte(rogelio,electiva1).
imparte(rogelio,electiva2).
imparte(rogelio,practica).


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

tipo(lab-01,"laboratorio").
tipo(lab-02,"laboratorio").
tipo(auc-01,"laboratorio").
tipo(mvl-01,"laboratorio").
tipo(e-10,  "normal").
tipo(e-11,  "normal").
%tipo(e-12,  "normal").
%tipo(e-13,  "normal").
%tipo(e-14,  "normal").
%tipo(e-15,  "normal").

%tipo(X,Y).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%lecciones
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% findall(Leccion->Dia->Hora,(leccion(Leccion),dia_leccion(Leccion,Dia),hora_leccion(Leccion,Hora)),Resultado).

leccion(l_1).
leccion(l_2).
leccion(l_3).
leccion(l_4).
%leccion(l_5).
%leccion(l_6).
%leccion(l_7).
%leccion(l_8).

bloque(manana_1, l_1).
bloque(manana_2, l_2).
bloque(tarde_1, l_3).
bloque(tarde_2, l_4).

dia_leccion(l_1, l).
dia_leccion(l_2, l).
dia_leccion(l_3, l).
dia_leccion(l_4, l).
%dia_leccion(l_5, l).
%dia_leccion(l_6, l).
%dia_leccion(l_7, l).
%dia_leccion(l_8, l).

dia_leccion(l_1, k).
dia_leccion(l_2, k).
dia_leccion(l_3, k).
dia_leccion(l_4, k).
%dia_leccion(l_5, k).
%dia_leccion(l_6, k).
%dia_leccion(l_7, k).
%dia_leccion(l_8, k).

dia_leccion(l_1, m).
dia_leccion(l_2, m).
dia_leccion(l_3, m).
dia_leccion(l_4, m).
%dia_leccion(l_5, m).
%dia_leccion(l_6, m).
%dia_leccion(l_7, m).
%dia_leccion(l_8, m).

dia_leccion(l_1, j).
dia_leccion(l_2, j).
dia_leccion(l_3, j).
dia_leccion(l_4, j).
%dia_leccion(l_5, j).
%dia_leccion(l_6, j).
%dia_leccion(l_7, j).
%dia_leccion(l_8, j).

dia_leccion(l_1, v).
dia_leccion(l_2, v).
dia_leccion(l_3, v).
dia_leccion(l_4, v).
%dia_leccion(l_5, v).
%dia_leccion(l_6, v).
%dia_leccion(l_7, v).
%dia_leccion(l_8, v).

hora_leccion(l_1,"07:55 - 09:40" ).
%hora_leccion(l_1,"08:50 - 09:40" ).
hora_leccion(l_2,"09:45 - 11:30" ).
%hora_leccion(l_2,"10:40 - 11:30" ).
hora_leccion(l_3,"12:30 - 02:15" ).
%hora_leccion(l_3,"01:25 - 02:15" ).
hora_leccion(l_4,"02:20 - 04:05" ).
%hora_leccion(l_4,"03:15 - 04:05" ).





%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%REGLAS
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Para calcular los semestres, si es par o no
par(X) :- 0 is X mod 2.
impar(X) :- 1 is X mod 2.

%Para buscar una leccion a que bloque pertenece
%buscar_bloque(l_4, Bloque).
buscar_bloque(X, Bloque) :-
    bloque(Bloque, X),!.


%para almacenar todos los horarios posibles por profesor y sus aulas
% horario(Leccion,Dias, Horario,Bloque,Curso,Creditos,Semestre, Cantidad_dias, Aula,Capacidad, Profesor).
horario(Leccion,Dia, Horario,Bloque, Curso,Creditos,Semestre, Cantidad_dias, Aula ,Capacidad, Profesor) :-
    asignatura(Curso,Tipo_curso),
    aula(Aula),
    tipo(Aula, Tipo_aula),
    capacidad(Aula, Capacidad),
    (Tipo_curso = Tipo_aula),
    profesor(Profesor),
    curso(Curso),
    creditos(Curso,Creditos),
    semestre(Curso,Semestre),
    cantidad_dias(Curso, Cantidad_dias),
    imparte(Profesor, Curso),
    disponibilidad(Profesor, Lista),
    leccion(Leccion),
    buscar_bloque(Leccion, Bloque),
    dia_leccion(Leccion, Dia),
    member(Dia, Lista),
    hora_leccion(Leccion,Horario).


%Se obtiene una lista con todas las lecciones disponibles
todas_lecciones(Resultado) :-
    findall(Leccion->Dia->Hora,(leccion(Leccion),dia_leccion(Leccion,Dia),hora_leccion(Leccion,Hora)),Resultado).

%se obtiene una lista con todos los cursos disponibles
todos_cursos(Resultado) :-
    findall(Curso->Asignatura->Peso->Semestre->Dia,(curso(Curso),asignatura(Curso,Asignatura),creditos(Curso,Peso),semestre(Curso,Semestre),cantidad_dias(Curso,Dia)),Resultado).

%se obtiene una lista con todos los datos de los profesores disponibles
todos_profesores(Resultado) :-
    findall(Profesor->Apellidos->Cedula->Disponibilidad->Imparte,(profesor(Profesor),apellidos(Profesor,Apellidos),cedula(Profesor,Cedula),disponibilidad(Profesor,Disponibilidad),imparte(Profesor,Imparte)),Resultado).

%se obtiene una lista con la informacion de todas las aulas
todas_aulas(Resultado) :-
    findall(Aula->Capacidad->Tipo, (aula(Aula),capacidad(Aula,Capacidad),tipo(Aula,Tipo)),Resultado).

%para saber si es mienbro de una lista
es_miembro(X,[X|_]).
es_miembro(X,[_|T]):-es_miembro(X,T).
