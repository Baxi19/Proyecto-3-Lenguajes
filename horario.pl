%horario de ejemplo

start :- dynamic(dia/2),
         consult('dia.pl'),
         buscar(l,Y),
         write(Y).
