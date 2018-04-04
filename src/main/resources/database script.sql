CREATE DATABASE hello_db WITH 
TEMPLATE = template0 
ENCODING = 'UTF8' 
LC_COLLATE = 'Ukrainian_Ukraine.1251' 
LC_CTYPE = 'Ukrainian_Ukraine.1251';


ALTER DATABASE hello_db OWNER TO "hello_user";


\connect hello_db