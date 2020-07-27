%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%REGLAS
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
:- dynamic reservado/2.
reservado(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre).



%Solucion pregunta #2
%profesor, semestre, curso, disponibilidad, imparte
solucion(Profesor, Curso, Semestre) :-
    profesor(Profesor, _, _),
    curso(Curso, _, _, Semestre, _),
    imparte(Profesor, Curso).

%regla para imprimir informacion
imprime([]).
imprime([X|Xs]) :-
    nl, write(X),
    imprime(Xs).

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
    profesor(Profesor, _,_),
    curso(Curso,Tipo,_,Semestre, Dias ),
    Dias = 1,
    dia(Dia),
    dia(Dia2),
    Dia = Dia2,
    leccion(Leccion, Dia, _, _),
    leccion(Leccion2, Dia2, _, _),
    not(Leccion = Leccion2),
    aula(Aula, _, Tipo),
    disponibilidad(Profesor, Dia),
   % not(reservado(_ ,Curso,Dia,Dia2, Leccion,Leccion2, Aula, _)),
    imparte(Profesor, Curso).
    %assert(reservado(Profesor,Curso,Dia,Dia2, Leccion,Leccion2, Aula, Semestre)).


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
    %not(reservado(_ ,Curso,Dia,Dia2, Leccion,Leccion2, Aula, _)),
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


