import groovy.sql.Sql

def db = [url:'jdbc:hsqldb:file:/tmp/testDB', user:'sa', password:'', driver:'org.hsqldb.jdbcDriver']
def ds = new org.hsqldb.jdbc.jdbcDataSource()
ds.database=db.url
ds.user=db.user
ds.password=db.password

def sql = Sql.newInstance(ds)

sql.execute '''
    drop table EVENTS if exists;
    create table EVENTS (
        event varchar(250)
    );
  '''
  
sql.execute("INSERT INTO events (event) VALUES ('Hello Test')")
sql.commit()
println sql.rows('select * from EVENTS')
sql.close()
