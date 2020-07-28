%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%REGLAS
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
:- dynamic reservado/7.
%reservado(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula).



%Solucion pregunta #2
%profesor, semestre, curso, disponibilidad, imparte
solucion(Profesor, Curso, Semestre, Dia) :-
    profesor(Profesor, _, _),
    curso(Curso, _, _, Semestre, _),
    imparte(Profesor, Curso),
    dia(Dia),
    disponibilidad(Profesor, Dia).

%regla para saber si existe disponibilidad en un horario
disponible(Dia,Dia2, Leccion1,Leccion2, Aula) :-
    Dia = Dia2,
    not(reservado(_, _,Dia,Dia2, Leccion1,Leccion2, Aula)),
    not(reservado(_, _,Dia,Dia2, Leccion2,Leccion1, Aula)),

    not(reservado(_, _,Dia,_, Leccion2,_, Aula)),
    not(reservado(_, _,Dia,_, Leccion1,_, Aula)),

    not(reservado(_, _,_,Dia2, Leccion1,_, Aula)),
    not(reservado(_, _,_,Dia2, Leccion2,_, Aula)),

    not(reservado(_, _,Dia,_, _,Leccion2, Aula)),
    not(reservado(_, _,Dia,_, _,Leccion1, Aula)),

    not(reservado(_, _,_,Dia2, _,Leccion1, Aula)),
    not(reservado(_, _,_,Dia2, _,Leccion2, Aula)).

%retractall(reservado(_,_,_,_,_,_,_)).

%reglas para obtener las relaciones de los horarios de un solo dia
horario(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 1,
    dia(Dia),
    dia(Dia2),
    Dia = Dia2,
    leccion(Leccion, Dia, _, _),
    leccion(Leccion2, Dia2, _, _),
    %bloque_manana(leccion(Leccion, _, _, _),leccion(Leccion2, _, _, _));
    %bloque_tarde(leccion(Leccion, _, _, _),leccion(Leccion2, _, _, _)),
    not(Leccion = Leccion2),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Leccion,Leccion2, Aula),
    assert(reservado(Profesor,Curso,Dia,Dia2, Leccion,Leccion2, Aula)),!.


%reglas para obtener las relaciones de los horarios de dos dias
horario(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 2,
    dia(Dia2),
    dia(Dia), %OR
    not(Dia = Dia2),
    leccion(Leccion, Dia, _, _),
    leccion(Leccion2, Dia2, _, _),
    %bloque_manana(leccion(Leccion, _, _, _),leccion(Leccion2, _, _, _));
    %bloque_tarde(leccion(Leccion, _, _, _),leccion(Leccion2, _, _, _)),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Leccion,Leccion2, Aula),
    assert(reservado(Profesor,Curso,Dia,Dia2, Leccion,Leccion2, Aula)),!.

