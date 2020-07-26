%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%REGLAS
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

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


horario(Profesor, Curso,Dia,Dia2, Leccion1,Leccion2, Aula) :-
    horario_temp(Profesor, Curso,Dia,Dia2, Leccion1,Leccion2, Aula, []).

horario_temp(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Lista) :-
    profesor(_,Profesor, _,_),
    curso(_,Curso,Tipo,_,_, Dias ),
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

horario_temp(Profesor, Curso,Dia,Dia2, Leccion,Leccion2, Aula, Lista) :-
    profesor(_,Profesor, _,_),
    curso(_,Curso,Tipo,_,_, Dias ),
    Dias = 2,
    dia(_,Dia2),
    dia(_,Dia), %OR
    not(Dia = Dia2),
    leccion(_,Leccion, Dia, _, _),
    leccion(_,Leccion2, Dia2, _, _),
    aula(_,Aula, _, Tipo),
    disponibilidad(_,Profesor, Dia),
    imparte(_,Profesor, Curso).
