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
    curso(Curso, _, _, Semestre, _),
    profesor(Profesor, _, _),
    imparte(Profesor, Curso),
    dia(Dia),
    disponibilidad(Profesor, Dia).


