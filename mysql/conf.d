# Performance Schema
performance_schema=ON

# Error handling
max_error_count=64
log_error_verbosity=3

# Security Options
local_infile=0
secure_file_priv=/var/lib/mysql-files

# SQL Mode
sql_mode=STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION

# Timeout Settings
wait_timeout=28800
interactive_timeout=28800

[client]
default-character-set=utf8mb4

[mysql]
default-character-set=utf8mb4