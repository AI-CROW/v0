CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO site (id, name, url, accuracy) VALUES (uuid_generate_v4(), 'Coindesk', 'https://coindesk.com', 0.000);