INSERT INTO position (symbol, quantity)
VALUES ('NN', 48), ('ASR', 48)
ON CONFLICT (symbol) DO UPDATE
SET quantity = EXCLUDED.quantity;
