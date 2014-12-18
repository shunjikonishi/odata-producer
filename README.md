# OData producer

This is an OData Procuder app for PostgreSQL.
I developed it as External DataSource for Salesforce.

## Install & Build

```
git clone https://github.com/shunjikonishi/odata-producer
cd odata-producer
mvn package

export DATABASE_URL=postgres://postgres:postgres@localhost/postgres
./run.sh
```

If you want to use this with sample data.  
Please run sql/testdata.sql.

So you can access odata with http://localhost:5000/odata

## Customize
This app includes 2 samples entities.(Car.java, Maker.java)

Like these, you can make your own entity class.
All entities are exposed as OData.

Of course you can remove sample files.

## Run on Heroku
This app can run on Heroku.  
If you want to use basic authentication, you should set following config variable.

```
heroku create
git push heroku master
heroku config:set "APP_OPTS=--enable-basic-auth --basic-auth-user testuser --basic-auth-pw password"
```

## License
MIT