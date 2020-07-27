%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%REGLAS
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
:- dynamic reservado/2.
reservado(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre).

%Para calcular los semestres, si es par o no
par(X) :- 0 is X mod 2.
impar(X) :- 1 is X mod 2.

%para saber si es miembro de una lista
es_miembro(X,[X|_]).
es_miembro(X,[_|T]):-
    es_miembro(X,T).


%Solucion pregunta #2
%profesor, semestre, curso, disponibilidad, imparte
solucion(Profesor, Curso, Semestre,Dia) :-
    curso(_,Curso, _, _, Semestre, _),
    profesor(_,Profesor, _, _),
    imparte(_,Profesor, Curso),
    dia(_,Dia),
    disponibilidad(_,Profesor, Dia).

%regla para imprimir informacion
imprime([]).
imprime([X|Xs]) :-
    nl, write(X),
    imprime(Xs).


%regla para buscar horarios por medio de una lista de cursos
buscar_cursos([],Lista):-
    imprime(Lista).
buscar_cursos([X|Xs], Lista):-
    curso(Id_curso, X, Asignatura, Creditos, Semestre, Dias),
    aula(Id_aula, Nombre_aula, Capacidad, Asignatura),
    dia(Id_dia, Dia),
    leccion(Id_Leccion, Nombre_leccion, Dia, Hora_inicio, Hora_salida),
    %profesor(Id_profesor, Nombre_profesor, Apellidos, Cedula),
    %imparte(_, Nombre_profesor, X),
    %disponibilidad(_, Nombre_profesor, Dia),
    Lista_nueva is [Id_dia,Id_Leccion,Id_curso,Id_aula],
    not(member(Lista_nueva,Lista)),
    buscar_cursos(Xs, [Lista_nueva|Lista]).


%se obtienen todos los horarios sin importar el semestre
todos_horarios(Resultado) :-
    findall(
        Profesor-Curso-Dia1-Dia2-Leccion1-Leccion2-Aula-Semestre,
       (
       horario(Profesor, Curso,Dia1,Dia2, Leccion1,Leccion2, Aula, Semestre)
       ),Resultado).

%se obtienen todos los horarios por semestre
todos_horarios_semestre(Resultado, Semestre) :-
    findall(
        Profesor-Curso-Dia1-Dia2-Leccion1-Leccion2-Aula-Semestre,
       (
       horario(Profesor, Curso,Dia1,Dia2, Leccion1,Leccion2, Aula, Semestre)
       ),Resultado).


%reglas para obtener las relaciones de los horarios de un solo dia
horario(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(_,Profesor, _,_),
    curso(_,Curso,Tipo,_,Semestre, Dias ),
    Dias = 1,
    dia(_,Dia),
    dia(_,Dia2),
    Dia = Dia2,
    leccion(_,Leccion, Dia, _, _),
    leccion(_,Leccion2, Dia2, _, _),
    not(Leccion = Leccion2),
    aula(_,Aula, _, Tipo),
    disponibilidad(_,Profesor, Dia),
    imparte(_,Profesor, Curso).

%reglas para obtener las relaciones de los horarios de dos dias
horario(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    profesor(_,Profesor, _,_),
    curso(_,Curso,Tipo,_,Semestre, Dias ),
    Dias = 2,
    dia(_,Dia2),
    dia(_,Dia), %OR
    not(Dia = Dia2),
    leccion(_,Leccion, Dia, _, _),
    leccion(_,Leccion2, Dia2, _, _),
    aula(_,Aula, _, Tipo),
    disponibilidad(_,Profesor, Dia),
    imparte(_,Profesor, Curso).




%buscar_horario(["diseno", "taller"],Profesor,Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre).
buscar_horario([]).

buscar_horario([X|Xs]):-
    horario(Profesor, X,Dia,Dia2, Leccion,Leccion2, Aula, Semestre),
    not(reservado(_ ,X,Dia,Dia2, Leccion,Leccion2, Aula, _) ),
    not(reservado(_ ,X,Dia,Dia2, Leccion2,Leccion, Aula, _) ),
    reservar(Profesor,X,Dia,Dia2, Leccion,Leccion2, Aula, Semestre),
    buscar_horario(Xs).


reservar(Profesor,Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre) :-
    assert(reservado(Profesor,Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre)).
