%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%REGLAS
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
:- dynamic reservado/8.
:- dynamic reservado2/8.
:- dynamic reservado3/8.

%reservado(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre).



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
    not(reservado(_, _,Dia,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado(_, _,Dia,Dia2, Leccion2,Leccion1, Aula,_)),

    not(reservado(_, _,Dia,_, Leccion2,_, Aula,_)),
    not(reservado(_, _,Dia,_, Leccion1,_, Aula,_)),

    not(reservado(_, _,_,Dia2, Leccion1,_, Aula,_)),
    not(reservado(_, _,_,Dia2, Leccion2,_, Aula,_)),

    not(reservado(_, _,Dia,_, _,Leccion2, Aula,_)),
    not(reservado(_, _,Dia,_, _,Leccion1, Aula,_)),

    not(reservado(_, _,_,Dia2, _,Leccion1, Aula,_)),
    not(reservado(_, _,_,Dia2, _,Leccion2, Aula,_)).

%regla para saber si existe disponibilidad en un horario
disponible2(Dia,Dia2, Leccion1,Leccion2, Aula) :-
    not(reservado2(_, _,Dia,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado2(_, _,Dia,Dia2, Leccion2,Leccion1, Aula,_)),

    not(reservado2(_, _,Dia,_, Leccion2,_, Aula,_)),
    not(reservado2(_, _,Dia,_, Leccion1,_, Aula,_)),

    not(reservado2(_, _,_,Dia2, Leccion1,_, Aula,_)),
    not(reservado2(_, _,_,Dia2, Leccion2,_, Aula,_)),

    not(reservado2(_, _,Dia,_, _,Leccion2, Aula,_)),
    not(reservado2(_, _,Dia,_, _,Leccion1, Aula,_)),

    not(reservado2(_, _,_,Dia2, _,Leccion1, Aula,_)),
    not(reservado2(_, _,_,Dia2, _,Leccion2, Aula,_)).

%regla para saber si existe disponibilidad en un horario
disponible3(Dia,Dia2, Leccion1,Leccion2, Aula) :-
    not(reservado3(_, _,Dia,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado3(_, _,Dia,Dia2, Leccion2,Leccion1, Aula,_)),

    not(reservado3(_, _,Dia,_, Leccion2,_, Aula,_)),
    not(reservado3(_, _,Dia,_, Leccion1,_, Aula,_)),

    not(reservado3(_, _,_,Dia2, Leccion1,_, Aula,_)),
    not(reservado3(_, _,_,Dia2, Leccion2,_, Aula,_)),

    not(reservado3(_, _,Dia,_, _,Leccion2, Aula,_)),
    not(reservado3(_, _,Dia,_, _,Leccion1, Aula,_)),

    not(reservado3(_, _,_,Dia2, _,Leccion1, Aula,_)),
    not(reservado3(_, _,_,Dia2, _,Leccion2, Aula,_)).


%reglas para obtener las relaciones de los horarios de un solo dia
horario(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 1,
    dia(Dia),
    dia(Dia2),
    Dia = Dia2,
    leccion(Leccion, Dia, Hora1, _),
    leccion(Leccion2, Dia2,Hora2, _),
    not(Leccion = Leccion2),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Hora1,Hora2, Aula),
    assert(reservado(Profesor,Curso,Dia,Dia2, Hora1,Hora2, Aula, Semestre)),!.


%reglas para obtener las relaciones de los horarios de dos dias con cursos de 2
% dias diferentes
horario(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 2,
    dia(Dia2),
    dia(Dia), %OR
    not(Dia = Dia2),
    leccion(Leccion, Dia, Hora1, _),
    leccion(Leccion2, Dia2,Hora2, _),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Hora1,Hora2, Aula),
    assert(reservado(Profesor,Curso,Dia,Dia2, Hora1,Hora2, Aula, Semestre)),!.


% reglas para obtener las relaciones de dos horarios y de cursos que se
% imparten 1 solo dia
horario2(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 1,
    dia(Dia),
    dia(Dia2),
    Dia = Dia2,
    leccion(Leccion, Dia, Hora1, _),
    leccion(Leccion2, Dia2,Hora2, _),
    not(Leccion = Leccion2),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Dia,Dia2, Hora1,Hora2, Aula),
    assert(reservado2(Profesor,Curso,Dia,Dia2, Hora1,Hora2, Aula, Semestre)),!.


%reglas para obtener las relaciones de dos horarios con cursos de 2
% dias diferentes
horario2(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 2,
    dia(Dia2),
    dia(Dia), %OR
    not(Dia = Dia2),
    leccion(Leccion, Dia, Hora1, _),
    leccion(Leccion2, Dia2,Hora2, _),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Dia,Dia2, Hora1,Hora2, Aula),
    assert(reservado2(Profesor,Curso,Dia,Dia2, Hora1,Hora2, Aula, Semestre)),!.





% reglas para obtener las relaciones de tres horarios con cursos que se
% imparten 1 solo dia
horario3(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 1,
    dia(Dia),
    dia(Dia2),
    Dia = Dia2,
    leccion(Leccion, Dia, Hora1, _),
    leccion(Leccion2, Dia2,Hora2, _),
    not(Leccion = Leccion2),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Dia,Dia2, Hora1,Hora2, Aula),
    disponible3(Dia,Dia2, Hora1,Hora2, Aula),
    assert(reservado3(Profesor,Curso,Dia,Dia2, Hora1,Hora2, Aula, Semestre)),!.


% reglas para obtener las relaciones de tres horarios con cursos de 2
% dias diferentes
horario3(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 2,
    dia(Dia2),
    dia(Dia), %OR
    not(Dia = Dia2),
    leccion(Leccion, Dia, Hora1, _),
    leccion(Leccion2, Dia2,Hora2, _),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
    imparte(Profesor, Curso),
    disponible(Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Dia,Dia2, Hora1,Hora2, Aula),
    disponible3(Dia,Dia2, Hora1,Hora2, Aula),
    assert(reservado3(Profesor,Curso,Dia,Dia2, Hora1,Hora2, Aula, Semestre)),!.


