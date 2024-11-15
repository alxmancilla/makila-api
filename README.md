# Mstore: Dellstore Migration to MongoDB

__SA team__: Austin 2 </br> 
[Ade Williams](mailto:ade.williams@mongodb.com) <br/>
[Sam Clifton](mailto:sam.clifton@mongodb.com) <br/>
[Ali Elhawari](mailto:ali.elhawari@mongodb.com) <br/>
[Alejandro Mancilla](mailto:alejandro@mongodb.com) <br/>
[Carter Olson](mailto:carter.olson@mongodb.com) <br/>
[Christian McIntosh](mailto:christian.mcintosh@mongodb.com) <br/>
[Enrique Berrios](mailto:enrique.berrios@mongodb.com) <br/>
[Sahib Chandnani](mailto:sahib.chandnani@mongodb.com) <br/>
[Vasanth Kumar](mailto:vasanth.kumar@mongodb.com) <br/>

__Time to setup__: 30 mins <br/>
__Time to execute__: 45 mins <br/>

## Description

Our project Mstore: Dellstore Migration to MongoDB focuses on highlighting the customer journey who replace their relational databases with MongoDB. When we engage with Replace use cases, determining that MongoDB is a suitable database is only the first step to consumption. The next step is to set up MongoDB and migrate data. This step is often confusing for customers who come from a relational background. Our project aims to highlight this journey by migrating the Sakila database onto MongoDB, creating an API that can use both Postgres and MongoDB data layers, and finally load testing both implementations of the data layer. Through this, our team demonstrates not only the viability of MongoDB as a replacement for relational databases but also the enhancements that utilizing MongoDB brings.

We chose Dellstore as the database to migrate because it models a well known business model, dvd rentals. By focusing on migrating the Dellstore, customers will see that established business models can be adequately modeled with MongoDB.

While Migrating Dellstore to MongoDB, we ran into a variety of bumps along the way. We found that developing with Postgres is much harder than working with MongoDB. Not only was deploying a Postgres database much harder, but Postgres APIs were also much harder to implement than MongoDB APIs. The majority of our time was spent working with Postgres. This indicates that developer productivity is much greater with MongoDB.


## Setup

__1. Create a multi-AZ DB cluster, M5 class (2vCPUs and 8GB RAM), for Postgres using AWS RDS. 3 instances deployed in multiple AZ. See [Creating a Multi-AZ DB cluster for Amazon RDS](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/create-multi-az-db-cluster.html).__
 
__2. Create a single region cluster, M30 instance type (2vCPUs and 8GB RAM), using MongoDB Atlas in AWS. See [Create a Cluster](https://www.mongodb.com/docs/atlas/tutorial/create-new-cluster/).__

__3. Setup your local machine an install following tools:__

* Install JDK 17
```bash
brew install openjdk@17
```

* Install Apache Maven
```bash
brew install maven
```
* Install Apache JMeter
```bash
wget https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.6.3.tgz
tar -xf apache-jmeter-5.6.3.tgz 
```
* Add JMeter to your PATH environment
```bash
export PATH:$PATH:apache-jmeter-5.6.3/bin
```

* Download dataset from [Dell DVD Store Database Test Suite](https://linux.dell.com/dvdstore/)

```bash
wget https://linux.dell.com/dvdstore/ds21_postgresql.tar.gz
```
or
```bash
curl -O https://linux.dell.com/dvdstore/ds21_postgresql.tar.gz
```
* Import dataset into your PostgreSQL cluster.



__4. Install Relational Migrator. See [Relationa Migrator installation guide](https://www.mongodb.com/docs/relational-migrator/installation/).__


## Instructions

__1. Clone this repository:__

```bash
git clone https://github.com/alxmancilla/makila-api.git
```

__2. Set up environment variables required on YAML file ```api/src/main/resources/application.yml```__

__3. Import a new project into Relational Migrator using file ```api/src/main/resources/static/Mstore.relmig```. See [Import a project](https://www.mongodb.com/docs/relational-migrator/projects/import-project/)__

__4. Open Mstore project within Relational Migrator and visualize Relational and Document data models. Learn [schema design patterns in MongoDB] (https://www.mongodb.com/docs/manual/data-modeling/design-patterns/).__ 

__5. Migrate data from PostgreSQL to MongoDB by creating a Snapshot job in Relational Migrator. See [create a sync job](https://www.mongodb.com/docs/relational-migrator/jobs/sync-jobs/).__


__6. Compile project and generate jar file__

* Execute ```maven``` command inside api folder
```bash
cd api
mvn clean package
```

* Execute jar file
```bash
java -jar target/mstore-api-1.0.jar 
```


__7. Test REST API__ 

* For PostgreSQL:

Get an order by id:
```bash
curl -v localhost:8080/api/pg/order/10 
```

Insert an order:
```bash
curl -X POST localhost:8080/api/pg/order/ -H 'Content-type:application/json' -d '{"customerId":14771,"netAmount":256.00,"tax":21.12,"totalAmount":277.12,"orderDate":"2024-10-09T00:00:00","items":[{"id":1,"prodId":6879,"quantity":1,"orderDate":"2024-10-09T00:00:00"}]}'
```

* For MongoDB:

Get an order by id:
```bash
 curl -v localhost:8080/api/mdb/order/10 
```

Insert an order:
```bash
curl -X POST localhost:8080/api/mdb/order/ -H 'Content-type:application/json' -d '{"customerId":14771,"netAmount":256.00,"tax":21.12,"totalAmount":277.12,"orderDate":"2024-10-09T00:00:00","items":[{"id":1,"prodId":6879,"quantity":1,"orderDate":"2024-10-09T00:00:00"}]}'
```

## Performance load testing 

* To run it for PostgreSQL:
```bash
jmeter.sh -n -t api/src/main/resources/static/pgLoadTesting.jmx -l pg_results.jtl
```

* To run it for MongoDB:
```bash
jmeter.sh -n -t api/src/main/resources/static/mdbLoadTesting.jmx -l mdb_results.jtl
```

## Results

Open pg_results.jtl and mdb_results.jtl files and compare results.

In our testing MongoDB had 8x more throughput using the same data set and infrastructure


