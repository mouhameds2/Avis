
CREATE OR REPLACE FUNCTION update_timestamp() RETURNS TRIGGER AS $$
BEGIN
    NEW.mis_ajour := CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_timestamp_trigger
    BEFORE UPDATE ON client
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();
ALTER TABLE client ADD COLUMN creation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP;



ALTER TABLE client ADD mis_a_jour timestamp NOT NULL;

