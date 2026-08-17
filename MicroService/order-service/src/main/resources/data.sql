INSERT INTO orders (order_status, total_price)
VALUES ('PENDING', 90500.00),
       ('CONFIRMED', 56800.00),
       ('PENDING', 32000.00),
       ('CANCELLED', 103500.00),
       ('CONFIRMED', 7300.00);

INSERT INTO order_item (product_id, quantity, order_id)
VALUES (1, 1, 1),
       (3, 2, 1),

       (2, 1, 2),
       (3, 1, 2),

       (4, 1, 3),

       (1, 1, 4),
       (2, 1, 4),
       (3, 1, 4),

       (2, 1, 5);