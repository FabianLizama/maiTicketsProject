INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (1, 'John Doe', 'john.doe@example.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (2, 'FELIPE FUENTES LEADERSHIP', 'FELIPE_FUENTES_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (3, 'JOSEFINA MUNOZ LEADERSHIP', 'FELIPE_FUENTES_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (4, 'FREDY MERCURY LEADERSHIP', 'FREDY_MERCURY_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (5, 'FERNANDO SOLIS LEADERSHIP', 'FERNANDO_SOLIS_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (6, 'ANDRE COSIO LEADERSHIP', 'ANDRE_COSIO_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (7, 'NICOLAS AGUILERA LEADERSHIP', 'NICOLAS_AGUILERA_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (8, 'VALENTINA CAMPOS LEADERSHIP', 'VALENTINA_CAMPOS_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (9, 'FABIAN LIZAMA LEADERSHIP', 'FABIAN_LIZAMA_L@maitickets.com', '1234');
INSERT INTO public.leadership(id_leadership, name, email, password) VALUES (10, 'Leadership Name', 'Leadership@maitickets.com', '1234');


INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (1, 'FABIAN_LIZAMA@maitickets.com', 'FABIAN LIZAMA', '1234', 1);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (2, 'VALENTINA_CAMPOS@maitickets.com', 'VALENTINA CAMPOS', '1234', 2);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (3, 'NICOLAS_AGUILERA@maitickets.com', 'NICOLAS AGUILERA', '1234', 3);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (4, 'FERNANDO_SOLIS@maitickets.com', 'FERNANDO SOLIS', '1234', 4);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (5, 'ANDRE_COSIO@maitickets.com', 'ANDRE COSIO', '1234', 5);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (6, 'RABO_ALEJANDRO@maitickets.com', 'RABO ALEJANDRO', '1234', 6);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (7, 'analyzer@maitickets.com', 'Analyzer Name', 'analyzer_password', 7);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (8, 'FREDY_MERCURY@maitickets.com', 'FREDY MERCURY', '1234', 8);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (9, 'FELIPE_FUENTES@maitickets.com', 'FELIPE FUENTES', '1234', 9);
INSERT INTO public.analyzer (id_analyzer, email, name, password, id_leadership) VALUES (10, 'JOSEFINA_MUNOZ@maitickets.com', 'JOSEFINA MUNOZ', '1234', 10);

INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (1, 'Departamento de Informatica', 1);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (2, 'Facultad de Ciencias Sociales', 2);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (3, 'Facultad de Ingenieria', 3);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (4, 'Facultad de Matematicas', 4);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (5, 'Facultad de Medicina', 5);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (6, 'Facultad de Derecho', 6);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (7, 'Departamento de Fisica', 7);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (8, 'Escuela de Artes y Oficio', 8);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (9, 'Departamento de Biologia', 9);
INSERT INTO public.academic_unit (id_academic_unit, name, id_leadership) VALUES (10, 'Escuela de Arquitectura', 10);

INSERT INTO public.client(id_client, email, last_namem, last_namep, name, password, rut) VALUES (1,'carolina@gmail.com','Moncada', 'Bobadilla','Carolina', '1234','21300678-1');
INSERT INTO public.client(id_client, email, last_namem, last_namep, name, password, rut) VALUES (2,'diego@gmail.com','Fernandez', 'Valdes','Diego', '1234','20847708-0');
INSERT INTO public.client(id_client, email, last_namem, last_namep, name, password, rut) VALUES (3,'ian@gmail.com','Mariane', 'Anthoine','Ian', '1234','20890456-K');
INSERT INTO public.client(id_client, email, last_namem, last_namep, name, password, rut) VALUES (4,'carlos@gmail.com','Vera', 'Vera','Carlos', '1234','20089987-1');
