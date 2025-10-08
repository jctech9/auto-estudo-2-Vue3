SELECT * FROM funcionarios;

SELECT * FROM supervisor;

SELECT * FROM usuario;

SELECT * FROM setores;


ALTER TABLE supervisor ALTER COLUMN usuario_id DROP NOT NULL;


DELETE FROM setores
WHERE id = 'cc0bb31c-d1df-4205-9bf0-a9f259bbd7cc';

DELETE FROM funcionarios
WHERE id = 'cc0bb31c-d1df-4205-9bf0-a9f259bbd7cc';

SELECT * FROM setores WHERE id = 'deefb541-714f-45bd-986b-85fbdb96015e';
