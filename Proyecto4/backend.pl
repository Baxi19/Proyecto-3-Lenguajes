%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
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
disponible(Profesor,Dia1,Dia2, Leccion1,Leccion2, Aula) :-
    %si el profesor no ha reservado ambos dias con las mismas lecciones en esa misma aula
    not(reservado(Profesor, _,Dia1,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado(Profesor, _,Dia1,Dia2, Leccion2,Leccion1, Aula,_)),
    not(reservado(Profesor, _,Dia2,Dia1, Leccion1,Leccion2, Aula,_)),
    not(reservado(Profesor, _,Dia2,Dia1, Leccion2,Leccion1, Aula,_)),

    %si el profesor no ha reservado ambos dias con las mismas lecciones en otra aula
    not(reservado(Profesor, _,Dia1,Dia2, Leccion1,Leccion2, _,_)),
    not(reservado(Profesor, _,Dia1,Dia2, Leccion2,Leccion1, _,_)),
    not(reservado(Profesor, _,Dia2,Dia1, Leccion1,Leccion2, _,_)),
    not(reservado(Profesor, _,Dia2,Dia1, Leccion2,Leccion1, _,_)),

    %si el profesor no ha reservado algun dia almenos una leccion en otra aula
    not(reservado(Profesor, _,Dia1,_, Leccion1,_, _,_)),
    not(reservado(Profesor, _,Dia1,_, Leccion2,_, _,_)),
    not(reservado(Profesor, _,_,Dia2, Leccion1,_, _,_)),
    not(reservado(Profesor, _,_,Dia2, Leccion2,_, _,_)),

    not(reservado(Profesor, _,Dia2,_, _,Leccion1, _,_)),
    not(reservado(Profesor, _,Dia2,_, _,Leccion2, _,_)),
    not(reservado(Profesor, _,_,Dia1, _,Leccion1, _,_)),
    not(reservado(Profesor, _,_,Dia1, _,Leccion2, _,_)),

    %si el aula se encuentra disponible
    not(reservado(_, _,Dia1,_, Leccion1,_, Aula,_)),
    not(reservado(_, _,Dia1,_, Leccion2,_, Aula,_)),
    not(reservado(_, _,_,Dia2, Leccion1,_, Aula,_)),
    not(reservado(_, _,_,Dia2, Leccion2,_, Aula,_)),

    not(reservado(_, _,Dia2,_, _,Leccion1, Aula,_)),
    not(reservado(_, _,Dia2,_, _,Leccion2, Aula,_)),
    not(reservado(_, _,_,Dia1, _,Leccion1, Aula,_)),
    not(reservado(_, _,_,Dia1, _,Leccion2, Aula,_)),

    %si algun otro profesor no ha reservado ambos dias con las mismas lecciones en esa misma aula
    not(reservado(_, _,Dia1,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado(_, _,Dia1,Dia2, Leccion2,Leccion1, Aula,_)),
    not(reservado(_, _,Dia2,Dia1, Leccion1,Leccion2, Aula,_)),
    not(reservado(_, _,Dia2,Dia1, Leccion2,Leccion1, Aula,_))
    .

%regla para saber si existe disponibilidad en un horario
disponible2(Profesor,Dia1,Dia2, Leccion1,Leccion2, Aula) :-
        %si el profesor no ha reservado ambos dias con las mismas lecciones en esa misma aula
    not(reservado2(Profesor, _,Dia1,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado2(Profesor, _,Dia1,Dia2, Leccion2,Leccion1, Aula,_)),
    not(reservado2(Profesor, _,Dia2,Dia1, Leccion1,Leccion2, Aula,_)),
    not(reservado2(Profesor, _,Dia2,Dia1, Leccion2,Leccion1, Aula,_)),

    %si el profesor no ha reservado ambos dias con las mismas lecciones en otra aula
    not(reservado2(Profesor, _,Dia1,Dia2, Leccion1,Leccion2, _,_)),
    not(reservado2(Profesor, _,Dia1,Dia2, Leccion2,Leccion1, _,_)),
    not(reservado2(Profesor, _,Dia2,Dia1, Leccion1,Leccion2, _,_)),
    not(reservado2(Profesor, _,Dia2,Dia1, Leccion2,Leccion1, _,_)),

    %si el profesor no ha reservado algun dia almenos una leccion en otra aula
    not(reservado2(Profesor, _,Dia1,_, Leccion1,_, _,_)),
    not(reservado2(Profesor, _,Dia1,_, Leccion2,_, _,_)),
    not(reservado2(Profesor, _,_,Dia2, Leccion1,_, _,_)),
    not(reservado2(Profesor, _,_,Dia2, Leccion2,_, _,_)),

    not(reservado2(Profesor, _,Dia2,_, _,Leccion1, _,_)),
    not(reservado2(Profesor, _,Dia2,_, _,Leccion2, _,_)),
    not(reservado2(Profesor, _,_,Dia1, _,Leccion1, _,_)),
    not(reservado2(Profesor, _,_,Dia1, _,Leccion2, _,_)),

    %si el aula se encuentra disponible
    not(reservado2(_, _,Dia1,_, Leccion1,_, Aula,_)),
    not(reservado2(_, _,Dia1,_, Leccion2,_, Aula,_)),
    not(reservado2(_, _,_,Dia2, Leccion1,_, Aula,_)),
    not(reservado2(_, _,_,Dia2, Leccion2,_, Aula,_)),

    not(reservado2(_, _,Dia2,_, _,Leccion1, Aula,_)),
    not(reservado2(_, _,Dia2,_, _,Leccion2, Aula,_)),
    not(reservado2(_, _,_,Dia1, _,Leccion1, Aula,_)),
    not(reservado2(_, _,_,Dia1, _,Leccion2, Aula,_)),

    %si algun otro profesor no ha reservado ambos dias con las mismas lecciones en esa misma aula
    not(reservado2(_, _,Dia1,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado2(_, _,Dia1,Dia2, Leccion2,Leccion1, Aula,_)),
    not(reservado2(_, _,Dia2,Dia1, Leccion1,Leccion2, Aula,_)),
    not(reservado2(_, _,Dia2,Dia1, Leccion2,Leccion1, Aula,_))

    .

%regla para saber si existe disponibilidad en un horario
disponible3(Profesor,Dia1,Dia2, Leccion1,Leccion2, Aula) :-
        %si el profesor no ha reservado ambos dias con las mismas lecciones en esa misma aula
    not(reservado3(Profesor, _,Dia1,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado3(Profesor, _,Dia1,Dia2, Leccion2,Leccion1, Aula,_)),
    not(reservado3(Profesor, _,Dia2,Dia1, Leccion1,Leccion2, Aula,_)),
    not(reservado3(Profesor, _,Dia2,Dia1, Leccion2,Leccion1, Aula,_)),

    %si el profesor no ha reservado ambos dias con las mismas lecciones en otra aula
    not(reservado3(Profesor, _,Dia1,Dia2, Leccion1,Leccion2, _,_)),
    not(reservado3(Profesor, _,Dia1,Dia2, Leccion2,Leccion1, _,_)),
    not(reservado3(Profesor, _,Dia2,Dia1, Leccion1,Leccion2, _,_)),
    not(reservado3(Profesor, _,Dia2,Dia1, Leccion2,Leccion1, _,_)),

    %si el profesor no ha reservado algun dia almenos una leccion en otra aula
    not(reservado3(Profesor, _,Dia1,_, Leccion1,_, _,_)),
    not(reservado3(Profesor, _,Dia1,_, Leccion2,_, _,_)),
    not(reservado3(Profesor, _,_,Dia2, Leccion1,_, _,_)),
    not(reservado3(Profesor, _,_,Dia2, Leccion2,_, _,_)),

    not(reservado3(Profesor, _,Dia2,_, _,Leccion1, _,_)),
    not(reservado3(Profesor, _,Dia2,_, _,Leccion2, _,_)),
    not(reservado3(Profesor, _,_,Dia1, _,Leccion1, _,_)),
    not(reservado3(Profesor, _,_,Dia1, _,Leccion2, _,_)),

    %si el aula se encuentra disponible
    not(reservado3(_, _,Dia1,_, Leccion1,_, Aula,_)),
    not(reservado3(_, _,Dia1,_, Leccion2,_, Aula,_)),
    not(reservado3(_, _,_,Dia2, Leccion1,_, Aula,_)),
    not(reservado3(_, _,_,Dia2, Leccion2,_, Aula,_)),

    not(reservado3(_, _,Dia2,_, _,Leccion1, Aula,_)),
    not(reservado3(_, _,Dia2,_, _,Leccion2, Aula,_)),
    not(reservado3(_, _,_,Dia1, _,Leccion1, Aula,_)),
    not(reservado3(_, _,_,Dia1, _,Leccion2, Aula,_)),

    %si algun otro profesor no ha reservado ambos dias con las mismas lecciones en esa misma aula
    not(reservado3(_, _,Dia1,Dia2, Leccion1,Leccion2, Aula,_)),
    not(reservado3(_, _,Dia1,Dia2, Leccion2,Leccion1, Aula,_)),
    not(reservado3(_, _,Dia2,Dia1, Leccion1,Leccion2, Aula,_)),
    not(reservado3(_, _,Dia2,Dia1, Leccion2,Leccion1, Aula,_))

    .


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
    disponible(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
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
    disponible(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
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
    disponible(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
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
    disponible(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
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
    disponible(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
    disponible3(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
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
    disponible(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
    disponible2(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
    disponible3(Profesor,Dia,Dia2, Hora1,Hora2, Aula),
    assert(reservado3(Profesor,Curso,Dia,Dia2, Hora1,Hora2, Aula, Semestre)),!.


