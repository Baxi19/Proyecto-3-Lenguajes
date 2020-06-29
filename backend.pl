% Proyecto #3 de Lenguajes de Programacion.
% Randald Villegas Brenes
% 29/06/2020


%horas de las lecciones
leccion1("7:55","8:45").
leccion2("8:50","9:40").
leccion3("9:45","10:35").
leccion4("10:40","11:30").

leccion5("12:30","1:20").
leccion6("1:25","2:15").
leccion7("2:20","3:10").
leccion8("3:15","4:05").


%horarios semanales
horario(lunes,"7:55","8:45").
horario(lunes,"8:50","9:40").
horario(lunes,"9:45","10:35").
horario(lunes,"10:40","11:30").
horario(lunes,"12:30","1:20").
horario(lunes,"1:25","2:15").
horario(lunes,"2:20","3:10").
horario(lunes,"3:15","4:05").

horario(martes,"7:55","8:45").
horario(martes,"8:50","9:40").
horario(martes,"9:45","10:35").
horario(martes,"10:40","11:30").
horario(martes,"12:30","1:20").
horario(martes,"1:25","2:15").
horario(martes,"2:20","3:10").
horario(martes,"3:15","4:05").


horario(miercoles,"7:55","8:45").
horario(miercoles,"8:50","9:40").
horario(miercoles,"9:45","10:35").
horario(miercoles,"10:40","11:30").
horario(miercoles,"12:30","1:20").
horario(miercoles,"1:25","2:15").
horario(miercoles,"2:20","3:10").
horario(miercoles,"3:15","4:05").

horario(jueves,"7:55","8:45").
horario(jueves,"8:50","9:40").
horario(jueves,"9:45","10:35").
horario(jueves,"10:40","11:30").
horario(jueves,"12:30","1:20").
horario(jueves,"1:25","2:15").
horario(jueves,"2:20","3:10").
horario(jueves,"3:15","4:05").

horario(viernes,"7:55","8:45").
horario(viernes,"8:50","9:40").
horario(viernes,"9:45","10:35").
horario(viernes,"10:40","11:30").
horario(viernes,"12:30","1:20").
horario(viernes,"1:25","2:15").
horario(viernes,"2:20","3:10").
horario(viernes,"3:15","4:05").


% profesor(nombre, cédula, [disponibilidad de horario], [cursos que
% imparte])
profesor("Alejandro Alfaro Quesada", 209870845, [], ["Analisis Y Diseño De Algoritmos"]).



% curso(Codigo,Materia,Horas,Creditos)

%curso("CA3125","Analisis Y Diseño De Algoritmos",3.5, 3).

%curso("IC1400","Fundamentos De Organizacion De Computadoras",3.5, 3).



curso("CA3125","Analisis Y Diseño De Algoritmos",3.5, 3).


curso(prolog,horario(lunes,9,12),profesor(eduardo,morales),lugar(ccc,8301)).
