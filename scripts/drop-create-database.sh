#!/bin/bash
set -e

# This script is used to drop and recreate the meta-data tables

docker exec some-postgres psql -f /src/sql/schema-drop-meta-tables.sql -U postgres
docker exec some-postgres psql -f /src/sql/schema-create-meta-tables.sql -U postgres
